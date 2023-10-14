package com.epam.training.microservices.monolithic.service;

import com.epam.training.microservices.monolithic.model.drug.Drug;
import com.epam.training.microservices.monolithic.repository.CrudRepository;
import com.epam.training.microservices.monolithic.repository.DrugRepository;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DrugService implements CrudService<Drug> {
  private final DrugRepository drugRepository;

  @Override
  public CrudRepository<Drug, Long> getRepository() {
    return drugRepository;
  }

  public Optional<Drug> findByName(String name) {
    return drugRepository.findDrugByName(name);
  }
}
