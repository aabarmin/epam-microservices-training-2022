package com.epam.training.microservice.service.recipes;

import com.epam.training.microservice.service.recipes.model.OutgoingRecipe;
import com.epam.training.microservice.service.recipes.model.Recipe;
import com.epam.training.microservice.service.recipes.service.drugs.DrugFeignClient;
import com.epam.training.microservice.service.recipes.service.drugs.DrugFeignConfig;
import com.epam.training.microservice.service.recipes.service.recipe.OutgoingRecipeSender;
import com.epam.training.microservice.service.recipes.service.recipe.OutgoingRecipeService;
import java.util.Collection;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.function.context.PollableBean;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
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
