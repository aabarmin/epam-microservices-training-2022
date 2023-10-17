package com.epam.training.microservices.monolithic.service.doctor;

import com.epam.training.microservices.monolithic.model.recipie.Recipient;
import com.epam.training.microservices.monolithic.service.BaseDataJpaTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecipientRepositoryTest extends BaseDataJpaTest {

    @Autowired
    private RecipientRepository repository;

    @Test
    public void shouldSaveAndRetrieveRecipient() {
        Recipient recipient = new Recipient();
        recipient.setFirstName("Jane");
        recipient.setLastName("Smith");
        entityManager.persistAndFlush(recipient);

        Optional<Recipient> found = repository.findRecipientByFirstNameAndLastName("Jane", "Smith");

        assertTrue(found.isPresent());
        assertEquals("Jane", found.get().getFirstName());
        assertEquals("Smith", found.get().getLastName());
    }
}
