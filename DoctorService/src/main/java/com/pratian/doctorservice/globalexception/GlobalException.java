package com.pratian.doctorservice.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pratian.doctorservice.exception.DoctorNotFoundException;

@ControllerAdvice
public class GlobalException
{
	@ExceptionHandler(DoctorNotFoundException.class)
	private ResponseEntity<?> handleDoctorNotFoundException(DoctorNotFoundException doctorNotFoundException)
	{
		
		return new ResponseEntity<>("Please Enter Valid Doctor Id", HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	private ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException httpMessageNotReadableException){
		return new ResponseEntity<>("Enter Valid Data",HttpStatus.BAD_GATEWAY);
	}
}
