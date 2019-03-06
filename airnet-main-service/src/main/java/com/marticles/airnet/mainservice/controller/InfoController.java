package com.marticles.airnet.mainservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Marticles
 * @description InfoController
 * @date 2019/3/5
 */
@Controller
public class InfoController {

    @GetMapping("/about-api")
    public String aboutApi(Model model){
        return "/about-api";
    }

    @GetMapping("/about-airnet")
    public String aboutAirNet(Model model){
        return "/about-airnet";
    }

    @GetMapping("/info")
    public String info(Model model){
        return "/info";
    }

}
