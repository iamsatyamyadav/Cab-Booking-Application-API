package com.CabWalla.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(TripBookingException.class)
	public ResponseEntity<ErrorDetails> loginExceptionHandler(TripBookingException e, WebRequest re){
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), e.getMessage(), re.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(LoginException.class)
	public ResponseEntity<ErrorDetails> loginExceptionHandler(LoginException e, WebRequest re){
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), e.getMessage(), re.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(AdminException.class)
	public ResponseEntity<ErrorDetails> adminException(AdminException e, WebRequest re){
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), e.getMessage(), re.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	


	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<ErrorDetails> customerExceptionHandler(CustomerException ce, WebRequest re){
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), ce.getMessage(), re.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> allExceptionHandler(Exception e, WebRequest re){
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), e.getMessage(), re.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> noHandlerExceptionHandler(NoHandlerFoundException e, WebRequest re){
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), e.getMessage(), re.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorDetails> illegealArgumentExceptionHandler(IllegalArgumentException e, WebRequest re){
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), e.getMessage(), re.getDescription(false));
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> invalidArgumentExceptionHandler(MethodArgumentNotValidException e){
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), e.getMessage(), e.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}
}