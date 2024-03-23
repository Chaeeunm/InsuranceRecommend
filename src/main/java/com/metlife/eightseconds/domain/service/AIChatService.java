package com.metlife.eightseconds.domain.service;

import com.metlife.eightseconds.domain.dto.AiCodeDto;
import com.metlife.eightseconds.domain.dto.AiRequestDto;
import com.metlife.eightseconds.domain.dto.PersonalInfoRequestDto;
import lombok.RequiredArgsConstructor;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;



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



@Service
@RequiredArgsConstructor
public class AIChatService {

    private static final String ROLE_INFO_KEY = "role";

    @Autowired
    private AiClient aiClient;

    static String res = null;


    public String callAi(PersonalInfoRequestDto personalInfoRequestDto) //throws Exception
    {
        System.out.println(String.format("Sending chat prompts to AI service. One moment please...\r\n"));

        final List<Message> msgs = new ArrayList<>();

        msgs.add(new ChatMessage(MessageType.SYSTEM, "You are a helpful assistant"));
        //assistant는 AI가 얘기한 것

        AiCodeDto code = new AiCodeDto();
        AiRequestDto request = new AiRequestDto();

        String prompt_1 = code.getPrompt();

        msgs.add(new ChatMessage(MessageType.USER, prompt_1));
        msgs.add(new ChatMessage(MessageType.ASSISTANT, "네"));

        String analyze = personalInfoRequestDto.getAnalyze();

        analyze = analyze.concat(request.getPrompt());

        msgs.add(new ChatMessage(MessageType.USER, analyze));


        final var resps = aiClient.generate(new Prompt(msgs));

        System.out.println(String.format("Prompt created %d generated response(s).", resps.getGenerations().size()));

        resps.getGenerations().stream()
                .forEach(gen -> {
                    final var role = gen.getInfo().getOrDefault(ROLE_INFO_KEY, MessageType.ASSISTANT.getValue());

                    System.out.println(String.format("Generated respose from \"%s\": %s", role, gen.getText()));
                    res = String.format("%s", gen.getText());
                });


        return res;

    }
}
