package com.marticles.airnet.mainservice.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.marticles.airnet.mainservice.constant.AirNetConstants;
import com.marticles.airnet.mainservice.model.BMapInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 主页数据服务
 *
 * @author Marticles
 * @description OtherService
 * @date 2019/1/28
 */
@Service
public class IndexService {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private final String IndexPm25Info_PREFIX = "IndexPm25Info-";
    private final String IndexPm25Time_PREFIX = "IndexPm25Time-";
    private final String BMAP_PREFIX = "BMap-";

    @Autowired
    DataService dataService;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 获取地图中的监测站数据
     *
     * @param site
     * @return com.marticles.airnet.mainservice.model.BMapInfo
     * @author Marticles
     * @date 2019/2/2
     */
    public BMapInfo getBMapInfo(String site) throws Exception {
        BMapInfo bMapInfo = new BMapInfo();
        JSONObject siteUpdatedTime = dataService.getSiteUpdatedTime(AirNetConstants.VISITOR_JWT, site);
        Date date = null;
        if (null == siteUpdatedTime) {
            date = SIMPLE_DATE_FORMAT.parse(AirNetConstants.DEFAULT_UPDATEDTIME);
        } else {
            date = SIMPLE_DATE_FORMAT.parse(siteUpdatedTime.getString("updatedTime"));
        }
        if (stringRedisTemplate.hasKey(BMAP_PREFIX + site + "-" + String.valueOf(siteUpdatedTime.getString("updatedTime")))) {
            String bMapString = stringRedisTemplate.opsForValue().get(BMAP_PREFIX + site + "-" + String.valueOf(siteUpdatedTime.getString("updatedTime")));
            bMapInfo = JSONObject.parseObject(bMapString, BMapInfo.class);
        } else {
            JSONObject data = dataService.getAllPollution(AirNetConstants.VISITOR_JWT, site,
                    SIMPLE_DATE_FORMAT.format(date),
                    SIMPLE_DATE_FORMAT.format(date));
            if (null == data) {
                bMapInfo.setAqi(0F);
                bMapInfo.setInfo("null");
            } else {
                JSONObject pollutionJSONObject = data.getJSONObject("pollution");
                bMapInfo.setAqi(pollutionJSONObject.getJSONArray("aqi").getFloat(0));
                String aqi = pollutionJSONObject.getJSONArray("aqi").getString(0);
                String level = pollutionJSONObject.getJSONArray("level").getString(0);
                String primaryPollutant = pollutionJSONObject.getJSONArray("primaryPollutant").getString(0);
                String pm25 = pollutionJSONObject.getJSONArray("pm25").getString(0);
                String pm10 = pollutionJSONObject.getJSONArray("pm10").getString(0);
                String co = pollutionJSONObject.getJSONArray("co").getString(0);
                String no2 = pollutionJSONObject.getJSONArray("no2").getString(0);
                String ozone = pollutionJSONObject.getJSONArray("ozone").getString(0);
                String so2 = pollutionJSONObject.getJSONArray("so2").getString(0);
                String info = "<br>【AQI:" + aqi + "】 【等级:" + level + "】 【主要污染物:" + primaryPollutant + "】 【PM2.5:" + pm25 + "】 <br> 【PM10:" + pm10 + "】 【CO:" + co + "】 【NO2:" + no2 + "】 【O3:" + ozone + "】 【SO2:" + so2 + "】";
                bMapInfo.setInfo(info);
            }

            stringRedisTemplate.opsForValue().set(BMAP_PREFIX + site + "-" + String.valueOf(siteUpdatedTime.getString("updatedTime")), JSONObject.toJSONString(bMapInfo), 30, TimeUnit.MINUTES);
        }
        return bMapInfo;
    }

    /**
     * 获取首页监测站地图数据的最后更新时间
     *
     * @param
     * @return java.lang.String
     * @author Marticles
     * @date 2019/2/2
     */
    public String getIndexUpdatedTime() {
        JSONObject siteUpdatedTime = dataService.getSiteUpdatedTime(AirNetConstants.VISITOR_JWT, AirNetConstants.DEFAULT_SITE);
        if (null == siteUpdatedTime) {
            return AirNetConstants.DEFAULT_UPDATEDTIME;
        } else {
            return siteUpdatedTime.getString("updatedTime");
        }
    }


