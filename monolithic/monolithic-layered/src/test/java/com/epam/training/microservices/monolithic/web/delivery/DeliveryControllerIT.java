package com.epam.training.microservices.monolithic.web.delivery;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.epam.training.microservices.monolithic.web.MockMvcTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

/**
 * Test {@link DeliveryController}
 */
public class DeliveryControllerIT extends MockMvcTest {

    @Test
    @DisplayName("Test viewAll endpoint")
    public void shouldReturnAllDeliveriesList() throws Exception {
        MockHttpServletRequestBuilder viewAllReq = get("/delivery");
        this.mockMvc.perform(viewAllReq)
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("<title>The Drug System - Delivery</title>")))
                .andExpect(content().string(containsString(">Delivery</h1>")))
                .andExpect(content().string(containsString("<a href=\"/delivery/1\"")))
        ;
    }

    @Test
    @DisplayName("Test editDelivery endpoint")
    public void shouldReturnSpecificDeliveryDetails() throws Exception {
        MockHttpServletRequestBuilder editDeliveryReq = get("/delivery/1");
        this.mockMvc.perform(editDeliveryReq)
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("<title>The Drug System - Edit Delivery</title>")))
                .andExpect(content().string(containsString(">Edit Delivery</h1>")))
                .andExpect(content().string(containsString("<input type=\"hidden\" id=\"id\" name=\"id\" value=\"1\"")))
                .andExpect(content().string(containsString("1 Cherokee Hill")))
                .andExpect(content().string(containsString("<button type=\"submit\" class=\"btn btn-primary\">Save</button>")))
                .andExpect(content().string(containsString("<a href=\"/delivery\" class=\"btn btn-link\">Back</a>")));
    }

    @Test
    @DisplayName("Test editDelivery for non-existent Delivery")
    public void shouldReturnNotFoundForNonExistentDelivery() throws Exception {
        MockHttpServletRequestBuilder editDeliveryReq = get("/delivery/404404");
        this.mockMvc.perform(editDeliveryReq)
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("<h4 class=\"alert-heading\"><i class=\"bi-exclamation-octagon-fill\"></i>Oops! Data not found</h4>")))
                .andExpect(content().string(containsString("<p>Sorry, we couldn't find the <span >Delivery</span> with id: <span >404404</span></p>")))
                .andExpect(content().string(containsString("<p class=\"mb-0\">Please provide the correct <span >Delivery</span> id</p>")));
    }
}
