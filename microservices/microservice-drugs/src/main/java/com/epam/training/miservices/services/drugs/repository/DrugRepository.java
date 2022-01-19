package com.epam.training.miservices.services.drugs.repository;

import com.epam.training.miservices.services.drugs.model.Drug;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DrugRepository extends CrudRepository<Drug, Long> {
    Optional<Drug> findDrugById(@Param("id") Long id);

    Optional<Drug> findDrugByName(@Param("name") String name);
}
