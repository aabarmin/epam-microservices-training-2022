package com.epam.training.microservices.monolithic.web;

import com.epam.training.microservices.monolithic.model.drug.Drug;
import com.epam.training.microservices.monolithic.service.drug.DrugService;
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

@WebMvcTest(DrugController.class)
class DrugControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    DrugService drugService;

    @Test
    void check_contextStarts() {
        assertThat(mockMvc).isNotNull();
    }

    @Test
    void viewAll_opens() throws Exception {
        mockMvc.perform(get("/drugs"))
                .andExpect(status().isOk());
    }

    @Test
    void viewSingle_opens() throws Exception {
        when(drugService.findOne(1L)).thenReturn(Optional.of(
                mock(Drug.class)
        ));

        mockMvc.perform(get("/drugs/{id}", 1L))
                .andExpect(status().isOk());

        verify(drugService, times(1)).findOne(eq(1L));
    }
}