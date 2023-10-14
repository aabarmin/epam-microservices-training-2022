package com.epam.training.microservices.monolithic.jpa.repository;

import com.epam.training.microservices.monolithic.jpa.entity.recipie.RecipientEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipientJpaRepository extends JpaRepository<RecipientEntity, Long> {
  Optional<RecipientEntity> findRecipientByFirstNameAndLastName(String firstName, String lastName);
}
