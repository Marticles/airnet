package com.marticles.airnet.mainservice.model;

import lombok.Data;

/**
 * @author Marticles
 * @description ApiKey
 * @date 2019/3/17
 */
@Data
public class ApiKey {
    private Integer id;
    private Integer userId;
    private String userKey;
    private Integer preSecondRequestLimit;
    private Integer monthlyRequestLimit;
    private Integer allRequestCount;
    private String userName;
}
