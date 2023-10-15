package com.epam.training.microservices.monolithic.service.doctor;

import com.epam.training.microservices.monolithic.model.recipie.Recipient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RecipientServiceTest {

    @Mock
    private RecipientRepository recipientRepository;

    @InjectMocks
    private RecipientService recipientService;

    @DisplayName("Test save method")
    @Test
    void shouldSaveRecipient() {
        Recipient recipient = new Recipient();
        when(recipientRepository.save(recipient)).thenReturn(recipient);

        Recipient savedRecipient = recipientService.save(recipient);

        assertEquals(recipient, savedRecipient);
    }

    @DisplayName("Test findRecipientByFirstNameAndLastName method")
    @Test
    void shouldFindRecipientByName() {
        Recipient recipient = new Recipient();
        recipient.setFirstName("John");
        recipient.setLastName("Doe");
        when(recipientRepository.findRecipientByFirstNameAndLastName("John", "Doe")).thenReturn(Optional.of(recipient));

        Optional<Recipient> foundRecipient = recipientService.findByName("John", "Doe");

        assertTrue(foundRecipient.isPresent());
        assertEquals(recipient, foundRecipient.get());
    }
}
