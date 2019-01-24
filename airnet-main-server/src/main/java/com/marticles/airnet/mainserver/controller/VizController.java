package com.marticles.airnet.mainserver.controller;

import com.marticles.airnet.mainserver.model.User;
import com.marticles.airnet.mainserver.model.UserLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Marticles
 * @description VizController
 * @date 2019/1/23
 */
@Controller
@RequestMapping("/viz")
public class VizController {

    @Autowired
    UserLocal userLocal;

    @GetMapping("/line")
    public String line(Model model) {
        User user = userLocal.getUser();
        if (null != user) {
            model.addAttribute("isLogin", "true");
        } else {
            model.addAttribute("isLogin", "false");
        }
        return "/viz/line";
    }
}
