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
        
        String prompt_1 = "우리가 사용할 직업분류 코드야\r\n"
        		+ "01 사업관리\r\n"
        		+ "02 경영·회계·사무\r\n"
        		+ "03 금융·보험\r\n"
        		+ "04 교육·자연·사회과학\r\n"
        		+ "05 법률·경찰·소방·교도·국방\r\n"
        		+ "06 보건·의료\r\n"
        		+ "07 사회복지·종교\r\n"
        		+ "08 문화·예술·디자인·방송\r\n"
        		+ "09 운전·운송\r\n"
        		+ "10 영업판매\r\n"
        		+ "11 경비·청소\r\n"
        		+ "12 이용·숙박·여행·오락·스포츠\r\n"
        		+ "13 음식서비스·식품가공\r\n"
        		+ "14 건설\r\n"
        		+ "15 기 계\r\n"
        		+ "16 재 료\r\n"
        		+ "17 화 학\r\n"
        		+ "18 섬유·의복\r\n"
        		+ "19 전기·전자\r\n"
        		+ "20 정보통신\r\n"
        		+ "21 식품가공\r\n"
        		+ "22 인쇄·목재·가구·공예\r\n"
        		+ "23 환경·에너지·안전\r\n"
        		+ "24 농림어업\r\n"
        		+ "\r\n"
        		+ "보험 기준 코드는\r\n"
        		+ "01 보장기간\r\n"
        		+ "02 납부금액\r\n"
        		+ "03 납입기간\r\n"
        		+ "04 보험료 갱신여부는 (1번 비갱신보험, 2번 갱신형보험 )\r\n"
        		+ "05 보험금 지급형태는 (1번 일시지급, 2번 연금지급 )\r\n"
        		+ "06 보장질병은 string으로 여러 개 값이 넘어올 수 있어\r\n"
        		+ "답변은 '네'로만 해";
        
        msgs.add(new ChatMessage(MessageType.USER, prompt_1));
        msgs.add(new ChatMessage(MessageType.ASSISTANT, "네"));
        
        msgs.add(new ChatMessage(MessageType.USER, query));
        

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