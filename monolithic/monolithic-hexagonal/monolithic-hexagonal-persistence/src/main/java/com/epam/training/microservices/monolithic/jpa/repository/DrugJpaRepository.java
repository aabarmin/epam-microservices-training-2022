package com.epam.training.microservices.monolithic.jpa.repository;

import com.epam.training.microservices.monolithic.jpa.entity.drug.DrugEntity;
import com.epam.training.microservices.monolithic.model.drug.Drug;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugJpaRepository extends JpaRepository<DrugEntity, Long> {
  Optional<Drug> findDrugByName(String name);
}
