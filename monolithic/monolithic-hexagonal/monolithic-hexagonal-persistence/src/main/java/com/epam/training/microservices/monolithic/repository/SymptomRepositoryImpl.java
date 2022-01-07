package com.epam.training.microservices.monolithic.repository;

import com.epam.training.microservices.monolithic.jpa.entity.disease.SymptomEntity;
import com.epam.training.microservices.monolithic.jpa.repository.SymptomJpaRepository;
import com.epam.training.microservices.monolithic.model.disease.Symptom;
import com.epam.training.microservices.monolithic.transformer.SymptomTransformer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SymptomRepositoryImpl
    extends BasicCrudRepository<Symptom, SymptomEntity, Long>
    implements SymptomRepository {

  @Getter
  private final SymptomJpaRepository jpaRepository;

  @Getter
  private final SymptomTransformer transformer;

  @Override
  public Optional<Symptom> findSymptomByName(String name) {
    return jpaRepository.findSymptomByName(name)
        .map(transformer::toModel);
  }
}
