package com.epam.training.microservices.monolithic.service.doctor;

import com.epam.training.microservices.monolithic.model.recipie.Recipient;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipientRepository extends JpaRepository<Recipient, Long> {
  Optional<Recipient> findRecipientByFirstNameAndLastName(String firstName, String lastName);
}
