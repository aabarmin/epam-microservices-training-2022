package com.epam.training.microservices.monolithic.service.load;

import com.epam.training.microservices.monolithic.model.delivery.Delivery;
import com.epam.training.microservices.monolithic.model.delivery.DeliveryLine;
import com.epam.training.microservices.monolithic.model.disease.Disease;
import com.epam.training.microservices.monolithic.model.disease.Symptom;
import com.epam.training.microservices.monolithic.model.drug.Drug;
import com.epam.training.microservices.monolithic.model.pharmacy.Pharmacy;
import com.epam.training.microservices.monolithic.model.pharmacy.PharmacyAvailable;
import com.epam.training.microservices.monolithic.model.recipie.Doctor;
import com.epam.training.microservices.monolithic.model.recipie.Recipe;
import com.epam.training.microservices.monolithic.model.recipie.RecipeLine;
import com.epam.training.microservices.monolithic.model.recipie.Recipient;
import com.epam.training.microservices.monolithic.service.delivery.DeliveryService;
import com.epam.training.microservices.monolithic.service.disease.DiseaseService;
import com.epam.training.microservices.monolithic.service.doctor.DoctorService;
import com.epam.training.microservices.monolithic.service.doctor.RecipeService;
import com.epam.training.microservices.monolithic.service.doctor.RecipientService;
import com.epam.training.microservices.monolithic.service.drug.DrugService;
import com.epam.training.microservices.monolithic.service.load.disease.DiseaseLoadModel;
import com.epam.training.microservices.monolithic.service.load.doctor.DoctorLoadModel;
import com.epam.training.microservices.monolithic.service.load.doctor.RecipeLineLoadModel;
import com.epam.training.microservices.monolithic.service.load.doctor.RecipeLoadModel;
import com.epam.training.microservices.monolithic.service.load.pharmacy.PharmacyDrugLoadModel;
import com.epam.training.microservices.monolithic.service.load.pharmacy.PharmacyLoadModel;
import com.epam.training.microservices.monolithic.service.pharmacy.PharmacyService;
import com.epam.training.microservices.monolithic.service.symptom.SymptomService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile("dev")
public class TestDataImportService implements ApplicationListener<ContextRefreshedEvent> {
  @Value("classpath:test-data/diseases.json")
  private Resource diseasesResource;

  @Value("classpath:test-data/doctor-and-recipies.json")
  private Resource doctorResource;

  @Value("classpath:test-data/pharmacy.json")
  private Resource pharmacyResource;

  @Autowired
  private SymptomService symptomService;

  @Autowired
  private DiseaseService diseaseService;

  @Autowired
  private DoctorService doctorService;

  @Autowired
  private RecipientService recipientService;

  @Autowired
  private RecipeService recipeService;

  @Autowired
  private DrugService drugService;

  @Autowired
  private PharmacyService pharmacyService;

  @Autowired
  private DeliveryService deliveryService;

  @Autowired
  private ObjectMapper objectMapper;

  @Override
  public void onApplicationEvent(ContextRefreshedEvent event) {
    log.info("Loading test data");

    importDrugsAndDiseases();
    importDoctorsAndRecipes();
    importPharmacyAndOrders();

    log.info("Test data loaded");
  }

  @SneakyThrows
  private void importPharmacyAndOrders() {
    @Cleanup final InputStream contentStream = pharmacyResource.getInputStream();
    objectMapper
        .readValue(contentStream, new TypeReference<List<PharmacyLoadModel>>() {})
        .forEach(this::importPharmacyAndOrders);
  }

  @SneakyThrows
  private void importDoctorsAndRecipes() {
    @Cleanup final InputStream contentStream = doctorResource.getInputStream();
    objectMapper
        .readValue(contentStream, new TypeReference<List<DoctorLoadModel>>() {})
        .forEach(this::importDoctorAndRecipe);
  }

  private void importPharmacyAndOrders(PharmacyLoadModel model) {
    final Pharmacy pharmacy = importPharmacy(model);

    final Set<PharmacyAvailable> availableDrugs = model.getDrugs()
        .stream()
        .map(available -> {
          final PharmacyAvailable availableDrug = new PharmacyAvailable();
          availableDrug.setPharmacy(pharmacy);
          availableDrug.setDrug(drugService.findByName(available.getDrugName()).get());
          availableDrug.setAmount(available.getAmount());
          return availableDrug;
        })
        .collect(Collectors.toSet());

    pharmacy.getAvailable().addAll(availableDrugs);

    pharmacyService.save(pharmacy);

    model.getOrders()
        .stream()
        .map(order -> {
          final Delivery newDelivery = new Delivery();
          newDelivery.setPharmacy(pharmacy);
          newDelivery.setAddressLine(order.getAddress());
          newDelivery.setStatus(order.getStatus());

          final Set<DeliveryLine> deliveryLines = order.getContent()
              .stream()
              .map(item -> {
                final DeliveryLine newLine = new DeliveryLine();
                newLine.setDelivery(newDelivery);
                newLine.setAmount(item.getAmount());
                newLine.setDrug(drugService.findByName(item.getDrug()).get());
                return newLine;
              })
              .collect(Collectors.toSet());

          newDelivery.setContent(deliveryLines);

          return newDelivery;
        })
        .forEach(deliveryService::save);


  }

