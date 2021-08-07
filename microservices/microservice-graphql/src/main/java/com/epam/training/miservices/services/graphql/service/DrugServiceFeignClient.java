package com.epam.training.miservices.services.graphql.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "${drug.service.url}", name = "drug-service")
public interface DrugServiceFeignClient {
  @GetMapping("/drugs")
  CollectionModel<DrugModel> findAll();

  @GetMapping("/drugs/{id}")
  EntityModel<DrugModel> findOne(@PathVariable("id") Long id);
}
