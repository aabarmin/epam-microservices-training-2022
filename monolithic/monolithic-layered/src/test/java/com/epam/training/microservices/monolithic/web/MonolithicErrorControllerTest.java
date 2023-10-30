package com.epam.training.microservices.monolithic.web;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MonolithicErrorControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    @DisplayName("Test for 404 not found page")
    public void shouldReturnNotFoundPage() {
        ResponseEntity<String> response = testRestTemplate.getForEntity("/symptom/404", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody()).contains("<h4 class=\"alert-heading\"><i class=\"bi-exclamation-octagon-fill\"></i>Oops! Page not found</h4>");
        assertThat(response.getBody()).contains("<p>Sorry, we couldn't find the page you were looking for.</p>");
    }

    @Test
    @DisplayName("Test for internal server error page")
    public void shouldReturnInternalServerErrorPage() {
        String name = "Value longer than 255 characters cannot handled by database." +
                "Value longer than 255 characters cannot handled by database." +
                "Value longer than 255 characters cannot handled by database." +
                "Value longer than 255 characters cannot handled by database." +
                "Value longer than 255 characters cannot handled by database.";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("id", "500");
        map.add("name", name);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        ResponseEntity<String> response = testRestTemplate.exchange("/symptoms", HttpMethod.POST, request, String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR);
        assertThat(response.getBody()).contains("<h4 class=\"alert-heading\"><i class=\"bi-exclamation-octagon-fill\"></i>Oops! Something went wrong!</h4>");
        assertThat(response.getBody()).contains("<p>Sorry, There is some issue, We are fixing it.</p>");
        assertThat(response.getBody()).contains("<p class=\"mb-0\">Please check again later</p>");
    }

    @Test
    @DisplayName("Test for general error page")
    public void shouldReturnGeneralErrorPage() {
        ResponseEntity<String> response = testRestTemplate.getForEntity("/symptoms/404Abc", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(response.getBody()).contains("<h4 class=\"alert-heading\"><i class=\"bi-exclamation-octagon-fill\"></i>Oops! Something went wrong!</h4>");
        assertThat(response.getBody()).contains("<p>Sorry, There is some issue, Our Engineers are on it.</p>");
        assertThat(response.getBody()).contains("<p class=\"mb-0\">Please check again later</p>");
    }

}