package com.epam.training.microservice.service.recipes.service;

import com.epam.training.microservice.service.recipes.model.DrugModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "drug-service")
public interface DrugServiceFeignClient {
  @GetMapping("/drugs/{id}")
  EntityModel<DrugModel> findById(@PathVariable("id") Long id);
}
