package com.metlife.eightseconds.domain.service;

import java.beans.Transient;

import org.springframework.stereotype.Service;

import com.metlife.eightseconds.domain.dto.PersonalInfoRequestDto;
import com.metlife.eightseconds.domain.dto.ProductResponseDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {

	public ProductResponseDto recommendProduct(PersonalInfoRequestDto requestDto) {


		//생년월일 //질환 //

		//

		//ai에게 받은 json에서 직업분류코드 추출

		//생년월일, 질환(질병명으로 걸러주기), 직업(직업분류코드)

		//직업분류코드 한번 돌려서 CD는 +200만원 E는 +500만원

		//원하는 조건

		//안전 1,2,3,4,7,8,10,12,13, 20,24
		//위험 5,6,9,11,14,15,16,17,18,19,21,22,23
		//초위험 : 14,15



		return null;
	}


	public ProductResponseDto analysisProduct() {



		return null;
	}
}