    /**
     * 获取最新七天PM2.5数据，取24小时均值用于首页展示
     *
     * @param
     * @return java.util.List<java.lang.Float>
     * @author Marticles
     * @date 2019/1/29
     */
    public List<Float> getIndexPm25Info() throws Exception {
        JSONObject siteUpdatedTime = dataService.getSiteUpdatedTime(AirNetConstants.VISITOR_JWT, AirNetConstants.DEFAULT_SITE);
        Date endDate = null;
        List<Float> pm25Array = new ArrayList<>();
        if (null == siteUpdatedTime) {
            endDate = SIMPLE_DATE_FORMAT.parse(AirNetConstants.DEFAULT_UPDATEDTIME);
        } else {
            endDate = SIMPLE_DATE_FORMAT.parse(siteUpdatedTime.getString("updatedTime"));
        }
        if (stringRedisTemplate.hasKey(IndexPm25Info_PREFIX + String.valueOf(siteUpdatedTime.getString("updatedTime")))) {
            String pm25String = stringRedisTemplate.opsForValue().get(IndexPm25Info_PREFIX + String.valueOf(siteUpdatedTime.getString("updatedTime")));
            pm25Array = (List<Float>) JSONArray.parse(pm25String);
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(endDate);
            calendar.add(Calendar.DAY_OF_WEEK, -7);
            Date startDate = calendar.getTime();
            JSONObject data = dataService.getPollution(AirNetConstants.VISITOR_JWT,
                    AirNetConstants.DEFAULT_SITE,
                    AirNetConstants.DEFAULT_POLLUTION,
                    SIMPLE_DATE_FORMAT.format(startDate),
                    SIMPLE_DATE_FORMAT.format(endDate));
            if (null == data) {
                return new ArrayList<Float>();
            }
            JSONArray pm25JSONArray = data.getJSONArray("pollution");
            Float temp = 0F;
            int nullValueCounter = 0;
            DecimalFormat df = new DecimalFormat("#.0");
            int i = 0;
            int counter = 1;
            while (pm25Array.size() < 7) {
                if (null != pm25JSONArray.get(i)) {
                    temp += Float.valueOf(pm25JSONArray.get(i).toString());
                    counter++;
                }
                if ((i + 1) % 24 == 0) {
                    pm25Array.add(Float.valueOf(df.format(temp / (24 - nullValueCounter))));
                    temp = 0F;
                    counter = 1;
                }
                if (i >= pm25JSONArray.size() - 1) {
                    break;
                }
                i++;
            }
            stringRedisTemplate.opsForValue().set(IndexPm25Info_PREFIX + String.valueOf(siteUpdatedTime.getString("updatedTime")), JSONObject.toJSONString(pm25Array), 30, TimeUnit.MINUTES);
        }
        return pm25Array;
    }

    /**
     * 获取最新七天PM2.5数据对应的日期
     *
     * @param
     * @return java.util.List<java.lang.String>
     * @author Marticles
     * @date 2019/1/29
     */
    public List<String> getIndexPm25Time() throws Exception {
        List<String> timeList = new ArrayList<>();
        JSONObject siteUpdatedTime = dataService.getSiteUpdatedTime(AirNetConstants.VISITOR_JWT, AirNetConstants.DEFAULT_SITE);
        Date endDate = null;
        if (null == siteUpdatedTime) {
            endDate = SIMPLE_DATE_FORMAT.parse(AirNetConstants.DEFAULT_UPDATEDTIME);
        } else {
            endDate = SIMPLE_DATE_FORMAT.parse(siteUpdatedTime.getString("updatedTime"));
        }
        if (stringRedisTemplate.hasKey(IndexPm25Time_PREFIX + String.valueOf(siteUpdatedTime.getString("updatedTime")))) {
            String timeString = stringRedisTemplate.opsForValue().get(IndexPm25Time_PREFIX + String.valueOf(siteUpdatedTime.getString("updatedTime")));
            timeList = (List<String>) JSONArray.parse(timeString);
        } else {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(endDate);
            calendar.add(Calendar.DAY_OF_WEEK, -7);
            String[] weekDays = {"日", "一", "二", "三", "四", "五", "六"};
            int temp;
            for (int i = 0; i < 7; i++) {
                temp = calendar.get(Calendar.DAY_OF_WEEK) - 1;
                if (temp < 0) {
                    timeList.add(weekDays[0]);
                } else {
                    timeList.add(weekDays[temp]);
                }
                calendar.add(Calendar.DAY_OF_WEEK, 1);
            }
            stringRedisTemplate.opsForValue().set(IndexPm25Time_PREFIX + String.valueOf(siteUpdatedTime.getString("updatedTime")), JSONObject.toJSONString(timeList), 30, TimeUnit.MINUTES);
        }
        return timeList;
    }


}
