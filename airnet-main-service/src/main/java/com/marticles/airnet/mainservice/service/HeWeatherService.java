package com.marticles.airnet.mainservice.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.marticles.airnet.mainservice.model.WeatherInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 和风天气API服务
 *
 * @author Marticles
 * @description HeWeatherService
 * @date 2019/1/28
 */
@Slf4j
@Service
public class HeWeatherService {

    private static final String HEWEATHER_KEY = "2b26e67d30f542e49976ec6f923b8c8c";
    private final String HEWEATHER_PREFIX = "HeWeather-";
    volatile Date HEWEATHER_UPDATEDTIME;
    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public WeatherInfo getWeatherInfo(String city) throws Exception {
        Date now = new Date();
        WeatherInfo weatherInfo = new WeatherInfo();
        // 第一次获取或超过30分钟
        if (null == HEWEATHER_UPDATEDTIME || now.getTime() - HEWEATHER_UPDATEDTIME.getTime() > 30 * 60 * 1000) {
            String weatherUrl = "https://free-api.heweather.net/s6/weather/now?location=" + city + "&key=" + HEWEATHER_KEY;
            String lifeStyleUrl = "https://free-api.heweather.net/s6/weather/lifestyle?location=" + city + "&key=" + HEWEATHER_KEY;
            ResponseEntity<String> weatherEntity = restTemplate.getForEntity(weatherUrl, String.class);
            ResponseEntity<String> lifeStyleEntity = restTemplate.getForEntity(lifeStyleUrl, String.class);
            JSONObject weatherInfoJson = null;
            JSONArray lifeStyleJsonArray = null;
            JSONObject lifeStyleJson = null;
            if (weatherEntity.getStatusCodeValue() == HttpStatus.OK.value() || lifeStyleEntity.getStatusCodeValue() == HttpStatus.OK.value()) {
                String weatherBody = formatJson(weatherEntity.getBody());
                String lifeStyleBody = lifeStyleEntity.getBody();
                weatherInfoJson = JSON.parseObject(weatherBody).getJSONObject("HeWeather6");
                lifeStyleJsonArray = JSON.parseObject(lifeStyleBody).getJSONArray("HeWeather6");
                lifeStyleJson = lifeStyleJsonArray.getJSONObject(0).getJSONArray("lifestyle").getJSONObject(7);
            } else {
                log.error("Invoke HeWeather API error! URL:" + weatherUrl);
                log.error("Return :" + weatherEntity);
                log.error("Invoke HeWeather API error! URL:" + lifeStyleUrl);
                log.error("Return :" + lifeStyleEntity);
            }
            JSONObject basic = weatherInfoJson.getJSONObject("basic");
            JSONObject time = weatherInfoJson.getJSONObject("update");
            JSONObject weather = weatherInfoJson.getJSONObject("now");
            weatherInfo.setCity(basic.get("location").toString());
            weatherInfo.setTime(time.get("loc").toString() + ":00");
            weatherInfo.setTemperature(Float.valueOf(weather.get("tmp").toString()));
            weatherInfo.setWeather(weather.get("cond_txt").toString());
            weatherInfo.setAirStatus(lifeStyleJson.get("brf").toString());
            weatherInfo.setAirInfo(lifeStyleJson.get("txt").toString());
            HEWEATHER_UPDATEDTIME = SIMPLE_DATE_FORMAT.parse(time.get("loc").toString() + ":00");
            stringRedisTemplate.opsForValue().set(HEWEATHER_PREFIX + time.get("loc").toString() + ":00", JSONObject.toJSONString(weatherInfo), 60, TimeUnit.MINUTES);
        } else {
            if (stringRedisTemplate.hasKey(HEWEATHER_PREFIX + SIMPLE_DATE_FORMAT.format(HEWEATHER_UPDATEDTIME))) {
                String weatherInfoString = stringRedisTemplate.opsForValue().get(HEWEATHER_PREFIX + SIMPLE_DATE_FORMAT.format(HEWEATHER_UPDATEDTIME));
                weatherInfo = JSONObject.parseObject(weatherInfoString, WeatherInfo.class);
            } else {
                log.error("redis中不存在该key" + HEWEATHER_PREFIX + SIMPLE_DATE_FORMAT.format(HEWEATHER_UPDATEDTIME));
            }
        }
        return weatherInfo;
    }

    private String formatJson(String json) {
        return json.replace("[", "").replace("]", "");
    }

}
