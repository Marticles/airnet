package com.marticles.airnet.dataservice.model;

import lombok.Data;

/**
 * @author Marticles
 * @description Rank
 * @date 2019/2/7
 */
@Data
public class Rank implements Comparable<Rank>{
    String site;
    Integer aqi;
    String level;
    String primaryPollutant;
    Float pm25;
    Float pm10;
    Float co;
    Float no2;
    Float oZone;
    Float so2;

    @Override
    public int compareTo(Rank o) {
        return this.aqi.compareTo(o.getAqi());
    }
}
