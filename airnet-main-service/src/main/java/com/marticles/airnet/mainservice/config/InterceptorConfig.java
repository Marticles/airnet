package com.marticles.airnet.mainservice.config;

import com.marticles.airnet.mainservice.interceptor.AdminInterceptor;
import com.marticles.airnet.mainservice.interceptor.AuthInterceptor;
import com.marticles.airnet.mainservice.interceptor.UserLocalInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 拦截器配置
 * 排除静态资源
 *
 * @author Marticles
 * @description InterceptorsConfiguration
 * @date 2019/1/23
 */
@Component
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Autowired
    private UserLocalInterceptor userLocalInterceptor;

    @Autowired
    private AuthInterceptor authInterceptor;

    @Autowired
    private AdminInterceptor adminInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userLocalInterceptor).excludePathPatterns("/static/*");
//        registry.addInterceptor(authInterceptor).excludePathPatterns("/static/*"
//                ,"/","/check_user","/viz/airflowmap","/viz/aqimap"
//                ,"/viz/globalmap","/rank/cn","/info","/about-airnet"
//                ,"/login","/register","/403","/404","/api-key");
//        registry.addInterceptor(adminInterceptor).excludePathPatterns("/static/*").addPathPatterns("/admin/**");
//
        super.addInterceptors(registry);
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }

}
