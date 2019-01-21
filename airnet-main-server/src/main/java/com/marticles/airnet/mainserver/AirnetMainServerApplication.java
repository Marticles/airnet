package com.marticles.airnet.mainserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AirnetMainServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirnetMainServerApplication.class, args);
    }

}

