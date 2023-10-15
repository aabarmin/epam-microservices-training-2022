package com.epam.training.microservices.monolithic.service.disease;

import com.epam.training.microservices.monolithic.model.disease.Disease;
import com.epam.training.microservices.monolithic.service.DataJpaTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiseaseRepositoryTest extends DataJpaTest {

    @Autowired
    private DiseaseRepository repository;

    @Test
    public void shouldSaveAndRetrieveDisease() {
        // Arrange
        Disease disease = new Disease();
        disease.setName("Test Disease");

        entityManager.persistAndFlush(disease);

        // Act
        Disease found = repository.findById(disease.getId()).orElse(null);

        // Assert
        assertNotNull(found);
        assertEquals("Test Disease", found.getName());
    }

    @Test
    public void shouldFindDiseaseByName() {
        // Arrange
        Disease disease1 = new Disease();
        disease1.setName("Flu");
        Disease disease2 = new Disease();
        disease2.setName("Cold");

        entityManager.persist(disease1);
        entityManager.persist(disease2);
        entityManager.flush();

        // Act
        Optional<Disease> found = repository.findDiseaseByName("Flu");

        // Assert
        assertTrue(found.isPresent());
        assertEquals("Flu", found.get().getName());
    }
}
