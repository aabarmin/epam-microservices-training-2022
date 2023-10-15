package com.epam.training.microservices.monolithic.web;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * Test {@link DrugController}
 */
@Transactional
@SpringBootTest
@AutoConfigureMockMvc
public class DrugControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test viewAll endpoint")
    public void shouldReturnDrugsList() throws Exception {
        this.mockMvc.perform(get("/drugs"))
                .andDo(print())
                .andExpect(status().isOk())
                // TODO uncomment after fix of #8
                // .andExpect(content().string(containsString("<title>The Drug System - Drugs</title>")))
                .andExpect(content().string(containsString(">Drugs</h1>")))
                .andExpect(content().string(containsString("<a href=\"/drugs/1\"")));
    }
}
