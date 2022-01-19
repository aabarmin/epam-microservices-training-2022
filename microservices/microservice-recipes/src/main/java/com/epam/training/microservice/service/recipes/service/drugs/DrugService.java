package com.epam.training.microservice.service.recipes.service.drugs;

import com.epam.training.microservice.service.recipes.model.DrugModel;
import java.util.Optional;

/**
 * @author Aleksandr Barmin
 */
public interface DrugService {
  Optional<DrugModel> findById(Long id);

  /**
   * Get drug's id by its name.
   *
   * @param drugName
   * @return
   */
  Optional<Long> getDrugIdByName(String drugName);
}
