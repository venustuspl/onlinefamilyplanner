package pl.Venustus.OnlineFamilyPlanner.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import pl.Venustus.OnlineFamilyPlanner.Domain.DayOfMonth;

import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlannerControllerTest {

    @Test
    void testSaveDayOfMonthDto_succes() throws URISyntaxException {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:8080/save";
        URI uri = new URI(baseUrl);
        DayOfMonth day = new DayOfMonth((long) 1, "Adam", "Gilly", "test@email.com");

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-COM-PERSIST", "true");
        headers.set("X-COM-LOCATION", "USA");

        HttpEntity<DayOfMonth> request = new HttpEntity<>(day, headers);

        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);

        //Verify request succeed
        assertEquals(201, result.getStatusCodeValue());
    }
}