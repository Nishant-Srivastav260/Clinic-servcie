package com.pratian.appointmentservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pratian.appointmentservice.entities.NewAppointment;
import com.pratian.appointmentservice.exceptions.AppointmentNotFoundException;
import com.pratian.appointmentservice.service.NewIAppointmentService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
// @CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", exposedHeaders = "If_Match")
@CrossOrigin(origins = "http://localhost:4200")

public class NewAppointmentController {
	private static Logger logger=LoggerFactory.getLogger(NewAppointmentController.class);
	@Autowired private  NewIAppointmentService appointmentService;
	
	/*
	 * Method to handle API request for Adding Patient
	 * @param Appointmentid
	 * @param patientid
	 */
	
	
	/*@PostMapping("/appointment")
	@Operation(summary = "To add appointment for patient")
	public Appointment AddAppointment(@Valid @RequestBody Appointment appointment) throws AppointmentNotFoundException
	{
		return appointmentService.AddAppointment(appointment);
		
	}
	@Operation(summary = "To Add MobilePhone")
	public ResponseEntity<?> post(@RequestBody Appointment appointment) {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<Appointment>(appointmentService.AddAppointment(appointment), HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.OK);
		}
		return response;
	}
*/	
	@GetMapping("/get/{id}")
	@Operation(summary = "To find Appointment by using id")
	public NewAppointment getById(@PathVariable (value = "id") long id) {
		return appointmentService.getAppointmentById(id);
	}


	@PostMapping("/appointment")
	@Operation(summary = "To add appointment for patient")
	public NewAppointment AddAppointment(@Valid @RequestBody NewAppointment appointment) throws AppointmentNotFoundException
	{
	
		return appointmentService.AddAppointment(appointment);
		
	}
/*	@GetMapping("/get/{id}")
	@Operation(summary = "To find Appointment by using id")
	public Appointment getById(@PathVariable (value = "id") long id) {
		return appointmentService.getAppointmentById(id);
	} */
	
	@GetMapping("/get/")
	@Operation(summary = "To find  all appointment")
	public List<NewAppointment>  getAll() { 
		List<NewAppointment> result = appointmentService.getAppointmentAll();
		 
	
		return result;
	}
	
}
