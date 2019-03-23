package com.marticles.airnet.mainservice.controller;

import com.marticles.airnet.mainservice.model.*;
import com.marticles.airnet.mainservice.service.AdminService;
import com.marticles.airnet.mainservice.service.ApiKeyService;
import com.marticles.airnet.mainservice.service.NotificationService;
import com.marticles.airnet.mainservice.service.UserService;
import com.marticles.airnet.mainservice.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    private ApiKeyService apiKeyService;

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private UserLocal userLocal;

    @GetMapping("")
    public String admin(Model model) {
        User admin = userLocal.getUser();
        if (null != admin) {
            List<User> userList = userService.getAllUsers(admin.getId());
            model.addAttribute("user", admin);
            model.addAttribute("userList", userList);
            return "/admin/admin_user";
        } else {
            return "/admin/admin_login";
        }
    }

    @GetMapping("/index")
    public String adminIndex(Model model) {
        User admin = userLocal.getUser();
        List<User> userList = userService.getAllUsers(admin.getId());
        model.addAttribute("user", admin);
        model.addAttribute("userList", userList);
        return "/admin/admin_user";
    }

    @GetMapping("/api-key")
    public String adminApiKey(Model model) {
        List<ApiApplication> apiApplicationList = apiKeyService.getApiApplication();
        List<ApiKey> apiKeyList = apiKeyService.getAllApiKey();
        model.addAttribute("apiApplicationList", apiApplicationList);
        model.addAttribute("apiKeyList", apiKeyList);
        return "/admin/admin_apikey";
    }

    @ResponseBody
    @PostMapping("/key/{id}")
    public Response addApiKey(@PathVariable Integer id, @RequestBody ApiApplication apiApplication) throws Exception {
        Response response = new Response();
        try {
            apiKeyService.updateApplicationStatus(id, apiApplication.getStatus());
            if (apiApplication.getStatus().equals(1)) {
                apiKeyService.addApiKey(id, apiApplication.getUserId(), apiApplication.getPreSecondRequestLimit(), apiApplication.getMonthlyRequestLimit());
                notificationService.addApiKeyNotification(apiApplication.getUserId(), apiApplication.getStatus());
            } else {
                notificationService.addApiKeyNotification(apiApplication.getUserId(), apiApplication.getStatus());
            }
            response.setCode(0);
            response.setMsg("success");
        } catch (Exception e) {
            response.setCode(1);
            response.setMsg(e.getMessage());
        }
        return response;
    }

    @ResponseBody
    @PutMapping("/key/{id}")
    public Response updateApiKey(@PathVariable Integer id, @RequestBody ApiApplication apiApplication) {
        Response response = new Response();
        apiKeyService.updateApiKeyWithOutKey(id, apiApplication.getPreSecondRequestLimit(), apiApplication.getMonthlyRequestLimit());
        return response;
    }

    @ResponseBody
    @DeleteMapping("/key/{id}")
    public Response deleteApiKey(@PathVariable Integer id, @RequestBody ApiApplication apiApplication) {
        Response response = new Response();
        apiKeyService.deleteApiKey(id);
        return response;
    }


    @ResponseBody
    @DeleteMapping("/user/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        userService.deleteUser(userId);
    }

    @ResponseBody
    @PutMapping("/user/{userId}")
    public Response UpdatedUser(@RequestBody User user) {
        Response response = new Response();
        try {
            userService.updatedUser(user);
            response.setCode(0);
            response.setMsg("update user info success");
        } catch (Exception e) {
            e.printStackTrace();
            response.setCode(1);
            response.setMsg("update user info fail");
        }
        return response;
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
            jwtCookie.setMaxAge(3600 * 24 * 7);
            userIdCookie.setMaxAge(3600 * 24 * 7);
            response.addHeader("Set-Cookie", "HttpOnly");
            response.addCookie(jwtCookie);
            response.addCookie(userIdCookie);
            log.info("管理员：" + admin.getName() + "登录");
            return "success";
        }
        return "error";
    }
}
