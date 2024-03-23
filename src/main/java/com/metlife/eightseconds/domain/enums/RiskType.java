package com.metlife.eightseconds.domain.enums;

public enum RiskType {
	SAFE(1, 2, 3, 4, 7, 8, 10, 12, 13, 20, 24),
	DANGER(5, 6, 9, 11, 14, 15, 16, 17, 18, 19, 21, 22, 23),
	SUPER_DANGER(14, 15);

	private final int[] jobCodes;

	RiskType(int... jobCodes) {
		this.jobCodes = jobCodes;
	}

	public boolean contains(int jobCode) {
		for (int v : jobCodes) {
			if (v == jobCode) {
				return true;
			}
		}
		return false;
	}
	public static RiskType findByCode(int jobCode) {
		for (RiskType riskType : values()) {
			if (riskType.contains(jobCode)) {
				return riskType;
			}
		}
		return null; // 해당하는 RiskType이 없는 경우
	}
}