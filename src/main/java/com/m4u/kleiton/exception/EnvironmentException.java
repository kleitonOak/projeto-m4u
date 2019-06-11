package com.m4u.kleiton.exception;

public class EnvironmentException extends RuntimeException {
	/**
	 * SERIAL VERSION
	 */
	private static final long serialVersionUID = -3242924660188762182L;
	private Integer errorCode;
	private String errorMessage;


	public EnvironmentException(Integer errorCode,String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public EnvironmentException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

}
