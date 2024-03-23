package com.metlife.eightseconds.controller;

import com.metlife.eightseconds.controller.AiChatApplication;
import com.metlife.eightseconds.domain.service.AIChatService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.metlife.eightseconds.domain.dto.CoveredResponseDto;
import com.metlife.eightseconds.domain.dto.PersonalInfoRequestDto;
import com.metlife.eightseconds.domain.dto.ProductResponseDto;
import com.metlife.eightseconds.domain.enums.PaymentType;
import com.metlife.eightseconds.domain.enums.ProductType;
import com.metlife.eightseconds.domain.enums.RiskType;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
public class PersonalInfoController {

	private final AIChatService aIChatService;

	public PersonalInfoController(AIChatService aIChatService) {
		this.aIChatService = aIChatService;
	}

	@PostMapping("/personalInfo")
	public ResponseEntity<ProductResponseDto> postPersonalInfo(
		@Valid @RequestBody PersonalInfoRequestDto requestDto
//		@RequestParam(required = true) ProductType productType
	){
		String res = aIChatService.callAi(requestDto);
		// ProductResponseDto 생성
        ProductResponseDto responseDto = new ProductResponseDto();
        responseDto.setProductId(1);
        
        responseDto.setProductName("iM 암보험 무배당 2309");
        responseDto.setProductPrice(710);
        responseDto.setProductDate("2024-12-31");
        responseDto.setProductType("DISEASE");
        responseDto.setProductExp(5);
        responseDto.setMinAge(20);
        responseDto.setMaxAge(65);
        responseDto.setAge("20세 ~ 60세");
        responseDto.setProductEtc("무배당 갱신형");
        responseDto.setPaymentMinPeriod(1);
        responseDto.setPaymentMaxPeriod(10);
        responseDto.setRenewYn(true);
        responseDto.setPaymentType(PaymentType.ALL);
        responseDto.setInterestRate(0.05);
        responseDto.setDangerRank(RiskType.DANGER);
        responseDto.setAiText(res.split("99")[1].substring(4, res.split("99")[1].length()-3));

        // CoveredResponseDto 리스트 생성
        List<CoveredResponseDto> coverResponseList = new ArrayList<>();
        CoveredResponseDto covered1 = new CoveredResponseDto();
        covered1.setCoverId(1);
        covered1.setCoverName("암진단");
        covered1.setDiseaseName("일반암");
        covered1.setCoverPrice(5000);
        coverResponseList.add(covered1);

        CoveredResponseDto covered2 = new CoveredResponseDto();
        covered2.setCoverId(2);
        covered2.setCoverName("암진단");
        covered2.setDiseaseName("유방암");
        covered2.setCoverPrice(200);
        coverResponseList.add(covered2);

        responseDto.setCoverResponseList(coverResponseList);
        
        System.out.println(responseDto.toString());


        return ResponseEntity.ok(responseDto);
	}
}