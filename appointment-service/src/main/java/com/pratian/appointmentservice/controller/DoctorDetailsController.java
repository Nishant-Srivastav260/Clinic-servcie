package com.pratian.appointmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pratian.appointmentservice.entities.DoctorDetails;
import com.pratian.appointmentservice.service.DoctorDetailsService;



@RestController
// @CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", exposedHeaders = "If_Match")
@RequestMapping(value="/appointment")

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class DoctorDetailsController {
	@Autowired
	DoctorDetailsService doctordetailsservice;
	
	
	//@RequestMapping(value="/getdoctor/{id}",method =RequestMethod.GET)
	@GetMapping("/doctor/{id}")
	public DoctorDetails getById(@PathVariable(value="id")long id)
	{
		return doctordetailsservice.getDoctorDetails(id);
	}

}
