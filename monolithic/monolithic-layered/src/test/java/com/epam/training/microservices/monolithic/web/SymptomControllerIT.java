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

    @Disabled("FIXME Enable test when #10 is fixed")
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

    @Disabled("FIXME #28 https://github.com/aabarmin/epam-microservices-training-2022/issues/28")
    @Test
    @DisplayName("Test viewSingle for non-existent Symptom")
    public void shouldReturnNotFoundForNonExistentSymptom() throws Exception {
        MockHttpServletRequestBuilder viewSingleReq = get("/symptoms/404404");
        this.mockMvc.perform(viewSingleReq)
                .andExpect(status().isNotFound());
    }
}
