package com.epam.training.microservices.monolithic.exception.handler;

import com.epam.training.microservices.monolithic.exception.ResourceNotFoundException;
import com.epam.training.microservices.monolithic.service.symptom.SymptomService;
import com.epam.training.microservices.monolithic.web.SymptomController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SymptomController.class)
class MonolithicControllerExceptionHandlerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    SymptomService symptomService;

    @MockBean
    MonolithicControllerExceptionHandler monolithicControllerExceptionHandler;

    @Test
    void viewSingle_exception_thrown() throws Exception {
        when(symptomService.findOne(1L)).thenThrow(new ResourceNotFoundException("Symptom", 1L));

        mockMvc.perform(get("/symptoms/{id}", 1L))
                .andExpect(status().isOk())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof ResourceNotFoundException))
                .andExpect(result -> assertThat(((ResourceNotFoundException) result.getResolvedException()).getResourceName()).isEqualTo("Symptom"))
                .andExpect(result -> assertThat(((ResourceNotFoundException) result.getResolvedException()).getResourceId()).isEqualTo(1L));

        verify(symptomService, times(1)).findOne(eq(1L));
        verify(monolithicControllerExceptionHandler, times(1)).resourceNotFoundExceptionHandler(any(), any());
    }

}