package com.epam.training.miservices.services.drugs.service.load;

import com.epam.training.miservices.services.drugs.model.Disease;
import com.epam.training.miservices.services.drugs.model.Drug;
import com.epam.training.miservices.services.drugs.model.Symptom;
import com.epam.training.miservices.services.drugs.repository.DiseaseRepository;
import com.epam.training.miservices.services.drugs.repository.DrugRepository;
import com.epam.training.miservices.services.drugs.repository.SymptomRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Cleanup;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Profile("dev")
public class DiseasesTestDataLoader implements ApplicationListener<ContextRefreshedEvent> {
    @Value("classpath:test-data/diseases.json")
    private Resource diseasesResource;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DiseaseRepository diseaseRepository;

    @Autowired
    private SymptomRepository symptomRepository;

    @Autowired
    private DrugRepository drugRepository;

    @Override
    @SneakyThrows
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        @Cleanup final InputStream contentStream = diseasesResource.getInputStream();
        objectMapper
                .readValue(contentStream, new TypeReference<List<DiseaseLoadModel>>(){})
                .forEach(this::importDrugAndDisease);
    }

    private void importDrugAndDisease(DiseaseLoadModel model) {
        final Disease disease = importDisease(model);
        importDrugs(model, disease);
    }

    private Disease importDisease(DiseaseLoadModel model) {
        final Disease disease = diseaseRepository.findDiseaseByName(model.getDisease())
                .orElseGet(() -> {
                    final Disease newDisease = new Disease();
                    newDisease.setName(model.getDisease());
                    return newDisease;
                });

        final Set<Symptom> symptoms = model.getSymptoms().stream()
                .map(this::findOrCreateSymptom)
                .collect(Collectors.toSet());

        disease.setSymptoms(symptoms);

        return diseaseRepository.save(disease);
    }

    private void importDrugs(DiseaseLoadModel model, Disease disease) {
        for (String drugName : model.getDrugs()) {
            final Drug drug = drugRepository.findDrugByName(drugName)
                    .orElseGet(() -> {
                        final Drug newDrug = new Drug();
                        newDrug.setName(drugName);
                        newDrug.setAvailable(true);
                        return newDrug;
                    });

            drug.getDiseases().add(disease);
            drug.getSymptoms().addAll(disease.getSymptoms());

            drugRepository.save(drug);
        }
    }

    private Symptom findOrCreateSymptom(String symptomName) {
        return symptomRepository.findSymptomByName(symptomName)
                .orElseGet(() -> {
                    final Symptom newSymptom = new Symptom();
                    newSymptom.setName(symptomName);
                    return newSymptom;
                });
    }
}
