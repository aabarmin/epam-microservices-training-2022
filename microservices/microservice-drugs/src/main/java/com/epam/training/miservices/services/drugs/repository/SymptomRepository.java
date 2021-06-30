package com.epam.training.miservices.services.drugs.repository;

import com.epam.training.miservices.services.drugs.model.Symptom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SymptomRepository extends CrudRepository<Symptom, Long> {
    Optional<Symptom> findSymptomByName(@Param("name") String name);
}
