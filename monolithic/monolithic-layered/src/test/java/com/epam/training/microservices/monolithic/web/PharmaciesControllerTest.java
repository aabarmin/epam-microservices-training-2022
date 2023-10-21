package com.epam.training.microservices.monolithic.web;

import com.epam.training.microservices.monolithic.model.drug.Drug;
import com.epam.training.microservices.monolithic.model.pharmacy.Pharmacy;
import com.epam.training.microservices.monolithic.service.pharmacy.PharmacyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PharmaciesController.class)
class PharmaciesControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    PharmacyService pharmacyService;

    @Test
    void check_contextStarts() {
        assertThat(mockMvc).isNotNull();
    }

    @Test
    void viewAll_opens() throws Exception {
        mockMvc.perform(get("/pharmacies"))
                .andExpect(status().isOk());
    }

    @Test
    void viewSingle_opens() throws Exception {
        when(pharmacyService.findOne(1L)).thenReturn(Optional.of(
                mock(Pharmacy.class)
        ));

        mockMvc.perform(get("/pharmacies/{id}", 1L))
                .andExpect(status().isOk());

        verify(pharmacyService, times(1)).findOne(eq(1L));
    }
}