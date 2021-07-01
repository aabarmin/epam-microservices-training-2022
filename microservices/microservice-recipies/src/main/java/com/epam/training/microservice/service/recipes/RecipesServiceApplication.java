package com.epam.training.microservice.service.recipes;

import com.epam.training.microservice.service.recipes.model.Recipe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
public class RecipesServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(RecipesServiceApplication.class, args);
    }

//    @Bean
//    public Consumer<String> deliveryNotificator() {
//        return (recipe) -> {};
//    }
}
