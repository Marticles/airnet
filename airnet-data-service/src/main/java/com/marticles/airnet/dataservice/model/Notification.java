package com.marticles.airnet.dataservice.model;

import lombok.Data;

/**
 * @author Marticles
 * @description Notification
 * @date 2019/3/10
 */
@Data
public class Notification {
    private Integer id;
    private Integer userId;
    private String title;
    private String subTitle;
    private String content;
    private Integer readStatus;
    private String createTime;
}
