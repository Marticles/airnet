package com.marticles.airnet.mainservice.model;

import lombok.Data;

import java.util.Date;

/**
 * 自定义Log
 *
 * @author Marticles
 * @description Log
 * @date 2019/3/26
 */
@Data
public class Log {
    Integer id;
    Date requestTime;
    String authHeaders;
    String requestURL;
    String userIP;
    String userId;
    String userName;
    String className;
    String methodName;
    String parameters;
    String returnType;
}
