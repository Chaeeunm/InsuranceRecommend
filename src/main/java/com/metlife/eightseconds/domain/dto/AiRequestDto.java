package com.metlife.eightseconds.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AiRequestDto {
    private String prompt = "\n 위 직업에 해당하는 직업분류코드와 보험 분류기준을 JSON 형식으로 알려줘.\r\n"
            +"직업분류코드의 key는 '00'이고 value는 직업분류코드로 대답해줘.\r\n"
            +"보험분류기준의 key는 분류코드로 알려주고 보험료 갱신여부 value는 숫자로, 보장질병의 value는 List 형식으로 변환해서 알려줘.\r\n"
            +"보장기간과 납입기간의 value는 월단위인 숫자로 변환해줘.\r\n"
            +"보험금지급형태의 값에 일시의 의미가 의미가 있는 단어가 들어가면 1, 연금의 의미가 있는 단어가 들어가면 2 로 넣어줘.\r\n"
            +"위 글을 요약해서 key는 '99'이고 value는 요약한 내용으로 대답해줘.\r\n"
            +"문장은 공손하고 친절하면서 전문적으로 명확하게 보이도록 대답해줘. 내용을 기준으로 보험을 추천해 줄 거야.\r\n";
}