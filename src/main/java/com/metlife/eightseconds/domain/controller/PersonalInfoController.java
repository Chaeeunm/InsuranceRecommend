package com.metlife.eightseconds.domain.controller;

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
@RequiredArgsConstructor
public class PersonalInfoController {

	@PostMapping("/personalInfo")
	public ResponseEntity<ProductResponseDto> postPersonalInfo(
		@Valid @RequestBody PersonalInfoRequestDto requestDto,
		@RequestParam(required = true) ProductType productType
	){
		return ResponseEntity.ok(null);
	}
}
