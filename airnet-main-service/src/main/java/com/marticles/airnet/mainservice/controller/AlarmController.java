package com.marticles.airnet.mainservice.controller;

import com.alibaba.fastjson.JSONObject;
import com.marticles.airnet.mainservice.model.*;
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
    @ResponseBody
    public Response addAlarm(@RequestBody AlarmRequest alarmRequest) {
        Response response = new Response();
        alarmService.addAlarm(alarmRequest);
        response.setCode(200);
        response.setMsg("success");
        return response;
    }

    @DeleteMapping("")
    @ResponseBody
    public Response delAlarm(@RequestBody JSONObject jsonParam) {
        Response response = new Response();
        alarmService.delAlarm(Integer.valueOf(jsonParam.getString("id")));
        response.setCode(200);
        response.setMsg("success");
        return response;
    }


}
