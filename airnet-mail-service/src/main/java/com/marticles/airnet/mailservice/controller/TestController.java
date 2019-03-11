package com.marticles.airnet.mailservice.controller;

import com.marticles.airnet.mailservice.server.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Marticles
 * @description TestController
 * @date 2019/3/8
 */
@RestController
public class TestController {

    @Autowired
    AlarmService alarmService;

    @RequestMapping("test")
    public String test(){
        alarmService.checkAlarm();
        return "";
    }

}
