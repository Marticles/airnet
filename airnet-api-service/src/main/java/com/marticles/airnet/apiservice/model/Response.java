package com.marticles.airnet.apiservice.model;

import lombok.Data;

/**
 * @author Marticles
 * @description Response
 * @date 2019/3/13
 */
@Data
public class Response {
    private Integer code;
    private String msg;
    private Info data;
}
