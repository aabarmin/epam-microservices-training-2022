package com.epam.training.microservices.monolithic.service;

import com.epam.training.microservices.monolithic.model.recipie.Recipient;
import com.epam.training.microservices.monolithic.repository.RecipientRepository;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
