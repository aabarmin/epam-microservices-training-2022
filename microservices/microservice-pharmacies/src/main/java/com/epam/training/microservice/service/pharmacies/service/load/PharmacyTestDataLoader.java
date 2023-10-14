package com.epam.training.microservice.service.pharmacies.service.load;

import com.epam.training.microservice.service.pharmacies.model.Pharmacy;
import com.epam.training.microservice.service.pharmacies.model.PharmacyAvailable;
import com.epam.training.microservice.service.pharmacies.service.drug.DrugService;
import com.epam.training.microservice.service.pharmacies.repository.PharmacyRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Cleanup;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Profile("dev")
public class PharmacyTestDataLoader implements CommandLineRunner {
    @Value("classpath:test-data/pharmacy.json")
    private Resource pharmacyResource;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PharmacyRepository pharmacyRepository;

    @Autowired
    private DrugService drugClient;

    @Override
    @SneakyThrows
    public void run(String... args) {
        @Cleanup final InputStream contentStream = pharmacyResource.getInputStream();
        objectMapper
                .readValue(contentStream, new TypeReference<List<PharmacyLoadModel>>() {})
                .forEach(this::importPharmacyData);
    }

    private void importPharmacyData(PharmacyLoadModel model) {
        final Pharmacy pharmacy = importPharmacy(model);

        final Set<PharmacyAvailable> availableDrugs = model.getDrugs()
                .stream()
                .map(available -> {
                    final PharmacyAvailable availableDrug = new PharmacyAvailable();
                    availableDrug.setPharmacy(pharmacy);
                    availableDrug.setDrugId(
                            drugClient.getDrugIdByName(available.getDrugName())
                                .orElse(-1L)
                    );
                    availableDrug.setAmount(available.getAmount());
                    return availableDrug;
                })
                .collect(Collectors.toSet());

        pharmacy.getAvailable().addAll(availableDrugs);

        pharmacyRepository.save(pharmacy);
    }

    private Pharmacy importPharmacy(PharmacyLoadModel model) {
        final Pharmacy pharmacy = pharmacyRepository.findPharmacyByName(model.getName())
                .orElseGet(() -> {
                    final Pharmacy newPharmacy = new Pharmacy();
                    newPharmacy.setName(model.getName());
                    newPharmacy.setAddress(model.getAddress());
                    return newPharmacy;
                });

        return pharmacyRepository.save(pharmacy);
    }
}
