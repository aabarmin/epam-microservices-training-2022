package com.epam.training.microservices.monolithic.jpa.repository;

import com.epam.training.microservices.monolithic.jpa.entity.disease.DiseaseEntity;
import com.epam.training.microservices.monolithic.model.disease.Disease;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseaseJpaRepository extends JpaRepository<DiseaseEntity, Long> {
  Optional<Disease> findDiseaseByName(String name);
}
