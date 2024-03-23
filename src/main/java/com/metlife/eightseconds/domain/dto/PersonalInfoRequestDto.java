package com.metlife.eightseconds.domain.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.metlife.eightseconds.domain.enums.Disease;
import com.metlife.eightseconds.domain.enums.Gender;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//DAO -> interface

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalInfoRequestDto {
	private Gender gender; //성별
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate birth;
	@NotNull
	@Size(min = 1, max = 3)
	private List<Disease> DiseaseList;
	private String analyze;
}