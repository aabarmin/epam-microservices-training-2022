package com.epam.training.microservices.monolithic.web;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

/**
 * Test {@link DiseaseController}
 */
public class DiseaseControllerIT extends MockMvcTest {

    @Test
    @DisplayName("Test viewAll endpoint for Diseases")
    public void shouldReturnAllDiseasesList() throws Exception {
        MockHttpServletRequestBuilder viewAllReq = get("/diseases");
        this.mockMvc.perform(viewAllReq)
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("<title>The Drug System - Diseases</title>")))
                .andExpect(content().string(containsString(">Diseases</h1>")))
                .andExpect(content().string(containsString("<a href=\"/diseases/1\"")));
    }

    @Test
    @DisplayName("Test viewSingle endpoint for Diseases")
    public void shouldReturnSpecificDiseaseDetails() throws Exception {
        MockHttpServletRequestBuilder viewSingleReq = get("/diseases/1");
        this.mockMvc.perform(viewSingleReq)
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("<title>The Drug System - Edit Disease</title>")))
                .andExpect(content().string(containsString(">Edit Disease</h1>")))
                .andExpect(content().string(containsString("Asperger syndrome")))
                .andExpect(content().string(containsString("<input type=\"hidden\" id=\"id\" name=\"id\" value=\"1\"/>")))
                .andExpect(content().string(containsString("<button type=\"submit\" class=\"btn btn-primary\">Save</button>")))
                .andExpect(content().string(containsString("<a href=\"/diseases\" class=\"btn btn-link\">Back</a>")));
    }

    @Test
    @DisplayName("Test saveSingle endpoint for Diseases")
    public void shouldSaveDiseaseAndRedirect() throws Exception {
        MockHttpServletRequestBuilder saveSingleReq = post("/diseases")
                .param("name", "Edit Disease Name");
        this.mockMvc.perform(saveSingleReq)
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/diseases"));
    }

    @Disabled("FIXME https://github.com/aabarmin/epam-microservices-training-2022/issues/28")
    @Test
    @DisplayName("Test viewSingle for non-existent Disease")
    public void shouldReturnNotFoundForNonExistentDisease() throws Exception {
        MockHttpServletRequestBuilder viewSingleReq = get("/diseases/404404");
        this.mockMvc.perform(viewSingleReq)
                .andExpect(status().isNotFound());
    }
}
