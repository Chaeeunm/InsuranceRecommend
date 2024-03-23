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
		return ResponseEntity.ok(null);
	}
}