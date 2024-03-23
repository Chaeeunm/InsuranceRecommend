package com.metlife.eightseconds.domain.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.metlife.eightseconds.domain.dto.PersonalInfoRequestDto;
import com.metlife.eightseconds.domain.dto.ProductResponseDto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class PersonalInfoController {

	@PostMapping("/personalInfo")
	public ResponseEntity<ProductResponseDto> postPersonalInfo(
		@Valid @RequestBody PersonalInfoRequestDto requestDto
	){
		return ResponseEntity.ok(null);
	}
}
