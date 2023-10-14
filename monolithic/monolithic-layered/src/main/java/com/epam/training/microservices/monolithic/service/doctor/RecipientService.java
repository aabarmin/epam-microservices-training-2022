package com.epam.training.microservices.monolithic.service.doctor;

import com.epam.training.microservices.monolithic.model.recipie.Recipient;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecipientService {
  private final RecipientRepository recipientRepository;

  public Optional<Recipient> findByName(String firstName, String lastName) {
    return recipientRepository.findRecipientByFirstNameAndLastName(firstName, lastName);
  }

  public Recipient save(Recipient recipient) {
    return recipientRepository.save(recipient);
  }
}
