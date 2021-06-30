package com.epam.training.miservices.services.drugs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class DrugsServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DrugsServiceApplication.class, args);
    }
}
