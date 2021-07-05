package com.epam.training.microservice.service.recipes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class RecipesServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RecipesServiceApplication.class, args);
    }
}
