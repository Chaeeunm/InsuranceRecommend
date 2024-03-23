package com.metlife.eightseconds.domain.dto;

import java.util.List;

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
public class ProductResponseDto {

	private Integer productId; //상품아이디
	private String productName; //상품명
	private Integer productPrice; //보혐료
	private String productDate; //보험기간
	private Integer productExp; //보장범위지수
	private Integer minAge; //최소가입연령
	private Integer maxAge; //최대가입연령
	private String productEtc; //비고
	private List<CoveredResponseDto> coverResponseList; //보장리스트


}
