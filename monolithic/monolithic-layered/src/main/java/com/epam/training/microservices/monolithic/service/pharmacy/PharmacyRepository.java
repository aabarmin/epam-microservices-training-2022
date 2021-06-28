package com.epam.training.microservices.monolithic.service.pharmacy;

import com.epam.training.microservices.monolithic.model.pharmacy.Pharmacy;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyRepository extends JpaRepository<Pharmacy, Long> {
  Optional<Pharmacy> findPharmacyByName(String name);
}
