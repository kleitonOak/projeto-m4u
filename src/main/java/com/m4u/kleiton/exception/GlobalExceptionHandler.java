package com.m4u.kleiton.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {
	//https://spring.io/blog/2013/11/01/exception-handling-in-spring-mvc
	@ExceptionHandler(value = EnvironmentException.class)
	public ResponseEntity<ErrorResponse> handleEnvironmentException(EnvironmentException e) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorResponse> handleException(Exception e) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = Error.class)
	public ResponseEntity<ErrorResponse> handleErrorException(Error e) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = BusinessException.class)
	public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException e) {
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.OK.value(), e.getMessage());
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.OK);
	}

	@ExceptionHandler(value = RestFulException.class)
	public ResponseEntity<RestFulException> handleRestFulException(RestFulException e) {

		return new ResponseEntity<RestFulException>(e, HttpStatus.valueOf(e.getErrorCode()));
	}

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<List<ErrorResponse>> processValidationError(MethodArgumentNotValidException ex) {

		BindingResult result = ex.getBindingResult();
		List<FieldError> fieldErrors = result.getFieldErrors();
		List<ErrorResponse> listaErro = new ArrayList<>();
		int codigoErro = 1;
		for (FieldError fieldError : fieldErrors) {
			StringBuilder msg = new StringBuilder("Field: '").append(fieldError.getField()).append("'");
			msg.append(" Error: '").append(fieldError.getDefaultMessage()).append("'");
			
			ErrorResponse errorResponse = new ErrorResponse(codigoErro, msg.toString());
			listaErro.add(errorResponse);
			codigoErro++;
		}

		return new ResponseEntity<List<ErrorResponse>>(listaErro, HttpStatus.PRECONDITION_FAILED);
	}
}
