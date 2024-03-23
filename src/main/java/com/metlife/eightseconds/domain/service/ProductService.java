package com.metlife.eightseconds.domain.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.metlife.eightseconds.domain.dto.PersonalInfoRequestDto;
import com.metlife.eightseconds.domain.dto.ProductResponseDto;
import com.metlife.eightseconds.domain.data.AIResponse;
import com.metlife.eightseconds.domain.enums.PaymentType;
import com.metlife.eightseconds.domain.enums.RiskType;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	public ProductResponseDto recommendProduct(PersonalInfoRequestDto requestDto) {

		//생년월일 //질환 //

		//
		String analysis = "{\"00\":\"Software Engineer\",\"01\":20,\"02\":100000000,\"03\":10,\"04\":2,\"05\":1,\"06\":[\"Cancer\",\"Heart\",\"Thyroid\"]}";


		//ai에게 받은 json에서 직업분류코드 추출
		Gson gson = new Gson();
		AIResponse response = gson.fromJson(analysis, AIResponse.class);

		//생년월일, 질환(질병명으로 걸러주기), 직업(직업분류코드)


		//직업분류코드 한번 돌려서 CD는 +200만원 E는 +500만원

		//원하는 조건

		//안전 1,2,3,4,7,8,10,12,13, 20,24
		//위험 5,6,9,11,14,15,16,17,18,19,21,22,23
		//초위험 : 14,15

		//DAO에 넘겨줘야 할것 : 보장기간, 보험금, 납입기간, 보험료 타입(0이면 비갱신, 2면 갱신), 보장질병 String List

		//보장기간
		response.getGuaranteePeriod();

		//보험금
		response.getProductPrice();

		//납입기간
		response.getPaymentPeriod();

		//보험료 타입
		Boolean renewYn = (response.getRenewYn().equals("1")?false:true);
		PaymentType paymentType = response.getPaymentType().equals("1")?PaymentType.ALL:PaymentType.ANNUAL;

		List<String> coverDisease = response.getCoverDisease();

		RiskType riskType = RiskType.findByCode(Integer.parseInt(response.getJob()));

		return null;
	}


	public ProductResponseDto analysisProduct() {



		return null;
	}
}