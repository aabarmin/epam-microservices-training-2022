package com.epam.training.microservices.monolithic.jpa.repository;

import com.epam.training.microservices.monolithic.jpa.entity.recipie.DoctorEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorJpaRepository extends JpaRepository<DoctorEntity, Long> {
  Optional<DoctorEntity> findDoctorByFirstNameAndLastName(String firstName, String lastName);
}
