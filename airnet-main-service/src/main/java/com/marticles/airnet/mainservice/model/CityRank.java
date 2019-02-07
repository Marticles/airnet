package com.marticles.airnet.mainservice.model;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

/**
 * 全国各城市空气质量排行
 *
 * @author Marticles
 * @description CityRank
 * @date 2019/2/6
 */
@Data
public class CityRank implements Comparable<CityRank>{
    Integer aqi;

    @JSONField(name="quality")
    String level;

    @JSONField(name="pm2_5")
    String pm25;

    @JSONField(name="time_point")
    Date time;

    @JSONField(name="area")
    String city;

    @Override
    public int compareTo(CityRank o) {
        return this.aqi.compareTo(o.getAqi());
    }
}
