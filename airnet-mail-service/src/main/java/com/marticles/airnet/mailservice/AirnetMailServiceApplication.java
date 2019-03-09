package com.marticles.airnet.mailservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class AirnetMailServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirnetMailServiceApplication.class, args);
    }

}
