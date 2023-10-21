package com.patientservice.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.patientservice.exception.FeedbackNotFoundException;
import com.patientservice.exception.PatientAlreadyExistsException;
import com.patientservice.exception.PatientNotFoundException;
import com.patientservice.exception.SymptomAlreadyPresentException;
import com.patientservice.exception.SymptomListIsEmptyException;
import com.patientservice.exception.SymptomNotFoundException;

@ControllerAdvice
@ResponseStatus
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{

	@ExceptionHandler(SymptomListIsEmptyException.class)
	public ResponseEntity<ErrorMessage> symptomListIsEmptyExceptionHandler(Exception ex,WebRequest web){

		ErrorMessage error=new ErrorMessage(HttpStatus.NO_CONTENT, ex.getMessage());
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(error);
	}
	
	@ExceptionHandler(SymptomNotFoundException.class)
	public ResponseEntity<ErrorMessage> symptomNotFoundExceptionHandler(Exception ex,WebRequest web){
		ErrorMessage error=new ErrorMessage(HttpStatus.NOT_FOUND,ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	@ExceptionHandler(SymptomAlreadyPresentException.class)
	public ResponseEntity<ErrorMessage> symptomAlreadyPresentException(Exception ex,WebRequest web){
		ErrorMessage error=new ErrorMessage(HttpStatus.ALREADY_REPORTED, ex.getMessage());
		return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(error);
	}
	
	//Patient
	
	@ExceptionHandler(PatientAlreadyExistsException.class)
	public ResponseEntity<ErrorMessage> patientAlreadyExistsException(Exception ex,WebRequest web){
		ErrorMessage error=new ErrorMessage(HttpStatus.ALREADY_REPORTED, ex.getMessage());
		return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).body(error);
	}
	
	@ExceptionHandler(PatientNotFoundException.class)
	public ResponseEntity<ErrorMessage> patientNotFoundExceptionHandler(Exception ex,WebRequest web){
		ErrorMessage error=new ErrorMessage(HttpStatus.NOT_FOUND,ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	//Feedback
	@ExceptionHandler(FeedbackNotFoundException.class)
	public ResponseEntity<ErrorMessage> feedbackNotFoundExceptionHandler(Exception ex,WebRequest web){
		ErrorMessage error=new ErrorMessage(HttpStatus.NOT_FOUND,ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
