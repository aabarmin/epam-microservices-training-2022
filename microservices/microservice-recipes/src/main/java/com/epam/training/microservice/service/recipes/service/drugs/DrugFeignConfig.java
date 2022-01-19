package com.epam.training.microservice.service.recipes.service.drugs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Aleksandr Barmin
 */
@Data
@ConfigurationProperties(prefix = "drug-feign")
public class DrugFeignConfig {
  private DrugFeignType type;
  private String drugServiceUrl;
}
