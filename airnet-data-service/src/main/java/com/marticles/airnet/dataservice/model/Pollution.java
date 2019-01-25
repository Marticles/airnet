package com.marticles.airnet.dataservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author Marticles
 * @description pollution
 * @date 2019/1/25
 */
@Data
public class Pollution {
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    Date time;
    String city;
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
}

