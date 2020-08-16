package com.narasimha.customerservice.exception;

public class ServiceDataNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private String code;
	private String message;

	public ServiceDataNotFoundException(String code, String message) {

		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
