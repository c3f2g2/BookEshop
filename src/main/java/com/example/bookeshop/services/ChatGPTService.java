package com.example.bookeshop.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import java.util.Collections;

@Service
public class ChatGPTService {

    private final RestTemplate restTemplate;
    private final String apiBaseUrl;

    @Value("${chatgpt.api.key}")
    private String apiKey;

    public ChatGPTService() {
        this.restTemplate = new RestTemplate();
        this.apiBaseUrl = "https://api.openai.com/v1/chat/completions"; // Replace with actual API URL
    }

    public String getResponseFromChatGPT(String prompt) {
        try {
            String url = apiBaseUrl + "https://api.openai.com/v1/chat/completions"; // Modify as needed

            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(apiKey);
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            // Construct request body (customize as per the API documentation)
            String requestBody = "{\"prompt\": \"" + prompt + "\", \"max_tokens\": 150}";

            HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

            ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            // Log and handle errors appropriately
            e.printStackTrace();
            return "Error: " + e.getStatusCode() + " - " + e.getResponseBodyAsString();
        }
    }
}

