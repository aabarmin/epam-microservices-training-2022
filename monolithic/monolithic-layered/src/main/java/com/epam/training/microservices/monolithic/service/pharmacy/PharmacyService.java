package com.epam.training.microservices.monolithic.service.pharmacy;

import com.epam.training.microservices.monolithic.model.pharmacy.Pharmacy;
import com.epam.training.microservices.monolithic.service.CrudService;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PharmacyService implements CrudService<Pharmacy> {
  private final PharmacyRepository pharmacyRepository;

  @Override
  public JpaRepository<Pharmacy, Long> getRepository() {
    return pharmacyRepository;
  }

  public Optional<Pharmacy> findByName(String name) {
    return pharmacyRepository.findPharmacyByName(name);
  }
}
