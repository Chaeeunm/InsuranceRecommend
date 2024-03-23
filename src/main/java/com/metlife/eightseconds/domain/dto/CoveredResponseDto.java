package com.metlife.eightseconds.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CoveredResponseDto {

	private Integer coverId;

	private String coverName;

	private String diseaseName;

	private Integer coverPrice;


}