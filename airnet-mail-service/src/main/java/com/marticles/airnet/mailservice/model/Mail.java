package com.marticles.airnet.mailservice.model;

import lombok.Data;

/**
 * @author Marticles
 * @description Mail
 * @date 2019/3/8
 */
@Data
public class Mail {
    Integer userId;
    String title;
    String email;
    String content;
    String pollutant;
    String send_time;
    Integer alarmId;
}
