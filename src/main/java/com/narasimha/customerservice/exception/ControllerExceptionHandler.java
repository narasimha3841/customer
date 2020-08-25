package com.narasimha.customerservice.exception;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import com.narasimha.customerservice.model.response.ErrorResponse;


@ControllerAdvice(basePackages = "com.narasimha.customerservice")
public class ControllerExceptionHandler {
	Logger logger;
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ErrorResponse> handleNullRequest(NullPointerException e){
		ErrorResponse error = new ErrorResponse();
		error.setErrorMsg(e.getMessage());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ErrorResponse> handleHttpMessageNotReadable(HttpMessageNotReadableException e){
		ErrorResponse error = new ErrorResponse();
		error.setErrorMsg(e.getMessage());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorResponse> handleBadRequest(IllegalArgumentException e){
		ErrorResponse error = new ErrorResponse();
		error.setErrorMsg(e.getMessage());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorResponse> handleConstraintViolation(Exception ex, WebRequest request) {
		ErrorResponse error = new ErrorResponse();
			error.setErrorMsg(ex.getMessage());
			return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	
	}

	@ExceptionHandler(ServiceDataNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleDataNotFound(ServiceDataNotFoundException e) {
		
		ErrorResponse error = new ErrorResponse();
		error.setErrorMsg(e.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	
	
	@ExceptionHandler(ServiceFailureException.class)
	public ResponseEntity<ErrorResponse> handleServicefailure(ServiceFailureException e) {
		
		ErrorResponse error = new ErrorResponse();
		error.setErrorMsg(e.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
		ErrorResponse error = new ErrorResponse();
		
		List<String> errMsgList = new ArrayList<>();
	    ex.getBindingResult().getAllErrors().forEach(errorObj -> {
		errMsgList.add(errorObj.getDefaultMessage());
	    });
	    
	    error.setErrorMsg(errMsgList.toString());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleExceptionError(Exception e){
		logger.error("ControllerExceptionHandler.handleExceptionError(): Exception occured {}",e);
		ErrorResponse error = new ErrorResponse();
		error.setErrorMsg(e.getMessage());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
