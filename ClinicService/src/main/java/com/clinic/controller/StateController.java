package com.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clinic.exception.StateAlreadyExistException;
import com.clinic.model.State;
import com.clinic.service.StateService;

import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;


@Log4j2
@RestController
public class StateController {

	@Autowired
	StateService stateSer;
	
	@PostMapping("/state")
	public ResponseEntity<?> post(@RequestBody State state) throws StateAlreadyExistException{
		ResponseEntity<?> response=new ResponseEntity<>(stateSer.addState(state),HttpStatus.OK);
		log.info("Stated added Successfully");
		return response;
	}
	
}
