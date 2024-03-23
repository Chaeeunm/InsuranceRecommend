package com.metlife.eightseconds.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ai.client.AiClient;
import org.springframework.ai.prompt.Prompt;
import org.springframework.ai.prompt.messages.ChatMessage;
import org.springframework.ai.prompt.messages.Message;
import org.springframework.ai.prompt.messages.MessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//openAI
@RestController
public  class AiChatApplication// implements CommandLineRunner
{
    private static final String ROLE_INFO_KEY = "role";

    @Autowired
    private AiClient aiClient;
    
    static String res = null;
    
	@GetMapping("/testai")
    public String test(@RequestParam("input") String query) //throws Exception
    {
        System.out.println(String.format("Sending chat prompts to AI service. One moment please...\r\n"));

        final List<Message> msgs = new ArrayList<>();

        msgs.add(new ChatMessage(MessageType.SYSTEM, "You are a helpful assistant"));
        //assistant는 AI가 얘기한 것
        msgs.add(new ChatMessage(MessageType.USER, query));

        final var resps = aiClient.generate(new Prompt(msgs));

        System.out.println(String.format("Prompt created %d generated response(s).", resps.getGenerations().size()));

        resps.getGenerations().stream()
          .forEach(gen -> {
              final var role = gen.getInfo().getOrDefault(ROLE_INFO_KEY, MessageType.ASSISTANT.getValue());

              System.out.println(String.format("Generated respose from \"%s\": %s", role, gen.getText()));
              res = String.format("Generated respose from \"%s\": %s", role, gen.getText());
          });
        
        return res;
    	
    }

}