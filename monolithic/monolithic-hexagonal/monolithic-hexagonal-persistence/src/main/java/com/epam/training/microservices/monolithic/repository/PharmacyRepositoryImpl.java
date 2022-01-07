package com.epam.training.microservices.monolithic.repository;

import com.epam.training.microservices.monolithic.jpa.entity.pharmacy.PharmacyEntity;
import com.epam.training.microservices.monolithic.jpa.repository.PharmacyJpaRepository;
import com.epam.training.microservices.monolithic.model.pharmacy.Pharmacy;
import com.epam.training.microservices.monolithic.transformer.PharmacyTransformer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PharmacyRepositoryImpl
    extends BasicCrudRepository<Pharmacy, PharmacyEntity, Long>
    implements PharmacyRepository {

  @Getter
  private final PharmacyJpaRepository jpaRepository;

  @Getter
  private final PharmacyTransformer transformer;

  @Override
  public Optional<Pharmacy> findPharmacyByName(String name) {
    return jpaRepository.findPharmacyByName(name)
        .map(transformer::toModel);
  }
}
