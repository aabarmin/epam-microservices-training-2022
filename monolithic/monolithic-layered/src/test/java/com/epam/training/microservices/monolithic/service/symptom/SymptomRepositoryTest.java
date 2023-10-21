package com.epam.training.microservices.monolithic.service.symptom;

import com.epam.training.microservices.monolithic.model.disease.Symptom;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class SymptomRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private SymptomRepository repository;

    @Test
    public void shouldSaveAndRetrieveSymptomByName() {
        Symptom symptom = new Symptom();
        symptom.setName("Headache");
        entityManager.persistAndFlush(symptom);

        Optional<Symptom> found = repository.findSymptomByName("Headache");

        assertTrue(found.isPresent());
        assertEquals("Headache", found.get().getName());
    }
}
