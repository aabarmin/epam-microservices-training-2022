package com.epam.training.microservice.service.recipes.service.drugs;

import com.epam.training.microservice.service.recipes.model.DrugModel;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

/**
 * @author Aleksandr Barmin
 */
@Component
@Profile("feign-client")
@RequiredArgsConstructor
public class DrugServiceWithFeignClient implements DrugService {
  private final DrugFeignClient feignClient;

  @Override
  public Optional<Long> getDrugIdByName(String drugName) {
    return Optional.ofNullable(feignClient.findDrugByName(drugName))
        .map(EntityModel::getContent)
        .map(DrugModel::getId);
  }

  @Override
  public Optional<DrugModel> findById(Long id) {
    return Optional.ofNullable(feignClient.findById(id))
        .map(EntityModel::getContent);
  }
}
