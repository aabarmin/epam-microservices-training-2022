package com.epam.training.microservices.monolithic.service.pharmacy;

import com.epam.training.microservices.monolithic.model.pharmacy.Pharmacy;
import com.epam.training.microservices.monolithic.service.CrudService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PharmacyService implements CrudService<Pharmacy> {
  @Autowired
  private PharmacyRepository pharmacyRepository;

  @Override
  public JpaRepository<Pharmacy, Long> getRepository() {
    return pharmacyRepository;
  }

  public Optional<Pharmacy> findByName(String name) {
    return pharmacyRepository.findPharmacyByName(name);
  }
}
