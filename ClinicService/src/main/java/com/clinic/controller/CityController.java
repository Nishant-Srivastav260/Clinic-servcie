package com.clinic.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.clinic.exception.StateNotFoundException;
import com.clinic.model.City;
import com.clinic.service.CityService;


import lombok.extern.log4j.Log4j2;



@Log4j2
@RestController
public class CityController {

	
	@Autowired
	CityService citySer;
	
	
	@PostMapping("/state/{name}/city")
	public ResponseEntity<?>post (@RequestBody  City city , @PathVariable String name) throws StateNotFoundException{
		ResponseEntity<?>response=new ResponseEntity<>(citySer.addCitytoState(name, city),HttpStatus.OK);
		log.info("Added City into State successfully");
		return response;
	} 
}
