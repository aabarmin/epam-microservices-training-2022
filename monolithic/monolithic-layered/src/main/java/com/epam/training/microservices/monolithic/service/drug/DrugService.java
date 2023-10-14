package com.epam.training.microservices.monolithic.service.drug;

import com.epam.training.microservices.monolithic.model.drug.Drug;
import com.epam.training.microservices.monolithic.service.CrudService;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DrugService implements CrudService<Drug> {
  private final DrugRepository drugRepository;

  @Override
  public JpaRepository<Drug, Long> getRepository() {
    return drugRepository;
  }

  public Optional<Drug> findByName(String name) {
    return drugRepository.findDrugByName(name);
  }
}
