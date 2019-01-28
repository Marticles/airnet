package com.marticles.airnet.mainservice.model;

import lombok.Data;

/**
 * @author Marticles
 * @description WeatherInfo
 * @date 2019/1/28
 */
@Data
public class WeatherInfo {
    private String city;
    private String time;
    private Float temperature;
    private String weather;
    private String airStatus;
    private String airInfo;
}
