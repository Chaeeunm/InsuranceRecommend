package com.metlife.eightseconds.domain.dao;

import com.metlife.eightseconds.domain.enums.PaymentType;
import com.metlife.eightseconds.domain.enums.RiskType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.metlife.eightseconds.domain.dto.ProductResponseDto;

import java.util.List;

@Mapper
public interface ProductDao {
   public String findByPersonalInfo(Integer productId);


	// 보장기간
	public String getGuaranteePeriod();

	// 보험료
	public Integer getProductPrice();

	public Boolean getRenewYn();

	// 지급코드
	public String getPaymentType();

	public List<String> getCoverDisease();

}
