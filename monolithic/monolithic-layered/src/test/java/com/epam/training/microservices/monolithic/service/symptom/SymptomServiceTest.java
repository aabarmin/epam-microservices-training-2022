package com.epam.training.microservices.monolithic.service.symptom;

import com.epam.training.microservices.monolithic.model.disease.Symptom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SymptomServiceTest {

    @Mock
    private SymptomRepository symptomRepository;

    @InjectMocks
    private SymptomService symptomService;

    @Test
    @DisplayName("Test getRepository method")
    void shouldGetRepository() {
        JpaRepository<Symptom, Long> expectedRepo = symptomRepository;
        JpaRepository<Symptom, Long> resultRepo = symptomService.getRepository();
        assertEquals(expectedRepo, resultRepo);
    }

    @Test
    @DisplayName("Test save method")
    void shouldSaveSymptom() {
        Symptom symptom = new Symptom();
        when(symptomRepository.save(symptom)).thenReturn(symptom);

        Symptom savedSymptom = symptomService.save(symptom);

        assertEquals(symptom, savedSymptom);
    }

    @Test
    @DisplayName("Test findByName method")
    void shouldFindSymptomByName() {
        Symptom symptom = new Symptom();
        symptom.setName("Headache");
        when(symptomRepository.findSymptomByName("Headache")).thenReturn(Optional.of(symptom));

        Optional<Symptom> foundSymptom = symptomService.findByName("Headache");

        assertTrue(foundSymptom.isPresent());
        assertEquals(symptom, foundSymptom.get());
    }
}
