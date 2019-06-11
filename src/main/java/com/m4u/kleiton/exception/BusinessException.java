package com.m4u.kleiton.exception;

public class BusinessException extends RuntimeException {
	/**
	 * SERIAL VERSION
	 */
	private static final long serialVersionUID = -3242924660188762182L;
	private Long errorCode;
	private String errorMessage;

	public BusinessException(Long errorCode,String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public BusinessException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Long getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Long errorCode) {
		this.errorCode = errorCode;
	}

	
}
