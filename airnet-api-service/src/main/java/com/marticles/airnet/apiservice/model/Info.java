package com.marticles.airnet.apiservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Marticles
 * @description Info
 * @date 2019/3/13
 */

@Data
@AllArgsConstructor
public class Info<T> implements Serializable {
    private T name;
    private List<T> result;
}
