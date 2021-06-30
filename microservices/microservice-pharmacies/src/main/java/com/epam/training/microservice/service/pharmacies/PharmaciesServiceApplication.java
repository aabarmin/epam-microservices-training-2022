package com.epam.training.microservice.service.pharmacies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PharmaciesServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(PharmaciesServiceApplication.class, args);
    }
}
