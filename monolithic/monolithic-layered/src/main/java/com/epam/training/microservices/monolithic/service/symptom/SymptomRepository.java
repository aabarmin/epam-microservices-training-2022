package com.epam.training.microservices.monolithic.service.symptom;

import com.epam.training.microservices.monolithic.model.disease.Symptom;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SymptomRepository extends JpaRepository<Symptom, Long> {
  Optional<Symptom> findSymptomByName(String name);
}
