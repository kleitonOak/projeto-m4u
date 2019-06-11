package com.m4u.kleiton.exception;

import java.io.Serializable;

public class ErrorResponse implements Serializable{

	/**
	 * SERIAL VERSION
	 */
	private static final long serialVersionUID = -7574129091459156187L;
	private int errorCode;
	private String message;
	
	public ErrorResponse() {
		super();
	}
	
	
	public ErrorResponse(int errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}


	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
