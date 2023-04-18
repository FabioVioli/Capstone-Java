package com.Capstone.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import jakarta.persistence.EntityNotFoundException;

@ControllerAdvice
public class CapstoneExceptions extends ResponseEntityExceptionHandler {
	@ExceptionHandler(EntityNotFoundException.class)
	protected ResponseEntity<String> manageEntityNotFound(EntityNotFoundException errore){
		return new ResponseEntity<String>(errore.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(RuntimeException.class)
	protected ResponseEntity<String> manageRuntimeException(RuntimeException errore){
		return new ResponseEntity<String>(errore.getMessage(), HttpStatus.NOT_FOUND);
	}
}
