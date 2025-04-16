package com.artu.fullstack_team_project_application.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WidgetControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void getUsedWidgetsByUserIdTest() {
        ResponseEntity<List> response = restTemplate.getForEntity("/api/widgets/used?userId=user1001", List.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        System.out.println("Widgets: " + response.getBody());
    }

    @Test
    void updateOrderTest() {
        List<Map<String, Object>> orders = List.of(
                Map.of("widget_id", 1, "user_id", "user1001", "order", 123),
                Map.of("widget_id", 2, "user_id", "user1001", "order", 124)
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<List<Map<String, Object>>> request = new HttpEntity<>(orders, headers);

        ResponseEntity<String> response = restTemplate.postForEntity("/api/widgets/order", request, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
