package com.hdfc.Food_Delivery_App.exception;

import java.nio.file.AccessDeniedException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleProductNotFoundException(MethodArgumentNotValidException ex) {
        
		Map<String,String>  error=new HashMap<String, String>();
		ex.getBindingResult().getFieldErrors().forEach(er->error.put(er.getField(),er.getDefaultMessage()));
    	return error;
    }
	
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(AccessDeniedException.class)
    public Map<String,String> handleAccessDeniedException(AccessDeniedException ex) {
        
		Map<String,String>  error=new HashMap<String, String>();
		error.put("message", ex.getMessage());
		return error;
    }

	
	@ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(CustomMessage.class)
    public Map<String,String> handleSuccessMessage(CustomMessage ex) {
    	Map<String,String>  error=new HashMap<String, String>();
		error.put("message",ex.getMessage());
    	return error;
    }

}
