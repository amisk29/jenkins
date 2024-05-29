package com.reactjava.exception;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(UserNotFound.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public ResponseEntity<Map<String,String>> exceptionHandler(UserNotFound userNotFound)
{
		Map<String,String>error= new LinkedHashMap<>();
		String message = userNotFound.getMessage();
		String localizedMessage = userNotFound.getLocalizedMessage();
		error.put(message, localizedMessage);
		
		return new ResponseEntity<Map<String ,String>>(error,HttpStatus.BAD_REQUEST);
	
}
}
