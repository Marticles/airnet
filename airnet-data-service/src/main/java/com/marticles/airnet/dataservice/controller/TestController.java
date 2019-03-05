package com.marticles.airnet.dataservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Marticles
 * @description TestController
 * @date 2019/3/3
 */
@RestController
public class TestController {


    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/test")
    public String getSiteRanks() {

        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set("sad","adasdada");
        System.out.println(stringRedisTemplate.keys("*"));
        return "1";
    }



}
