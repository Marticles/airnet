package com.marticles.airnet.mainservice.model;

import lombok.Data;

/**
 * @author Marticles
 * @description ApiApplication
 * @date 2019/3/17
 */
@Data
public class ApiApplication {
    private Integer id;
    private String reason;
    private String sendEmail;
    private Integer userId;
    private String userName;
    private String createTime;
    private Integer status;
    private String key;
    private Integer preSecondRequestLimit;
    private Integer monthlyRequestLimit;

}
