package com.marticles.airnet.dataservice.model;

import lombok.Data;

import java.util.List;

/**
 * @author Marticles
 * @description pollution
 * @date 2019/1/25
 */
@Data
public class PollutionList {
    List<Integer> aqi;
    List<String> level;
    List<String> primaryPollutant;
    List<Float> pm25;
    List<Float> pm10;
    List<Float> co;
    List<Float> no2;
    List<Float> oZone;
    List<Float> so2;
}

