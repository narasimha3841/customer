package com.narasimha.customerservice.exception;

public class ServiceFailureException extends Exception{
private static final long serialVersionUID = 1L;
	
	private final String message;

	public ServiceFailureException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
