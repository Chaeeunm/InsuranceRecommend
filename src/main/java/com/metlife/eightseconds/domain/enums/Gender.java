package com.metlife.eightseconds.domain.enums;

public enum Gender {
	MALE("남성"),
	FEMALE("여성");

	private final String value;

	private Gender(String value){
		this.value = value;
	}
}
