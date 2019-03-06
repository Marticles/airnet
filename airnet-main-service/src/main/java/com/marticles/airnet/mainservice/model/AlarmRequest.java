package com.marticles.airnet.mainservice.model;

import lombok.Data;

/**
 * @author Marticles
 * @description AlarmRequest
 * @date 2019/3/6
 */
@Data
public class AlarmRequest {
    private String site;
    private String pollutant;
    private Float threshold;
    private String email;
}
