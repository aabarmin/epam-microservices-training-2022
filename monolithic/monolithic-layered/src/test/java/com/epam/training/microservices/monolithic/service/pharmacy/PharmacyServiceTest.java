package com.epam.training.microservices.monolithic.service.pharmacy;

import com.epam.training.microservices.monolithic.model.pharmacy.Pharmacy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PharmacyServiceTest {

    @Mock
    private PharmacyRepository pharmacyRepository;

    @InjectMocks
    private PharmacyService pharmacyService;

    @Test
    @DisplayName("Test getRepository method")
    void shouldGetRepository() {
        JpaRepository<Pharmacy, Long> resultRepo = pharmacyService.getRepository();
        assertEquals(pharmacyRepository, resultRepo);
    }

    @Test
    @DisplayName("Test save method")
    void shouldSavePharmacy() {
        Pharmacy pharmacy = new Pharmacy();
        when(pharmacyRepository.save(pharmacy)).thenReturn(pharmacy);

        Pharmacy savedPharmacy = pharmacyService.save(pharmacy);

        assertEquals(pharmacy, savedPharmacy);
    }

    @Test
    @DisplayName("Test findByName method")
    void shouldFindPharmacyByName() {
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.setName("HealthPlus");
        when(pharmacyRepository.findPharmacyByName("HealthPlus")).thenReturn(Optional.of(pharmacy));

        Optional<Pharmacy> foundPharmacy = pharmacyService.findByName("HealthPlus");

        assertTrue(foundPharmacy.isPresent());
        assertEquals(pharmacy, foundPharmacy.get());
    }
}
