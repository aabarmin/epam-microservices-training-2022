package com.epam.training.microservice.service.recipes.service.drugs;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "drug-service")
@ConditionalOnProperty(prefix = "drug-feign", value = "type", havingValue = "eureka")
public interface DrugServiceFeignWithEurekaClient extends DrugFeignClient {

}
