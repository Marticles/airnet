package com.marticles.airnet.mainservice.model;

import lombok.Data;

/**
 * @author Marticles
 * @description SiteRank
 * @date 2019/2/7
 */
@Data
public class SiteRank implements Comparable<SiteRank>{
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
    public int compareTo(SiteRank o) {
        return this.aqi.compareTo(o.getAqi());
    }
}
