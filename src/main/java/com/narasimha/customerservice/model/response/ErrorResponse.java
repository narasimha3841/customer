package com.narasimha.customerservice.model.response;

public class ErrorResponse {

	
	private String errorMsg;

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public String toString() {
		return "ErrorResponse [errorMsg=" + errorMsg + "]";
	}



}
