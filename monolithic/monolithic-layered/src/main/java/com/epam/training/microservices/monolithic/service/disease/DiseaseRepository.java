package com.epam.training.microservices.monolithic.service.disease;

import com.epam.training.microservices.monolithic.model.disease.Disease;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseaseRepository extends JpaRepository<Disease, Long> {
  Optional<Disease> findDiseaseByName(String name);
}
