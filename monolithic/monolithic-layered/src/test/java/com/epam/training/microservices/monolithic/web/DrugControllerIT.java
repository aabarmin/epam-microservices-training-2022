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
 * Test {@link DrugController}
 */
public class DrugControllerIT extends MockMvcTest {

    @Test
    @DisplayName("Test viewAll endpoint")
    public void shouldReturnAllDrugsList() throws Exception {
        MockHttpServletRequestBuilder viewAllReq = get("/drugs");
        this.mockMvc.perform(viewAllReq)
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("<title>The Drug System - Drugs</title>")))
                .andExpect(content().string(containsString(">Drugs</h1>")))
                .andExpect(content().string(containsString("<a href=\"/drugs/1\"")));
    }

    @Test
    @DisplayName("Test viewSingle endpoint")
    public void shouldReturnSpecificDrugDetails() throws Exception {
        MockHttpServletRequestBuilder viewSingleReq = get("/drugs/1");
        this.mockMvc.perform(viewSingleReq)
                // uncomment to see HTML response body
                // .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("<title>The Drug System - Edit Drug</title>")))
                .andExpect(content().string(containsString(">Edit Drug</h1>")))
                .andExpect(content().string(containsString("Acetylcholinesterase inhibitors")))
                .andExpect(content().string(containsString("<input type=\"hidden\" id=\"id\" name=\"id\" value=\"1\"/>")))
                .andExpect(content().string(containsString("<button type=\"submit\" class=\"btn btn-primary\">Save</button>")))
                .andExpect(content().string(containsString("<a href=\"/drugs\" class=\"btn btn-link\">Back</a>")));
    }

    @Test
    @DisplayName("Test saveSingle endpoint")
    public void shouldSaveAndRedirect() throws Exception {
        MockHttpServletRequestBuilder saveSingleReq = post("/drugs")
                .param("name", "Edit Drug Name")
                .param("description", "Description for the drug");
        this.mockMvc.perform(saveSingleReq)
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/drugs"));
    }

    @Disabled("FIXME https://github.com/aabarmin/epam-microservices-training-2022/issues/28")
    @Test
    @DisplayName("Test viewSingle for non-existent Drug")
    public void shouldReturnNotFoundForNonExistentDrug() throws Exception {
        MockHttpServletRequestBuilder viewSingleReq = get("/drugs/404404");
        this.mockMvc.perform(viewSingleReq)
                .andExpect(status().isNotFound());
    }
}
