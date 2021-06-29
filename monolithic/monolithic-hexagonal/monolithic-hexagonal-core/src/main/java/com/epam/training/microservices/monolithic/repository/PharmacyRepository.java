package com.epam.training.microservices.monolithic.repository;

import com.epam.training.microservices.monolithic.model.pharmacy.Pharmacy;
import com.epam.training.microservices.monolithic.repository.CrudRepository;
import java.util.Optional;

public interface PharmacyRepository extends CrudRepository<Pharmacy, Long> {
  Optional<Pharmacy> findPharmacyByName(String name);
}
