package com.epam.training.microservices.monolithic.jpa.repository;

import com.epam.training.microservices.monolithic.jpa.entity.disease.SymptomEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SymptomJpaRepository extends JpaRepository<SymptomEntity, Long> {
  Optional<SymptomEntity> findSymptomByName(String name);
}
