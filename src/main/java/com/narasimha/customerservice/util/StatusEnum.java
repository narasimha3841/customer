package com.narasimha.customerservice.util;

public enum StatusEnum {
	
	IN_PROGRESS("IN_PROGRESS"),
	FINISHED("FINISHED");

	private final String status;

	private StatusEnum(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}
