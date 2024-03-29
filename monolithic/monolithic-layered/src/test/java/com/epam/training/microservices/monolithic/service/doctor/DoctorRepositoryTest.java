package com.epam.training.microservices.monolithic.service.doctor;

import com.epam.training.microservices.monolithic.model.recipie.Doctor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
public class DoctorRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DoctorRepository repository;

    @Test
    public void shouldSaveAndRetrieveDoctor() {
        Doctor doctor = new Doctor();
        doctor.setFirstName("John");
        doctor.setLastName("Doe");
        entityManager.persistAndFlush(doctor);

        Optional<Doctor> found = repository.findDoctorByFirstNameAndLastName("John", "Doe");

        assertTrue(found.isPresent());
        assertEquals("John", found.get().getFirstName());
        assertEquals("Doe", found.get().getLastName());
    }
}
