package com.epam.training.microservices.monolithic.service.drug;

import com.epam.training.microservices.monolithic.model.drug.Drug;
import com.epam.training.microservices.monolithic.service.CrudService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class DrugService implements CrudService<Drug> {
  @Autowired
  private DrugRepository drugRepository;

  @Override
  public JpaRepository<Drug, Long> getRepository() {
    return drugRepository;
  }

  public Optional<Drug> findByName(String name) {
    return drugRepository.findDrugByName(name);
  }
}
