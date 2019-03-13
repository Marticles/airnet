package com.marticles.airnet.apiservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AirnetApiServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirnetApiServiceApplication.class, args);
    }

}
