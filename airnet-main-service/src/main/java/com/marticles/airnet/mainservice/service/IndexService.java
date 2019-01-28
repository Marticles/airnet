package com.marticles.airnet.mainservice.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.marticles.airnet.mainservice.util.Global;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Marticles
 * @description OtherService
 * @date 2019/1/28
 */
@Service
public class IndexService {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    VizService vizService;

    /**
     * 返回最新七天PM2.5数据，取24小时均值用于首页展示
     *
     * @param
     * @return java.util.List<java.lang.Float>
     * @author Marticles
     * @date 2019/1/29
     */
    public List<Float> getIndexPm25Info() throws Exception {
        JSONObject siteUpdatedTime = vizService.getSiteUpdatedTime(Global.DEFAULT_SITE);
        Date endDate = null;
        if (null == siteUpdatedTime) {
            endDate = SIMPLE_DATE_FORMAT.parse(Global.DEFAULT_UPDATEDTIME);
        } else {
            endDate = SIMPLE_DATE_FORMAT.parse(siteUpdatedTime.getString("updatedTime"));
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(endDate);
        calendar.add(Calendar.DAY_OF_WEEK, -7);
        Date startDate = calendar.getTime();
        JSONObject data = vizService.getPollution(Global.DEFAULT_SITE,
                Global.DEFAULT_POLLUTION,
                SIMPLE_DATE_FORMAT.format(startDate),
                SIMPLE_DATE_FORMAT.format(endDate));
        JSONArray pm25JSONArray = data.getJSONArray("pollution");
        List<Float> pm25Array = new ArrayList<>();
        Float temp = 0F;
        int nullValueCounter = 0;
        DecimalFormat df = new DecimalFormat("#.00");
        int i = 0;
        int counter = 1;
        while (pm25Array.size() <= 7) {
            if (null != pm25JSONArray.get(i)) {
                temp += Float.valueOf(pm25JSONArray.get(i).toString());
                counter++;
            }
            if (i % 24 == 0) {
                pm25Array.add(Float.valueOf(df.format(temp / (24 - nullValueCounter))));
                temp = 0F;
                counter = 1;
            }
            if (i >= pm25JSONArray.size() - 1) {
                break;
            }
            i++;
        }
        return pm25Array;
    }

    /**
     * 最新七天PM2.5数据对应的日期
     *
     * @param
     * @return java.util.List<java.lang.String>
     * @author Marticles
     * @date 2019/1/29
     */
    public List<String> getIndexPm25Time() throws Exception {
        List<String> timeList = new ArrayList<>();
        JSONObject siteUpdatedTime = vizService.getSiteUpdatedTime(Global.DEFAULT_SITE);
        Date endDate = null;
        if (null == siteUpdatedTime) {
            endDate = SIMPLE_DATE_FORMAT.parse(Global.DEFAULT_UPDATEDTIME);
        } else {
            endDate = SIMPLE_DATE_FORMAT.parse(siteUpdatedTime.getString("updatedTime"));
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(endDate);
        calendar.add(Calendar.DAY_OF_WEEK, -7);
        String[] weekDays = { "日", "一", "二", "三", "四", "五", "六" };
        int temp;
        for (int i = 0; i < 7; i++) {
            temp = calendar.get(Calendar.DAY_OF_WEEK) - 1;
            if (temp < 0){
                timeList.add(weekDays[0]);
            }else {
                timeList.add(weekDays[temp]);
            }
            calendar.add(Calendar.DAY_OF_WEEK, 1);
        }
        return timeList;
    }


}
