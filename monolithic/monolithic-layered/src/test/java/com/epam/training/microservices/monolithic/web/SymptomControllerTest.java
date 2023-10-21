package com.epam.training.microservices.monolithic.web;

import com.epam.training.microservices.monolithic.model.disease.Symptom;
import com.epam.training.microservices.monolithic.service.symptom.SymptomService;
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

@WebMvcTest(SymptomController.class)
class SymptomControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    SymptomService symptomService;

    @Test
    void check_contextStarts() {
        assertThat(mockMvc).isNotNull();
    }

    @Test
    void viewAll_opens() throws Exception {
        mockMvc.perform(get("/symptoms"))
                .andExpect(status().isOk());
    }

    @Test
    void viewSingle_opens() throws Exception {
        when(symptomService.findOne(1L)).thenReturn(Optional.of(
                mock(Symptom.class)
        ));

        mockMvc.perform(get("/symptoms/{id}", 1L))
                .andExpect(status().isOk());

        verify(symptomService, times(1)).findOne(eq(1L));
    }
}