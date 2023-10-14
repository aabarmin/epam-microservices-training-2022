package com.epam.training.microservices.monolithic.service;

import com.epam.training.microservices.monolithic.model.pharmacy.Pharmacy;
import com.epam.training.microservices.monolithic.repository.CrudRepository;
import com.epam.training.microservices.monolithic.repository.PharmacyRepository;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PharmacyService implements CrudService<Pharmacy> {
  private final PharmacyRepository pharmacyRepository;

  @Override
  public CrudRepository<Pharmacy, Long> getRepository() {
    return pharmacyRepository;
  }

  public Optional<Pharmacy> findByName(String name) {
    return pharmacyRepository.findPharmacyByName(name);
  }
}
