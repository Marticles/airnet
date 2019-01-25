package com.marticles.airnet.configservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class AirnetConfigServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirnetConfigServiceApplication.class, args);
    }

}

