package com.marticles.airnet.mainservice.controller;

import com.marticles.airnet.mainservice.annotation.MyLogger;
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
 * 主页
 *
 * @author Marticles
 * @description IndexController
 * @date 2019/1/21
 */
@Slf4j
@Controller
public class IndexController {

    @Autowired
    private HeWeatherService heWeatherService;

    @Autowired
    private IndexService indexService;

    @Autowired
    private UserLocal userLocal;

    @MyLogger
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
        String updatedTime = indexService.getIndexUpdatedTime();
        model.addAttribute("pm25TimeList",pm25TimeList);
        model.addAttribute("weatherInfo",weatherInfo);
        model.addAttribute("pm25List",pm25List);
        model.addAttribute("updatedTime",updatedTime);
        model.addAttribute("jingan",indexService.getBMapInfo("jingan"));
        model.addAttribute("hongkou",indexService.getBMapInfo("hongkou"));
        model.addAttribute("pdchuansha",indexService.getBMapInfo("pudongchuansha"));
        model.addAttribute("pdxinqu",indexService.getBMapInfo("pudongxinqu"));
        model.addAttribute("pdzhangjiang",indexService.getBMapInfo("pudongzhangjiang"));
        model.addAttribute("putuo",indexService.getBMapInfo("putuo"));
        model.addAttribute("qingpu",indexService.getBMapInfo("qingpudianshanhu"));
        model.addAttribute("shiwuchang",indexService.getBMapInfo("shiwuchang"));
        model.addAttribute("xuhui",indexService.getBMapInfo("xuhuishangshida"));
        model.addAttribute("yangpu",indexService.getBMapInfo("yangpusipiao"));
        return "index";
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
