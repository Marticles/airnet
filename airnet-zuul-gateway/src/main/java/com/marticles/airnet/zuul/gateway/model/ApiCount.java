package com.marticles.airnet.zuul.gateway.model;

import lombok.Data;

/**
 * @author Marticles
 * @description ApiCount
 * @date 2019/3/13
 */
@Data
public class ApiCount {
    private Integer monthlyRequestLimit;
    private Integer monthlyRequestCount;
}
