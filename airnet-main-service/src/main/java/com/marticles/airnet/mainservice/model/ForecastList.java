package com.marticles.airnet.mainservice.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @author Marticles
 * @description ForecastList
 * @date 2019/5/11
 */
@Data
public class ForecastList {
    List<Float> pollution;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    List<Date> time;
    String pollutionName;
}
