package com.metlife.eightseconds.domain.data;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

@Getter
public class AIResponse {
	@SerializedName("00")
	private String job;
	//보장기간
	@SerializedName("01")
	private Integer guaranteePeriod;
	//보험금
	@SerializedName("02")
	private Integer productPrice;
	//납입기간
	@SerializedName("03")
	private Integer paymentPeriod;
	//보험료 1,2
	@SerializedName("04")
	private Integer renewYn; //1 비갱신형 , 2 갱신형
	//보험금 지급형태
	@SerializedName("05")
	private Integer paymentType; //1일시지급 2연금지급
	//보장질병
	@SerializedName("06")
	private List<String> coverDisease; //“암,심장,갑상선”
}
