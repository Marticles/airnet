package com.marticles.airnet.mainserver.controller;

import com.marticles.airnet.mainserver.Util.JwtUtil;
import com.marticles.airnet.mainserver.model.User;
import com.marticles.airnet.mainserver.model.UserRequest;
import com.marticles.airnet.mainserver.model.UserType;
import com.marticles.airnet.mainserver.server.AuthServer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Marticles
 * @description LoginController
 * @date 2019/1/21
 */
@Slf4j
@Controller
public class AuthController {

    @Autowired
    AuthServer authServer;


    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    @ResponseBody
    public String addUser(UserRequest user) {
        user.setType(UserType.USER_COMMON);
        authServer.addUser(user);
        return "success";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/check_user")
    @ResponseBody
    public String userLogin(UserRequest userRequest,HttpServletResponse response) {
        User user = authServer.checkUser(userRequest);
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
}
