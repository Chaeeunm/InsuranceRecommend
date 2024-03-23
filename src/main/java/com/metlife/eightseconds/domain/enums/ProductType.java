package com.metlife.eightseconds.domain.enums;

public enum ProductType {
	LIFE("종신보험"),
	DISEASE("질병보험");

	private final String value;

	private ProductType(String value) {
		this.value = value;
	}
}
