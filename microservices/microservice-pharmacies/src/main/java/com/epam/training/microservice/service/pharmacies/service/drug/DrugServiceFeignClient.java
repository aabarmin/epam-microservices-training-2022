package com.epam.training.microservice.service.pharmacies.service.drug;

import com.epam.training.microservice.service.pharmacies.model.DrugModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "drug-service", fallback = DrugServiceFeignFallbackClient.class)
public interface DrugServiceFeignClient {
    @GetMapping("/drugs/search/findDrugByName")
    EntityModel<DrugModel> findDrugByName(@RequestParam("name") String name);
}