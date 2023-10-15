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
 * Test {@link PharmaciesController}
 */
public class PharmaciesControllerIT extends MockMvcTest {

    @Test
    @DisplayName("Test viewAll endpoint")
    public void shouldReturnAllPharmaciesList() throws Exception {
        MockHttpServletRequestBuilder viewAllReq = get("/pharmacies");
        this.mockMvc.perform(viewAllReq)
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(">Pharmacies</h1>")))
                .andExpect(content().string(containsString("<a href=\"/pharmacies/1\"")));
    }

    @Test
    @DisplayName("Test viewSingle endpoint")
    public void shouldReturnSpecificPharmacyDetails() throws Exception {
        MockHttpServletRequestBuilder viewSingleReq = get("/pharmacies/1");
        this.mockMvc.perform(viewSingleReq)
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(">Edit Pharmacy</h1>")))
                .andExpect(content().string(containsString("Twimm")))
                .andExpect(content().string(containsString("<input type=\"hidden\" id=\"id\" name=\"id\" value=\"1\"/>")))
                .andExpect(content().string(containsString("<button type=\"submit\" class=\"btn btn-primary\">Save</button>")));
    }

    @Test
    @DisplayName("Test saveSingle endpoint")
    public void shouldSavePharmacyAndRedirect() throws Exception {
        MockHttpServletRequestBuilder saveSingleReq = post("/pharmacies")
                .param("name", "New Pharmacy Name")
                .param("address", "123 Pharmacy St.");
        this.mockMvc.perform(saveSingleReq)
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/pharmacies"));
    }

    @Disabled("FIXME https://github.com/aabarmin/epam-microservices-training-2022/issues/28")
    @Test
    @DisplayName("Test viewSingle for non-existent Pharmacy")
    public void shouldReturnNotFoundForNonExistentPharmacy() throws Exception {
        MockHttpServletRequestBuilder viewSingleReq = get("/pharmacies/404404");
        this.mockMvc.perform(viewSingleReq)
                .andExpect(status().isNotFound());
    }
}
