package com.example.bookeshop.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class ChatGPTService {

    private final RestTemplate restTemplate;
    private final String apiBaseUrl;

    @Value("${chatgpt.api.key}")
    private String apiKey;

    public ChatGPTService() {
        this.restTemplate = new RestTemplate();
        this.apiBaseUrl = "https://api.openai.com/v1/engines/davinci-002/completions";

    }

    public String getResponseFromChatGPT(String prompt) {
        try {
            String url = apiBaseUrl;

            HttpHeaders headers = new HttpHeaders();
            headers.setBearerAuth(apiKey);
            headers.setContentType(MediaType.APPLICATION_JSON);
            headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

            Map<String, Object> map = new HashMap<>();
            map.put("prompt", prompt);
            map.put("max_tokens", 150);

            HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(map, headers);

            ResponseEntity<String> response = restTemplate.postForEntity(url, requestEntity, String.class);
            return response.getBody();
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
            return "Error: " + e.getStatusCode() + " - " + e.getResponseBodyAsString();
        }
    }
}



