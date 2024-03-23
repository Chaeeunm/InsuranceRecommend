package com.metlife.eightseconds.domain.enums;

public enum PaymentType {
	ALL("일시지급"),
	ANNUAL("연금지급");

	private final String value;

	private PaymentType(String value) {
		this.value = value;
	}
}
