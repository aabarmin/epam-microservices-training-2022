package com.epam.training.microservices.monolithic.jpa.repository;

import com.epam.training.microservices.monolithic.jpa.entity.pharmacy.PharmacyEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyJpaRepository extends JpaRepository<PharmacyEntity, Long> {
  Optional<PharmacyEntity> findPharmacyByName(String name);
}
