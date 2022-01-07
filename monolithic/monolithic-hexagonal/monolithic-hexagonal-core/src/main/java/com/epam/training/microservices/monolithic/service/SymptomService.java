package com.epam.training.microservices.monolithic.service;

import com.epam.training.microservices.monolithic.model.disease.Symptom;
import com.epam.training.microservices.monolithic.repository.CrudRepository;
import com.epam.training.microservices.monolithic.repository.SymptomRepository;
import com.epam.training.microservices.monolithic.service.CrudService;
import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SymptomService implements CrudService<Symptom> {
    private final SymptomRepository symptomRepository;

    @Override
    public CrudRepository<Symptom, Long> getRepository() {
        return symptomRepository;
    }

    public Optional<Symptom> findByName(String name) {
        return symptomRepository.findSymptomByName(name);
    }
}
