package com.epam.training.microservices.monolithic.service.doctor;

import com.epam.training.microservices.monolithic.model.recipie.Doctor;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
  Optional<Doctor> findDoctorByFirstNameAndLastName(String firrstName, String lastName);
}
