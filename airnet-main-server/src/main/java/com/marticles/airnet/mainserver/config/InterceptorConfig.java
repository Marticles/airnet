package com.marticles.airnet.mainserver.config;

import com.marticles.airnet.mainserver.interceptor.UserLocalInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author Marticles
 * @description InterceptorsConfiguration
 * @date 2019/1/23
 */
@Component
public class InterceptorConfig extends WebMvcConfigurationSupport {

    @Autowired
    UserLocalInterceptor userLocalInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userLocalInterceptor).excludePathPatterns("/static/*");
        super.addInterceptors(registry);
    }

    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }


}
