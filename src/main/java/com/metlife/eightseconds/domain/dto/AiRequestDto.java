package com.metlife.eightseconds.domain.dto;

import com.metlife.eightseconds.domain.enums.PaymentType;
import com.metlife.eightseconds.domain.enums.RiskType;

import java.util.List;

public class AiRequestDto {
    private Integer guaranteePeriod;
    private Integer productPrice;
    private Integer paymentPeriod;
    private Boolean renewYn;    // 갱신여부
    private PaymentType paymentType;
    private List<String> coverDisease;
}
