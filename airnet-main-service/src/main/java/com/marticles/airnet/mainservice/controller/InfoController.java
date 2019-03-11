package com.marticles.airnet.mainservice.controller;

import com.marticles.airnet.mainservice.model.User;
import com.marticles.airnet.mainservice.model.UserLocal;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private UserLocal userLocal;

    @GetMapping("/about-api")
    public String aboutApi(Model model){
        return "/about-api";
    }

    @GetMapping("/about-airnet")
    public String aboutAirNet(Model model){
        setUserLoginStatus(model,userLocal.getUser());
        return "/about-airnet";
    }

    @GetMapping("/info")
    public String info(Model model){
        setUserLoginStatus(model,userLocal.getUser());
        return "/info";
    }

    private void setUserLoginStatus(Model model, User user) {
        if (null != user) {
            model.addAttribute("isLogin", "true");
        } else {
            model.addAttribute("isLogin", "false");
        }
    }

}
