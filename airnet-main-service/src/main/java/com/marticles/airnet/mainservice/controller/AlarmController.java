package com.marticles.airnet.mainservice.controller;

import com.marticles.airnet.mainservice.model.Alarm;
import com.marticles.airnet.mainservice.model.AlarmRequest;
import com.marticles.airnet.mainservice.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * TODO污染物预警
 * 定时任务框架？
 *
 * @author Marticles
 * @description AlarmController
 * @date 2019/2/6
 */
@Controller
@RequestMapping("/alarm")
public class AlarmController {

    @Autowired
    private AlarmService alarmService;

    @GetMapping("")
    public String alarm(Model model) {
        List<Alarm> alarmList = alarmService.getAlarmList();
        model.addAttribute("alarmList", alarmList);

        return "/alarm";
    }


    @PostMapping("")
    public String addAlarm(@RequestBody AlarmRequest alarmRequest) {

        return null;
    }

    @DeleteMapping("")
    public String delAlarm() {
        return null;
    }


}
