package com.metlife.eightseconds.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.metlife.eightseconds.domain.dto.CoveredResponseDto;
import com.metlife.eightseconds.domain.dto.PersonalInfoRequestDto;
import com.metlife.eightseconds.domain.dto.ProductRequestDto;
import com.metlife.eightseconds.domain.dto.ProductResponseDto;
import com.metlife.eightseconds.domain.data.AIJsonResponse;
import com.metlife.eightseconds.domain.enums.PaymentType;
import com.metlife.eightseconds.domain.enums.RiskType;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
	private final AIChatService aiChatService;

	public ProductResponseDto recommendProduct(PersonalInfoRequestDto requestDto) {

		//생년월일 //질환 //

		String analysis = aiChatService.callAi(requestDto);

		//ai에게 받은 json에서 직업분류코드 추출
		Gson gson = new Gson();
		AIJsonResponse response = gson.fromJson(analysis, AIJsonResponse.class);

		ProductRequestDto productRequestDto = ProductRequestDto.builder().response(response).build();

		RiskType riskType = RiskType.findByCode(Integer.parseInt(response.getJob()));

		log.info("고객의 직업코드 : " + response.getJob()+  " 위험 등급 : " + riskType);

		//todo dao에서 가져오기
		ProductResponseDto productResponseDto = new ProductResponseDto();
		productResponseDto.setAiResponse(response.getAiResponse());
		productResponseDto.setProductPrice(priceByRiskType(riskType, response.getProductPrice()));

		productResponseDto.setCoverResponseList(makeMockData());

		return productResponseDto;
	}


	private int priceByRiskType(RiskType riskType, int productPrice) {
		switch (riskType) {
			case DANGER:
				return productPrice + 200;
			case SUPER_DANGER:
				return productPrice + 500;
			default:
				return productPrice;
		}
	}

		public List<CoveredResponseDto> makeMockData() {
			List<CoveredResponseDto> mockDataList = new ArrayList<>();

			mockDataList.add(CoveredResponseDto.builder()
				.coverId(1)
				.coverName("암진단")
				.diseaseName("일반암")
				.coverPrice(1000)
				.build());

			mockDataList.add(CoveredResponseDto.builder()
				.coverId(2)
				.coverName("암진단")
				.diseaseName("유방암")
				.coverPrice(2000)
				.build());

			mockDataList.add(CoveredResponseDto.builder()
				.coverId(3)
				.coverName("암진단")
				.diseaseName("갑상선암")
				.coverPrice(100)
				.build());

			mockDataList.add(CoveredResponseDto.builder()
				.coverId(4)
				.coverName("암진단")
				.diseaseName("소액암")
				.coverPrice(100)
				.build());

			Random random = new Random();
			int numSelected = random.nextInt(4) + 1; // 1에서 4 사이의 난수를 생성합니다.

			List<CoveredResponseDto> selectedMockDataList = new ArrayList<>();

			for (int i = 0; i < numSelected; i++) {
				int randomIndex = random.nextInt(mockDataList.size());
				selectedMockDataList.add(mockDataList.get(randomIndex));
			}

			return selectedMockDataList;
		}

}