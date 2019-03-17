package com.marticles.airnet.mainservice.controller;

import com.marticles.airnet.mainservice.model.User;
import com.marticles.airnet.mainservice.model.UserLocal;
import com.marticles.airnet.mainservice.service.AdminService;
import com.marticles.airnet.mainservice.service.UserService;
import com.marticles.airnet.mainservice.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * @author Marticles
 * @description AdminController
 * @date 2019/3/17
 */
@Slf4j
@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserLocal userLocal;

    @GetMapping("")
    public String admin(Model model) {
        return "/admin/admin_login";
    }

    @GetMapping("/index")
    public String adminIndex(Model model) {
        User admin = userLocal.getUser();
        List<User> userList = userService.getAllUsers(admin.getId());
        model.addAttribute("user", admin);
        model.addAttribute("userList", userList);
        return "/admin/admin_user";
    }

    @GetMapping("/check")
    @ResponseBody
    public String checkAdmin(HttpServletResponse response,
                             @RequestParam("name") String name,
                             @RequestParam("password") String password) {
        User admin = adminService.checkAdmin(name, password);
        if (null == admin) {
            return "error";
        }
        if (admin.getType().equals(0)) {
            String jwt_token = JwtUtil.generateJwt(admin);
            Cookie jwtCookie = new Cookie("jwt_token", jwt_token);
            Cookie userIdCookie = new Cookie("user_id", admin.getId().toString());
            jwtCookie.setPath("/");
            userIdCookie.setPath("/");
            // 7天有效
            jwtCookie.setMaxAge(3600 * 24 * 7);
            userIdCookie.setMaxAge(3600 * 24 * 7);
            response.addHeader("Set-Cookie", "HttpOnly");
            response.addCookie(jwtCookie);
            response.addCookie(userIdCookie);
            log.info("用户：" + admin.getName() + "登录");
            return "success";
        }
        return "error";
    }
}
