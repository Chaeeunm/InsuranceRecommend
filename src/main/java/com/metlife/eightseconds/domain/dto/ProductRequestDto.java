package com.metlife.eightseconds.domain.dto;

import java.util.List;

import com.metlife.eightseconds.domain.data.AIJsonResponse;
import com.metlife.eightseconds.domain.enums.PaymentType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDto {

	private Integer guaranteePeriod;
	private Integer productPrice;
	private Integer paymentPeriod;
	private Boolean renewYn;    // 갱신여부
	private PaymentType paymentType;
	private List<String> coverDisease;

	@Builder
	public ProductRequestDto(AIJsonResponse response){
		this.productPrice = response.getProductPrice();
		this.guaranteePeriod = response.getGuaranteePeriod();
		this.paymentPeriod = response.getPaymentPeriod();
		this.renewYn = (response.getRenewYn().equals("1") ? false : true);
		this.paymentType = (response.getPaymentType().equals("1") ? PaymentType.ALL : PaymentType.ANNUAL);
		this.coverDisease = response.getCoverDisease();
	}

}
