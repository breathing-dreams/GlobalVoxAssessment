package com.example.MoneyWithdrawalSystem.exception;

import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="MWL exceeded")
public class MWLExceededException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MWLExceededException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public MWLExceededException(String arg0) {
		super(arg0);
	}

	public MWLExceededException(Throwable arg0) {
		super(arg0);
	}

}