  private Pharmacy importPharmacy(PharmacyLoadModel model) {
    final Pharmacy pharmacy = pharmacyService.findByName(model.getName())
        .orElseGet(() -> {
          final Pharmacy newPharmacy = new Pharmacy();
          newPharmacy.setName(model.getName());
          newPharmacy.setAddress(model.getAddress());
          return newPharmacy;
        });

    return pharmacyService.save(pharmacy);
  }

  private void importDoctorAndRecipe(DoctorLoadModel model) {
    final Doctor doctor = importDoctor(model);
    for (RecipeLoadModel recipeModel : model.getRecipes()) {
      final Recipient recipient = importRecipient(recipeModel);

      final Recipe recipe = recipeService.find(doctor, recipient, recipeModel.getIssueDate())
          .orElseGet(() -> {
            final Recipe newRecipe = new Recipe();
            newRecipe.setDoctor(doctor);
            newRecipe.setRecipient(recipient);
            newRecipe.setIssueDate(recipeModel.getIssueDate());
            return newRecipe;
          });

      final Set<RecipeLine> recipeLines = recipeModel.getContent()
          .stream()
          .map(line -> {
            final RecipeLine newLine = new RecipeLine();
            newLine.setAmount(line.getAmount());
            newLine.setInstruction(line.getInstruction());
            newLine.setDrug(
                drugService.findByName(line.getDrug()).get()
            );
            newLine.setRecipe(recipe);
            return newLine;
          })
          .collect(Collectors.toSet());

      recipe.getLines().addAll(recipeLines);

      recipeService.save(recipe);
    }
  }

  private Recipient importRecipient(RecipeLoadModel recipeModel) {
    final Recipient recipient = recipientService.findByName(
        recipeModel.getRecipient().getFirstName(),
        recipeModel.getRecipient().getLastName()
    )
        .orElseGet(() -> {
          final Recipient newRecipient = new Recipient();
          newRecipient.setFirstName(recipeModel.getRecipient().getFirstName());
          newRecipient.setLastName(recipeModel.getRecipient().getLastName());
          return newRecipient;
        });

    return recipientService.save(recipient);
  }

  private Doctor importDoctor(DoctorLoadModel model) {
    final Doctor doctor = doctorService.findByName(
        model.getDoctor().getFirstName(),
        model.getDoctor().getLastName()
    )
        .orElseGet(() -> {
          final Doctor newDoctor = new Doctor();
          newDoctor.setFirstName(model.getDoctor().getFirstName());
          newDoctor.setLastName(model.getDoctor().getLastName());
          return newDoctor;
        });

    return doctorService.save(doctor);
  }

  @SneakyThrows
  private void importDrugsAndDiseases() {
    @Cleanup final InputStream contentStream = diseasesResource.getInputStream();
    objectMapper
        .readValue(contentStream, new TypeReference<List<DiseaseLoadModel>>(){})
        .forEach(this::importDrugAndDisease);
  }

  private void importDrugAndDisease(DiseaseLoadModel model) {
    final Disease disease = importDisease(model);
    importDrugs(model, disease);
  }

  private void importDrugs(DiseaseLoadModel model, Disease disease) {
    for (String drugName : model.getDrugs()) {
      final Drug drug = drugService.findByName(drugName)
          .orElseGet(() -> {
            final Drug newDrug = new Drug();
            newDrug.setName(drugName);
            newDrug.setAvailable(true);
            return newDrug;
          });

      drug.getDiseases().add(disease);
      drug.getSymptoms().addAll(disease.getSymptoms());

      drugService.save(drug);
    }
  }

  private Disease importDisease(DiseaseLoadModel model) {
    final Disease disease = diseaseService.findByName(model.getDisease())
        .orElseGet(() -> {
          final Disease newDisease = new Disease();
          newDisease.setName(model.getDisease());
          return newDisease;
        });

    final Set<Symptom> symptoms = model.getSymptoms().stream()
        .map(this::findOrCreateSymptom)
        .collect(Collectors.toSet());

    disease.setSymptoms(symptoms);

    return diseaseService.save(disease);
  }

  private Symptom findOrCreateSymptom(String symptomName) {
    return symptomService.findByName(symptomName)
        .orElseGet(() -> {
          final Symptom newSymptom = new Symptom();
          newSymptom.setName(symptomName);
          return newSymptom;
        });
  }
}
