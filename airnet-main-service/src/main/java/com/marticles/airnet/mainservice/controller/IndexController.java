package com.marticles.airnet.mainservice.controller;

import com.marticles.airnet.mainservice.model.User;
import com.marticles.airnet.mainservice.model.UserLocal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Marticles
 * @description IndexController
 * @date 2019/1/21
 */
@Slf4j
@Controller
public class IndexController {

    @Autowired
    UserLocal userLocal;

    @GetMapping("/")
    public String index(Model model) {
        User user = userLocal.getUser();
        if (null != user) {
            model.addAttribute("isLogin", "true");
        } else {
            model.addAttribute("isLogin", "false");
        }
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
