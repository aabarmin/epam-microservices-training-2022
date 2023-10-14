package com.epam.training.microservices.monolithic.repository;

import com.epam.training.microservices.monolithic.jpa.entity.recipie.RecipientEntity;
import com.epam.training.microservices.monolithic.jpa.repository.RecipientJpaRepository;
import com.epam.training.microservices.monolithic.model.recipie.Recipient;
import com.epam.training.microservices.monolithic.transformer.RecipientTransformer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RecipientRepositoryImpl
    extends BasicCrudRepository<Recipient, RecipientEntity, Long>
    implements RecipientRepository {

  @Getter
  private final RecipientJpaRepository jpaRepository;

  @Getter
  private final RecipientTransformer transformer;

  @Override
  public Optional<Recipient> findRecipientByFirstNameAndLastName(String firstName, String lastName) {
    return jpaRepository.findRecipientByFirstNameAndLastName(firstName, lastName)
        .map(transformer::toModel);
  }
}
