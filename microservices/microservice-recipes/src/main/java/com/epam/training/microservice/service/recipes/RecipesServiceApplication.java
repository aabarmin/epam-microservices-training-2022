package com.epam.training.microservice.service.recipes;

import com.epam.training.microservice.service.recipes.service.drugs.DrugFeignConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigurationProperties(DrugFeignConfig.class)
public class RecipesServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RecipesServiceApplication.class, args);
    }
}
