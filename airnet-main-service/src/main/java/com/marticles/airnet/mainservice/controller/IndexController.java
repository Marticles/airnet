package com.marticles.airnet.mainservice.controller;

import com.marticles.airnet.mainservice.model.User;
import com.marticles.airnet.mainservice.model.UserLocal;
import com.marticles.airnet.mainservice.model.WeatherInfo;
import com.marticles.airnet.mainservice.service.HeWeatherService;
import com.marticles.airnet.mainservice.service.IndexService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author Marticles
 * @description IndexController
 * @date 2019/1/21
 */
@Slf4j
@Controller
public class IndexController {

    @Autowired
    HeWeatherService heWeatherService;

    @Autowired
    IndexService indexService;

    @Autowired
    UserLocal userLocal;

    @GetMapping("/")
    public String index(Model model) throws Exception{
        User user = userLocal.getUser();
        if (null != user) {
            model.addAttribute("isLogin", "true");
        } else {
            model.addAttribute("isLogin", "false");
        }
        WeatherInfo weatherInfo = heWeatherService.getWeatherInfo("shanghai");
        List<Float> pm25List = indexService.getIndexPm25Info();
        List<String> pm25TimeList = indexService.getIndexPm25Time();
        model.addAttribute("pm25TimeList",pm25TimeList);
        model.addAttribute("weatherInfo",weatherInfo);
        model.addAttribute("pm25List",pm25List);
        return "index";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }

    @GetMapping("/403")
    public String error403() {
        return "403";
    }

    @GetMapping("/404")
    public String error404() {
        return "404";
    }
}
