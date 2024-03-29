package com.epam.training.microservices.monolithic.web;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test {@link SymptomController}
 */
public class SymptomControllerIT extends MockMvcTest {

    @Test
    @DisplayName("Test viewAll endpoint")
    public void shouldReturnAllSymptomsList() throws Exception {
        MockHttpServletRequestBuilder viewAllReq = get("/symptoms");
        this.mockMvc.perform(viewAllReq)
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(">Symptoms</h1>")))
                .andExpect(content().string(containsString("<a href=\"/symptoms/1\"")));
    }

    @Test
    @DisplayName("Test viewSingle endpoint")
    public void shouldReturnSpecificSymptomDetails() throws Exception {
        MockHttpServletRequestBuilder viewSingleReq = get("/symptoms/1");
        this.mockMvc.perform(viewSingleReq)
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(">Edit Symptom</h1>")))
                .andExpect(content().string(containsString("Problems with social interaction")))
                .andExpect(content().string(containsString("<input type=\"hidden\" id=\"id\" name=\"id\" value=\"1\"/>")))
                .andExpect(content().string(containsString("<button type=\"submit\" class=\"btn btn-primary\">Save</button>")));
    }

    @Test
    @DisplayName("Test saveSingle endpoint")
    public void shouldSaveSymptomAndRedirect() throws Exception {
        MockHttpServletRequestBuilder saveSingleReq = post("/symptoms")
                .param("name", "Edit Symptom Name")
                .param("description", "Description for the symptom");
        this.mockMvc.perform(saveSingleReq)
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/symptoms"));
    }

    @Test
    @DisplayName("Test viewSingle for non-existent Symptom")
    public void shouldReturnNotFoundForNonExistentSymptom() throws Exception {
        MockHttpServletRequestBuilder viewSingleReq = get("/symptoms/404404");
        this.mockMvc.perform(viewSingleReq)
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("<h4 class=\"alert-heading\"><i class=\"bi-exclamation-octagon-fill\"></i>Oops! Data not found</h4>")))
                .andExpect(content().string(containsString("<p>Sorry, we couldn't find the <span >Symptom</span> with id: <span >404404</span></p>")))
                .andExpect(content().string(containsString("<p class=\"mb-0\">Please provide the correct <span >Symptom</span> id</p>")));
    }

    @Disabled("FIXME #52 https://github.com/aabarmin/epam-microservices-training-2022/issues/52")
    @Test
    @DisplayName("Test for invalid input")
    public void shouldReturnBadRequestForInvalidInput() throws Exception {
        String name = "Value longer than 255 characters cannot handled by database." +
                "Value longer than 255 characters cannot handled by database." +
                "Value longer than 255 characters cannot handled by database." +
                "Value longer than 255 characters cannot handled by database." +
                "Value longer than 255 characters cannot handled by database.";

        MockHttpServletRequestBuilder saveSingleReq = post("/symptoms")
                .param("name", name)
                .param("description", "Description for the symptom");
        this.mockMvc.perform(saveSingleReq)
                .andExpect(status().isBadRequest())
                .andExpect(redirectedUrl("/symptoms"));
    }
}
