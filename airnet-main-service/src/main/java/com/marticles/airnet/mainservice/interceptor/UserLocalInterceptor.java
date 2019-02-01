package com.marticles.airnet.mainservice.interceptor;

import com.marticles.airnet.mainservice.model.User;
import com.marticles.airnet.mainservice.model.UserLocal;
import com.marticles.airnet.mainservice.util.CookieUtil;
import com.marticles.airnet.mainservice.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Marticles
 * @description UserLocalInterceptor
 * @date 2019/1/23
 */
@Component
public class UserLocalInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    UserLocal userLocal;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        String jwtToken = CookieUtil.getCookie(request,"jwt_token");
        if (jwtToken != null) {
            User user = JwtUtil.getUserInfoByJwt(jwtToken);
            userLocal.setUser(user);
            userLocal.setJwt(jwtToken);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null && userLocal.getUser() != null) {
            modelAndView.addObject("user", userLocal.getUser());
            modelAndView.addObject("isLogin", "true");
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        userLocal.remove();
    }


}
