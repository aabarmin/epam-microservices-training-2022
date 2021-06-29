package com.epam.training.microservices.monolithic.service;

import com.epam.training.microservices.monolithic.model.pharmacy.Pharmacy;
import com.epam.training.microservices.monolithic.repository.CrudRepository;
import com.epam.training.microservices.monolithic.repository.PharmacyRepository;
import com.epam.training.microservices.monolithic.service.CrudService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PharmacyService implements CrudService<Pharmacy> {
  @Autowired
  private PharmacyRepository pharmacyRepository;

  @Override
  public CrudRepository<Pharmacy, Long> getRepository() {
    return pharmacyRepository;
  }

  public Optional<Pharmacy> findByName(String name) {
    return pharmacyRepository.findPharmacyByName(name);
  }
}
