package com.epam.training.microservices.monolithic.service;

import com.epam.training.microservices.monolithic.model.recipie.Doctor;
import com.epam.training.microservices.monolithic.repository.DoctorRepository;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorService {
  private final DoctorRepository doctorRepository;

  public Optional<Doctor> findByName(String firstName, String lastName) {
    return doctorRepository.findDoctorByFirstNameAndLastName(firstName, lastName);
  }

  public Doctor save(Doctor doctor) {
    return doctorRepository.save(doctor);
  }
}
