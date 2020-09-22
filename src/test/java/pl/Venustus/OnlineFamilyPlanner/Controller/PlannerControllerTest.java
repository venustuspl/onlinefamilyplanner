package pl.Venustus.OnlineFamilyPlanner.Controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
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
        DayOfMonth day = new DayOfMonth((long) 1, "Maks", "aa", "aaa");
        DayOfMonth day1 = new DayOfMonth((long) 2, "Tom", "aa", "aaa");

//        HttpHeaders headers = new HttpHeaders();
//        headers.set("X-COM-PERSIST", "true");
//        headers.set("X-COM-LOCATION", "USA");

        HttpEntity<DayOfMonth> request = new HttpEntity<>(day);
        HttpEntity<DayOfMonth> request1 = new HttpEntity<>(day1);

        ResponseEntity<String> result = restTemplate.postForEntity(uri, request, String.class);
        System.out.println(result);

        ResponseEntity<String> result1 = restTemplate.postForEntity(uri, request1, String.class);
        System.out.println(result1);
        //Verify request succeed
        assertEquals(200, result.getStatusCodeValue());
    }
}