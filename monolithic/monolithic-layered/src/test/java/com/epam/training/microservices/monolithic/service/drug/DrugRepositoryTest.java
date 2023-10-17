package com.epam.training.microservices.monolithic.service.drug;

import com.epam.training.microservices.monolithic.model.drug.Drug;
import com.epam.training.microservices.monolithic.service.BaseDataJpaTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DrugRepositoryTest extends BaseDataJpaTest {

    @Autowired
    private DrugRepository repository;

    @Test
    public void shouldSaveAndRetrieveDrugByName() {
        Drug drug = new Drug();
        drug.setName("Aspirin");
        entityManager.persistAndFlush(drug);

        Optional<Drug> found = repository.findDrugByName("Aspirin");

        assertTrue(found.isPresent());
        assertEquals("Aspirin", found.get().getName());
    }
}