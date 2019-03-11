package com.marticles.airnet.mailservice.model;

import lombok.Data;

import java.util.Date;

/**
 * @author Marticles
 * @description Notification
 * @date 2019/3/10
 */
@Data
public class Notification {
    private Integer userId;
    private String title;
    private String subTitle;
    private String content;
    private Integer readStatus;
    private Date createTime;
}
