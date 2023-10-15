package com.epam.training.microservices.monolithic.service.doctor;

import com.epam.training.microservices.monolithic.model.recipie.Doctor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DoctorServiceTest {

    @Mock
    private DoctorRepository doctorRepository;

    @InjectMocks
    private DoctorService doctorService;

    @DisplayName("Test findDoctorByFirstNameAndLastName method")
    @Test
    void shouldFindDoctorByName() {
        Doctor doctor = new Doctor();
        doctor.setFirstName("John");
        doctor.setLastName("Doe");
        when(doctorRepository.findDoctorByFirstNameAndLastName("John", "Doe")).thenReturn(Optional.of(doctor));

        Optional<Doctor> foundDoctor = doctorService.findByName("John", "Doe");

        assertTrue(foundDoctor.isPresent());
        assertEquals(doctor, foundDoctor.get());
    }

    @DisplayName("Test save method")
    @Test
    void shouldSaveDoctor() {
        Doctor doctor = new Doctor();
        when(doctorRepository.save(doctor)).thenReturn(doctor);

        Doctor savedDoctor = doctorService.save(doctor);

        assertEquals(doctor, savedDoctor);
    }
}
