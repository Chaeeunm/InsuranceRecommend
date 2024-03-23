package com.metlife.eightseconds.controller;

import com.metlife.eightseconds.controller.AiChatApplication;
import com.metlife.eightseconds.domain.service.AIChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.metlife.eightseconds.domain.dto.PersonalInfoRequestDto;
import com.metlife.eightseconds.domain.dto.ProductResponseDto;
import com.metlife.eightseconds.domain.enums.ProductType;
import com.metlife.eightseconds.domain.service.ProductService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PersonalInfoController {
	private final ProductService productService;

	@PostMapping("/personalInfo")
	public ResponseEntity<ProductResponseDto> postPersonalInfo(
		@Valid @RequestBody PersonalInfoRequestDto requestDto
	){
		return ResponseEntity.ok(productService.recommendProduct(requestDto));
	}
}