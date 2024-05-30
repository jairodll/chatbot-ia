package com.ia.chatbotia.controller;

import com.ia.chatbotia.dto.ChatGPTResponse;
import com.ia.chatbotia.dto.ChatGPTRequest;
import com.ia.chatbotia.dto.mensajeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bot")
public class CustomBotController {

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiURL;

    @Autowired
    private RestTemplate template;

    @PostMapping("/chat")
    public String chat(@RequestBody mensajeDto datos){
        System.out.println("mensaje::  "+datos.getMensaje());
        ChatGPTRequest request = new ChatGPTRequest(model, datos.getMensaje());
        ChatGPTResponse chatGptResponse = template.postForObject(apiURL, request, ChatGPTResponse.class);
        return chatGptResponse.getChoices().get(0).getMessage().getContent();
    }
}
