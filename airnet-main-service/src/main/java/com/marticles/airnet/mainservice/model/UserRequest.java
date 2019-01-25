package com.marticles.airnet.mainservice.model;

import lombok.Data;

/**
 * @author Marticles
 * @description UserRequest
 * @date 2019/1/21
 */
@Data
public class UserRequest {
    private String name;
    private String email;
    private String password;
    private Integer type;
}
