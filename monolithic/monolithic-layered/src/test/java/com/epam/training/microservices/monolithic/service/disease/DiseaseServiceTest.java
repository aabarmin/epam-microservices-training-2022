package com.epam.training.microservices.monolithic.service.disease;

import com.epam.training.microservices.monolithic.model.disease.Disease;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DiseaseServiceTest {

    @Mock
    private DiseaseRepository diseaseRepository;

    @InjectMocks
    private DiseaseService diseaseService;

    @DisplayName("Test getRepository method")
    @Test
    void shouldGetRepository() {
        JpaRepository<Disease, Long> expectedRepo = diseaseRepository;
        JpaRepository<Disease, Long> resultRepo = diseaseService.getRepository();

        assertEquals(expectedRepo, resultRepo);
    }

    @DisplayName("Test save method")
    @Test
    void shouldSaveDisease() {
        Disease disease = new Disease();
        when(diseaseRepository.save(disease)).thenReturn(disease);

        Disease savedDisease = diseaseService.save(disease);

        verify(diseaseRepository, times(1)).save(eq(disease));
        assertEquals(disease, savedDisease);
    }

    @DisplayName("Test findOne method")
    @Test
    void shouldFindOneDiseaseById() {
        Disease disease = new Disease();
        disease.setId(1L);
        when(diseaseRepository.findById(1L)).thenReturn(Optional.of(disease));

        Optional<Disease> foundDisease = diseaseService.findOne(1L);

        assertTrue(foundDisease.isPresent());
        assertEquals(disease, foundDisease.get());
    }

    @DisplayName("Test findAll method")
    @Test
    void shouldFindAllDiseases() {
        Disease disease1 = new Disease();
        Disease disease2 = new Disease();

        when(diseaseRepository.findAll()).thenReturn(Arrays.asList(disease1, disease2));

        Collection<Disease> diseases = diseaseService.findAll();

        assertNotNull(diseases);
        assertEquals(2, diseases.size());
        assertTrue(diseases.contains(disease1));
        assertTrue(diseases.contains(disease2));
    }

    @DisplayName("Test findByName method")
    @Test
    void shouldFindDiseaseByName() {
        Disease disease = new Disease();
        disease.setName("Flu");
        when(diseaseRepository.findDiseaseByName("Flu")).thenReturn(Optional.of(disease));

        Optional<Disease> foundDisease = diseaseService.findByName("Flu");

        assertTrue(foundDisease.isPresent());
        assertEquals(disease, foundDisease.get());
    }
}
