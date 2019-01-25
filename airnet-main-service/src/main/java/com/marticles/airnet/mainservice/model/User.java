package com.marticles.airnet.mainservice.model;

import lombok.Data;

/**
 * @author Marticles
 * @description User
 * @date 2019/1/21
 */
@Data
public class User {
    private Integer id;
    private String name;
    private String email;
    private Integer type;
}
