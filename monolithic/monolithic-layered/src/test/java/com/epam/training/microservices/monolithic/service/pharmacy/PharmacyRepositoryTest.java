package com.epam.training.microservices.monolithic.service.pharmacy;

import com.epam.training.microservices.monolithic.model.pharmacy.Pharmacy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class PharmacyRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PharmacyRepository repository;

    @Test
    public void shouldSaveAndRetrievePharmacyByName() {
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.setName("HealthPlus");
        entityManager.persistAndFlush(pharmacy);

        Optional<Pharmacy> found = repository.findPharmacyByName("HealthPlus");

        assertTrue(found.isPresent());
        assertEquals("HealthPlus", found.get().getName());
    }
}
