package com.epam.training.microservice.service.pharmacies.repository;

import com.epam.training.microservice.service.pharmacies.model.PharmacyAvailable;
import org.springframework.data.repository.CrudRepository;

public interface PharmacyAvailableRepository extends CrudRepository<PharmacyAvailable, Long> {
}
