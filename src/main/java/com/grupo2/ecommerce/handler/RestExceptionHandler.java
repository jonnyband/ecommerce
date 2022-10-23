package com.grupo2.ecommerce.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.grupo2.ecommerce.exception.ResourceBadRequestException;
import com.grupo2.ecommerce.exception.ResourceNotFoundException;
import com.grupo2.ecommerce.exception.ResourceUniqueValueException;
import com.grupo2.ecommerce.model.error.ErrorMessage;
import com.grupo2.ecommerce.utils.ConversorDeData;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorMessage> handlerResourceNotFoundException(ResourceNotFoundException ex){
		
		String dateTime = ConversorDeData.converterDateParaDataEHora(new Date());
		

		ErrorMessage error =  new ErrorMessage(dateTime, 404, "Not Found", ex.getMessage());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ResourceBadRequestException.class)
	public ResponseEntity<ErrorMessage> handlerBadRequestException(ResourceBadRequestException ex){
		
		String dateTime  = ConversorDeData.converterDateParaDataEHora(new Date());
		ErrorMessage error =  new ErrorMessage(dateTime, 400, "Bad Request", ex.getMessage());
				
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ResourceUniqueValueException.class)
	public ResponseEntity<ErrorMessage> handlerResourceUniqueValueException(ResourceUniqueValueException ex){
		
		String dateTime  = ConversorDeData.converterDateParaDataEHora(new Date());
		ErrorMessage error =  new ErrorMessage(dateTime, 400, "Bad Request", ex.getMessage());
				
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> handlerBadRequestException(Exception ex){
		String dateTime  = ConversorDeData.converterDateParaDataEHora(new Date());
		ErrorMessage error =  new ErrorMessage(dateTime, 500, "Internal Server Error", ex.getMessage());
				
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
