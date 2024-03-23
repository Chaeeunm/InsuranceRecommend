package com.metlife.eightseconds.domain.enums;

public enum Disease {
	BRAIN("뇌혈관질환"),
	HEART("혈관질환"),
	CANCER("암"),
	BORNFIRE("골절/화상"),
	TEETH("치아"),
	DEMENTIA("치매"),
	NONE("없음");
	private final String value;

	private Disease(String value) {
		this.value = value;
	}
}
