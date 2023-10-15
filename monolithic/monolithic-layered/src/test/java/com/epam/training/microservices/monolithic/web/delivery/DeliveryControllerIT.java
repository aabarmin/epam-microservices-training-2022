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
                // TODO uncomment after fix of #8
                // .andExpect(content().string(containsString("<title>The Drug System - Delivery</title>")))
                .andExpect(content().string(containsString(">Delivery</h1>")))
                // TODO uncomment when #7 is fixed
                // .andExpect(content().string(containsString("<a href=\"/delivery/1\"")))
        ;
    }

    @Test
    @DisplayName("Test editDelivery endpoint")
    public void shouldReturnSpecificDeliveryDetails() throws Exception {
        MockHttpServletRequestBuilder editDeliveryReq = get("/delivery/1");
        this.mockMvc.perform(editDeliveryReq)
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("<title>The Drug System - Delivery</title>")))
                .andExpect(content().string(containsString("<h1>Edit Delivery</h1>")))
                .andExpect(content().string(containsString("<input type=\"hidden\" id=\"id\" name=\"id\" value=\"1\" />")))
                .andExpect(content().string(containsString("1 Cherokee Hill")))
                .andExpect(content().string(containsString("<button type=\"submit\" class=\"btn btn-primary\">Save</button>")))
                .andExpect(content().string(containsString("<a href=\"/delivery\" class=\"btn btn-link\">Back</a>")));
    }

    @Disabled("FIXME #28 https://github.com/aabarmin/epam-microservices-training-2022/issues/28")
    @Test
    @DisplayName("Test editDelivery for non-existent Delivery")
    public void shouldReturnNotFoundForNonExistentDelivery() throws Exception {
        MockHttpServletRequestBuilder editDeliveryReq = get("/delivery/404404");
        this.mockMvc.perform(editDeliveryReq)
                .andExpect(status().isNotFound());
    }
}
