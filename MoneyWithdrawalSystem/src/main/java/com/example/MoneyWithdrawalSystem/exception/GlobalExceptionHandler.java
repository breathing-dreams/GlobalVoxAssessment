package com.example.MoneyWithdrawalSystem.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class.getName());
	
	
	@ExceptionHandler(MWLExceededException.class)
	public final ResponseEntity<ErrorResponse> handleMWLExceededException(MWLExceededException ex,
            WebRequest request) {
		//global exception handler
		List<String> details = new ArrayList<>();
		details.add(ex.getLocalizedMessage());
		ErrorResponse error = new ErrorResponse("MWL Exceeded", details);
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	
	
}
