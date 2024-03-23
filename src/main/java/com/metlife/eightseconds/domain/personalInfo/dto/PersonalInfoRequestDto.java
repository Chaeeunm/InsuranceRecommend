package com.metlife.eightseconds.domain.personalInfo.dto;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.metlife.eightseconds.domain.personalInfo.enums.Disease;
import com.metlife.eightseconds.domain.personalInfo.enums.Gender;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonalInfoRequestDto {
	private Gender gender;
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate birth;

	@NotNull
	@Size(min = 1, max = 3)
	private List<Disease> DiseaseList;

	private String analyze;
}
