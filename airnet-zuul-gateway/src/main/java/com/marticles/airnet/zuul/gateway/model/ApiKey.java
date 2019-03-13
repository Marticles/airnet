package com.marticles.airnet.zuul.gateway.model;

import lombok.Data;

/**
 * @author Marticles
 * @description ApiKey
 * @date 2019/3/12
 */
@Data
public class ApiKey {
    private Integer id;
    private Integer userId;
    private String userKey;
    private Integer preSecondRequestLimit;
    private Integer dailyRequestLimit;
    private Integer allRequestCount;
}
