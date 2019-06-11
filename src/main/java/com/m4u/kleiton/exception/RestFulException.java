package com.m4u.kleiton.exception;

import java.util.Map;

public class RestFulException extends RuntimeException {
	/**
	 * SERIAL VERSION
	 */
	private static final long serialVersionUID = -3242924660188762182L;
	private Map<String, Object> properties;
	private Integer errorCode;
	private String errorMessage;
	public RestFulException() {
		
	}

	public RestFulException(Integer errorCode,String errorMessage) {
		super(errorMessage);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public RestFulException(String errorMessage) {
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

	public Map<String, Object> getProperties() {
		return properties;
	}

	public void setProperties(Map<String, Object> properties) {
		this.properties = properties;
	}

	
}
