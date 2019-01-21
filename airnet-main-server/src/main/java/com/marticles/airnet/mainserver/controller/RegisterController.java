package com.marticles.airnet.mainserver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Marticles
 * @description RegisterController
 * @date 2019/1/21
 */
@Controller
public class RegisterController {

    @GetMapping("/register")
    public String register(Model model){
        return "register";
    }



}
