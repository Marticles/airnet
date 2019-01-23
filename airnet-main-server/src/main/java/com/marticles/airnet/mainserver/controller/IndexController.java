package com.marticles.airnet.mainserver.controller;

import com.marticles.airnet.mainserver.Util.JwtUtil;
import com.marticles.airnet.mainserver.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author Marticles
 * @description IndexController
 * @date 2019/1/21
 */
@Slf4j
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model, HttpServletRequest request) {
        String jwt_token = null;
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("jwt_token")) {
                    jwt_token = cookie.getValue();
                    break;
                }
            }
        }
        if (jwt_token != null) {
            User user = JwtUtil.getUserInfoByJwt(jwt_token);
            model.addAttribute("isLogin", "true");
            model.addAttribute("user",user);
        } else {
            model.addAttribute("isLogin", "false");
        }
        return "index";
    }

    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
