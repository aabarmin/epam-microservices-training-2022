package com.epam.training.microservice.service.recipes.repository;

import com.epam.training.microservice.service.recipes.model.Doctor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DoctorRepository extends CrudRepository<Doctor, Long> {
    Optional<Doctor> findDoctorByFirstNameAndLastName(String firstName, String lastName);
}
