package com.epam.training.service.delivery;

import com.epam.training.service.delivery.model.message.RecipeModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@EnableDiscoveryClient
@SpringBootApplication
public class DeliveryServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(DeliveryServiceApplication.class, args);
    }

    @Bean
    public Consumer<RecipeModel> deliveryNotificator() {
        return (recipe) -> {
            // write the code here
            System.out.println(recipe);
        };
    }
}
