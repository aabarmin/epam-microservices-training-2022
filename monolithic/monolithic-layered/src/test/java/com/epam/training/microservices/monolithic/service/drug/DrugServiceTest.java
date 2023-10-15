package com.epam.training.microservices.monolithic.service.drug;

import com.epam.training.microservices.monolithic.model.drug.Drug;
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
class DrugServiceTest {

    @Mock
    private DrugRepository drugRepository;

    @InjectMocks
    private DrugService drugService;

    @Test
    @DisplayName("Test getRepository method")
    void shouldGetRepository() {
        JpaRepository<Drug, Long> expectedRepo = drugRepository;
        JpaRepository<Drug, Long> resultRepo = drugService.getRepository();
        assertEquals(expectedRepo, resultRepo);
    }

    @Test
    @DisplayName("Test save method")
    void shouldSaveDrug() {
        Drug drug = new Drug();
        when(drugRepository.save(drug)).thenReturn(drug);
        Drug savedDrug = drugService.save(drug);
        assertEquals(drug, savedDrug);
    }

    @Test
    @DisplayName("Test findByName method")
    void shouldFindDrugByName() {
        Drug drug = new Drug();
        drug.setName("Aspirin");
        when(drugRepository.findDrugByName("Aspirin")).thenReturn(Optional.of(drug));
        Optional<Drug> foundDrug = drugService.findByName("Aspirin");
        assertTrue(foundDrug.isPresent());
        assertEquals(drug, foundDrug.get());
    }
}
