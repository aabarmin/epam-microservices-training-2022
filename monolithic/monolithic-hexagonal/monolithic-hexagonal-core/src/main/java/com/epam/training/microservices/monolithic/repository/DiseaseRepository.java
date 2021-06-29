package com.epam.training.microservices.monolithic.repository;

import com.epam.training.microservices.monolithic.model.disease.Disease;
import com.epam.training.microservices.monolithic.repository.CrudRepository;
import java.util.Optional;

public interface DiseaseRepository extends CrudRepository<Disease, Long> {
  Optional<Disease> findDiseaseByName(String name);
}
