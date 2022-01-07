package com.epam.training.microservices.monolithic.repository;

import com.epam.training.microservices.monolithic.jpa.entity.disease.DiseaseEntity;
import com.epam.training.microservices.monolithic.jpa.repository.DiseaseJpaRepository;
import com.epam.training.microservices.monolithic.model.disease.Disease;
import com.epam.training.microservices.monolithic.transformer.DiseaseTransformer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DiseaseRepositoryImpl
    extends BasicCrudRepository<Disease, DiseaseEntity, Long>
    implements DiseaseRepository {

  @Getter
  private final DiseaseJpaRepository jpaRepository;

  @Getter
  private final DiseaseTransformer transformer;

  @Override
  public Optional<Disease> findDiseaseByName(String name) {
    return jpaRepository.findDiseaseByName(name)
        .map(transformer::toModel);
  }
}
