package com.epam.training.microservices.monolithic.jpa.repository;

import com.epam.training.microservices.monolithic.jpa.entity.disease.DiseaseEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseaseJpaRepository extends JpaRepository<DiseaseEntity, Long> {
  Optional<DiseaseEntity> findDiseaseByName(String name);
}
