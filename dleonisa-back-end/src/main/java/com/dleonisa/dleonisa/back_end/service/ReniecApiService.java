package com.dleonisa.dleonisa.back_end.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

public class ReniecApiService {
    @Value("${reniec.token}")
    private String token;

    @Value("${reniec.url}")
    private String baseUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public Map<String, Object> buscarDni(String dni) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Authorization", "Bearer " + token);

            HttpEntity<Void> entity = new HttpEntity<>(headers);

            ResponseEntity<Map> response = restTemplate.exchange(
                    baseUrl + dni,
                    HttpMethod.GET,
                    entity,
                    Map.class
            );

            return response.getBody();

        } catch (Exception e) {
            System.out.println("Error al consultar RENIEC API: " + e.getMessage());
            return null;
        }
    }
}
