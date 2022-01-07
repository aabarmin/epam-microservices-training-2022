package com.epam.training.microservices.monolithic.service;

import com.epam.training.microservices.monolithic.model.disease.Disease;
import com.epam.training.microservices.monolithic.repository.CrudRepository;
import com.epam.training.microservices.monolithic.repository.DiseaseRepository;
import com.epam.training.microservices.monolithic.service.CrudService;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiseaseService implements CrudService<Disease> {
  private final DiseaseRepository diseaseRepository;

  @Override
  public CrudRepository<Disease, Long> getRepository() {
    return diseaseRepository;
  }

  public Optional<Disease> findByName(String name) {
    return diseaseRepository.findDiseaseByName(name);
  }
}
