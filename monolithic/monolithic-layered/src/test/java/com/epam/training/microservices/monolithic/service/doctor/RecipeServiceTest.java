package com.epam.training.microservices.monolithic.service.doctor;

import com.epam.training.microservices.monolithic.model.recipie.Doctor;
import com.epam.training.microservices.monolithic.model.recipie.Recipe;
import com.epam.training.microservices.monolithic.model.recipie.Recipient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RecipeServiceTest {

    @Mock
    private RecipeRepository recipeRepository;

    @InjectMocks
    private RecipeService recipeService;

    @DisplayName("Test save method")
    @Test
    void shouldSaveRecipe() {
        Recipe recipe = new Recipe();
        when(recipeRepository.save(recipe)).thenReturn(recipe);

        Recipe savedRecipe = recipeService.save(recipe);

        verify(recipeRepository, times(1)).save(eq(recipe));
        assertEquals(recipe, savedRecipe);
    }

    @DisplayName("Test findRecipeByDoctorAndRecipientAndIssueDate method")
    @Test
    void shouldFindRecipeByDoctorRecipientAndDate() {
        Doctor doctor = new Doctor();
        Recipient recipient = new Recipient();
        LocalDate issueDate = LocalDate.now();
        Recipe recipe = new Recipe();
        recipe.setDoctor(doctor);
        recipe.setRecipient(recipient);
        recipe.setIssueDate(issueDate);

        when(recipeRepository.findRecipeByDoctorAndRecipientAndIssueDate(doctor, recipient, issueDate))
                .thenReturn(Optional.of(recipe));

        Optional<Recipe> foundRecipe = recipeService.find(doctor, recipient, issueDate);

        assertTrue(foundRecipe.isPresent());
        assertEquals(recipe, foundRecipe.get());
    }
}
