package com.epam.training.microservices.monolithic.service.doctor;

import com.epam.training.microservices.monolithic.model.recipie.Doctor;
import com.epam.training.microservices.monolithic.model.recipie.Recipe;
import com.epam.training.microservices.monolithic.model.recipie.Recipient;
import com.epam.training.microservices.monolithic.service.BaseDataJpaTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class RecipeRepositoryTest extends BaseDataJpaTest {

    @Autowired
    private RecipeRepository repository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private RecipientRepository recipientRepository;

    @Test
    public void shouldSaveAndRetrieveRecipe() {
        // Arrange
        Doctor doctor = mock();
        doctorRepository.save(doctor);

        Recipient recipient = mock();
        recipientRepository.save(recipient);

        Recipe recipe = new Recipe();
        recipe.setDoctor(doctor);
        recipe.setRecipient(recipient);
        LocalDate issueDate = LocalDate.now();
        recipe.setIssueDate(issueDate);
        entityManager.persistAndFlush(recipe);

        // Act
        Optional<Recipe> found = repository.findRecipeByDoctorAndRecipientAndIssueDate(doctor, recipient, issueDate);

        // Assert
        assertTrue(found.isPresent());
    }
}
