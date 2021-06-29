package com.epam.training.microservices.monolithic.jpa.repository;

import com.epam.training.microservices.monolithic.jpa.entity.pharmacy.PharmacyEntity;
import com.epam.training.microservices.monolithic.model.pharmacy.Pharmacy;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyJpaRepository extends JpaRepository<PharmacyEntity, Long> {
  Optional<Pharmacy> findPharmacyByName(String name);
}
