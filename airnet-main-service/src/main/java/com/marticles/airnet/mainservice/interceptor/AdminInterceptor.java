package com.marticles.airnet.mainservice.interceptor;

import com.marticles.airnet.mainservice.model.User;
import com.marticles.airnet.mainservice.model.UserLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Marticles
 * @description AuthInterceptor
 * @date 2019/3/16
 */
@Component
public class AdminInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    UserLocal userLocal;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        if (null != userLocal.getUser()) {
            User user = userLocal.getUser();
            if (!user.getType().equals(0)) {
                response.sendRedirect("/403");
                return false;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        userLocal.remove();
    }
}
