package com.epam.training.microservices.monolithic.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Test {@link HomeRedirectController}
 */
public class HomeRedirectControllerIT extends MockMvcTest {

    @Test
    @DisplayName("Test root path redirect to /drugs")
    public void shouldRedirectToDrugsFromRoot() throws Exception {
        MockHttpServletRequestBuilder request = get("/");
        this.mockMvc.perform(request)
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/drugs"));
    }
}
