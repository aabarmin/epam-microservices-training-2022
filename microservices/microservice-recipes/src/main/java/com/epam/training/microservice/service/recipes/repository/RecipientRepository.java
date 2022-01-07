package com.epam.training.microservice.service.recipes.repository;

import com.epam.training.microservice.service.recipes.model.Recipient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RecipientRepository extends CrudRepository<Recipient, Long> {
    Optional<Recipient> findRecipientByFirstNameAndLastName(String firstName, String lastName);
}
