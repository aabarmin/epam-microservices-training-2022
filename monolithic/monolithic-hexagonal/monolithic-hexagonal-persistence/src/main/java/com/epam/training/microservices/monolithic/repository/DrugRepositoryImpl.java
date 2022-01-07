package com.epam.training.microservices.monolithic.repository;

import com.epam.training.microservices.monolithic.jpa.entity.drug.DrugEntity;
import com.epam.training.microservices.monolithic.jpa.repository.DrugJpaRepository;
import com.epam.training.microservices.monolithic.model.drug.Drug;
import com.epam.training.microservices.monolithic.transformer.DrugTransformer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DrugRepositoryImpl
    extends BasicCrudRepository<Drug, DrugEntity, Long>
    implements DrugRepository {

  @Getter
  private final DrugJpaRepository jpaRepository;

  @Getter
  private final DrugTransformer transformer;

  @Override
  public Optional<Drug> findDrugByName(String name) {
    return jpaRepository.findDrugByName(name)
        .map(transformer::toModel);
  }
}
