package com.example.bookeshop.controllers;

import com.example.bookeshop.services.ChatGPTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatGPTController {

    @Autowired
    private ChatGPTService chatGPTService;

    @GetMapping("/test-chatgpt")
    public String testChatGPT() {
        return chatGPTService.getResponseFromChatGPT("Hello, world!");
    }

    @PostMapping("/ask")
    public String askChatGPT(@RequestBody String question) {
        return chatGPTService.getResponseFromChatGPT(question);
    }
}
