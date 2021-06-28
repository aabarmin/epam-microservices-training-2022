package com.epam.training.microservices.monolithic.service.drug;

import com.epam.training.microservices.monolithic.model.drug.Drug;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugRepository extends JpaRepository<Drug, Long> {
  Optional<Drug> findDrugByName(String name);
}
