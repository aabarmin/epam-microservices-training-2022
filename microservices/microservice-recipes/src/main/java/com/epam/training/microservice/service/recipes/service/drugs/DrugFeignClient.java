package com.epam.training.microservice.service.recipes.service.drugs;

import com.epam.training.microservice.service.recipes.model.DrugModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Aleksandr Barmin
 */
public interface DrugFeignClient {
  @GetMapping("/drugs/{id}")
  EntityModel<DrugModel> findById(@PathVariable("id") Long id);

  @GetMapping("/drugs/search/findDrugByName")
  EntityModel<DrugModel> findDrugByName(@RequestParam("name") String name);
}
