package com.marticles.airnet.mailservice.model;

import lombok.Data;

import java.util.Date;

/**
 * @author Marticles
 * @description Alarm
 * @date 2019/3/6
 */
@Data
public class Alarm {
    private Integer id;
    private String site;
    private String pollutant;
    private Float threshold;
    private String email;
    private Integer userId;
    private Date startTime;
    private Date lastTime;
}
