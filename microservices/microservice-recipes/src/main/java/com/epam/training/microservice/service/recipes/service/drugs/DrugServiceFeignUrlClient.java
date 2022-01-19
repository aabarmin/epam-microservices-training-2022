package com.epam.training.microservice.service.recipes.service.drugs;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author Aleksandr Barmin
 */
@FeignClient(name = "drug-service", url = "${drug-feign.drug-service-url}")
@ConditionalOnProperty(prefix = "drug-feign", value = "type", havingValue = "direct")
public interface DrugServiceFeignUrlClient extends DrugFeignClient {
}
