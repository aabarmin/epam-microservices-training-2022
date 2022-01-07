package com.epam.training.microservices.monolithic.repository;

import com.epam.training.microservices.monolithic.jpa.entity.recipie.DoctorEntity;
import com.epam.training.microservices.monolithic.jpa.repository.DoctorJpaRepository;
import com.epam.training.microservices.monolithic.model.recipie.Doctor;
import com.epam.training.microservices.monolithic.transformer.DoctorTransformer;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DoctorRepositoryImpl
    extends BasicCrudRepository<Doctor, DoctorEntity, Long>
    implements DoctorRepository {

  @Getter
  private final DoctorTransformer transformer;

  @Getter
  private final DoctorJpaRepository jpaRepository;

  @Override
  public Optional<Doctor> findDoctorByFirstNameAndLastName(String firstName, String lastName) {
    return jpaRepository.findDoctorByFirstNameAndLastName(firstName, lastName)
        .map(transformer::toModel);
  }
}
