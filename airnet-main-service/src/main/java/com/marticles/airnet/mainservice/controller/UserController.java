package com.marticles.airnet.mainservice.controller;

import com.marticles.airnet.mainservice.model.User;
import com.marticles.airnet.mainservice.model.UserRequest;
import com.marticles.airnet.mainservice.model.UserType;
import com.marticles.airnet.mainservice.service.UserService;
import com.marticles.airnet.mainservice.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * 用户注册、登录
 *
 * @author Marticles
 * @description LoginController
 * @date 2019/1/21
 */
@Slf4j
@Controller
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    @ResponseBody
    public String addUser(UserRequest user) {
        user.setType(UserType.USER_COMMON);
        userService.addUser(user);
        return "success";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/check_user")
    @ResponseBody
    public String userLogin(UserRequest userRequest,HttpServletResponse response) {
        User user = userService.checkUser(userRequest);
        if (null != user){
            String jwt_token = JwtUtil.generateJwt(user);
            Cookie cookie = new Cookie("jwt_token", jwt_token);
            cookie.setPath("/");
            // 7天有效
            cookie.setMaxAge(3600*24*7);
            response.addCookie(cookie);
            response.addHeader("Set-Cookie", "HttpOnly");
            log.info("用户："+user.getName()+"登录");
            return "success";
        }else{
            return "fail";
        }

    }

    @GetMapping("/logout")
    public String logout(HttpServletResponse response) {
        Cookie cookie = new Cookie("jwt_token", null);
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        response.addHeader("Set-Cookie", "HttpOnly");
        return "redirect:/";
    }


}
