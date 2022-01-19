package com.epam.training.microservice.service.recipes.service.drugs;

import com.epam.training.microservice.service.recipes.model.DrugModel;
import com.netflix.discovery.EurekaClient;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "drug-service")
@ConditionalOnProperty(prefix = "drug-feign", value = "type", havingValue = "eureka")
public interface DrugServiceFeignWithEurekaClient extends DrugFeignClient {

}
