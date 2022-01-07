package com.epam.training.microservices.monolithic.service.disease;

import com.epam.training.microservices.monolithic.model.disease.Disease;
import com.epam.training.microservices.monolithic.service.CrudService;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiseaseService implements CrudService<Disease> {
  private final DiseaseRepository diseaseRepository;

  @Override
  public JpaRepository<Disease, Long> getRepository() {
    return diseaseRepository;
  }

  public Optional<Disease> findByName(String name) {
    return diseaseRepository.findDiseaseByName(name);
  }
}
