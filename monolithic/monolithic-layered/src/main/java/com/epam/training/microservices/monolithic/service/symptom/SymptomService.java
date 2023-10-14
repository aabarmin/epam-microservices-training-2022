package com.epam.training.microservices.monolithic.service.symptom;

import com.epam.training.microservices.monolithic.service.CrudService;

import com.epam.training.microservices.monolithic.model.disease.Symptom;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SymptomService implements CrudService<Symptom> {
    @Autowired
    private SymptomRepository symptomRepository;

    @Override
    public JpaRepository<Symptom, Long> getRepository() {
        return symptomRepository;
    }

    public Optional<Symptom> findByName(String name) {
        return symptomRepository.findSymptomByName(name);
    }
}
