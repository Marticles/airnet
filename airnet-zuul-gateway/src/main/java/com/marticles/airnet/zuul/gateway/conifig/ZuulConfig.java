package com.marticles.airnet.zuul.gateway.conifig;

import com.marticles.airnet.zuul.gateway.fliter.TestFliter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Marticles
 * @description ZuulConfig
 * @date 2019/2/1
 */
@Configuration
public class ZuulConfig {

//    @Bean
//    public AuthFliter authFliter(){
//        return new AuthFliter();
//    }
    @Bean
    public TestFliter testFliter(){
        return new TestFliter();
    }

}
