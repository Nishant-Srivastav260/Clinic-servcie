package com.pratian.appointmentservice.controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pratian.appointmentservice.entities.Appointment;
import com.pratian.appointmentservice.entities.Comment;
import com.pratian.appointmentservice.entities.Vitals;
import com.pratian.appointmentservice.exceptions.AppointmentAlreadyExistsException;
import com.pratian.appointmentservice.exceptions.AppointmentNotFoundException;
import com.pratian.appointmentservice.exceptions.VitalsNotFoundException;
import com.pratian.appointmentservice.service.CommentService;
import com.pratian.appointmentservice.service.IAppointmentService;
import com.pratian.appointmentservice.service.TestService;

import io.swagger.v3.oas.annotations.Operation;

@CrossOrigin(origins = "*")
@RestController
//@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", exposedHeaders = "If_Match")

public class AppointmentController {
	@Autowired
	public IAppointmentService asl;

	@Autowired
	public TestService tst;

	@Autowired
	public IAppointmentService service;

	@Autowired
	CommentService commentservice;
	
	
	@GetMapping("/appointments")
	@Operation(summary = "To display all Appointments")
	public ResponseEntity<?> getAllAppointments() throws AppointmentNotFoundException {
		ResponseEntity<?> response = null;
		
			response = new ResponseEntity<>(service.getAllAppointments(), HttpStatus.OK);
		
		return response;
	}

	@PostMapping("/appointments") 
	@Operation(summary = "To add a new appointment")
	public ResponseEntity<?> addAppointment(@RequestBody Appointment appointment) {
		ResponseEntity<?> response = null;
	
			response = new ResponseEntity<Appointment>(asl.addAppointment(appointment), HttpStatus.OK);
		
		return response;
	}

	@GetMapping("/appointments/{id}") 
	@Operation(summary = "To get appointment using id")
	public ResponseEntity<?> getAppointmentById(@PathVariable(value = "id") long id) throws AppointmentNotFoundException {
		ResponseEntity<?> response = null;
		
			response = new ResponseEntity<>(service.getAppointmentById(id), HttpStatus.OK);
		
		return response;
	}

	@PostMapping("appointment/{id}/comment") 
	public ResponseEntity<?> postComment(@PathVariable(value = "id") long id , @RequestBody Comment comment) throws AppointmentNotFoundException {
		ResponseEntity<?> response = null;
		response = new ResponseEntity<>(commentservice.addComment(comment, id), HttpStatus.OK);
		return response;
	}

	@GetMapping("/appointments/{id}/comments") // Working 
	public ResponseEntity<?> getCommentById(@PathVariable(value = "id") long id) {
		ResponseEntity<?> response = null;
		response = new ResponseEntity<>(commentservice.getComment(id), HttpStatus.OK);
		return response;
	}

	@PutMapping("/appointment/{id}/comments") 
	public ResponseEntity<?> putCommentById(@PathVariable(value = "app_id") long appId, @RequestBody String comment)
			throws AppointmentNotFoundException { 
		ResponseEntity<?> response = null;

		response = new ResponseEntity<>(commentservice.editComment(comment, appId), HttpStatus.OK);
		return response;
	}

	@GetMapping("/appointments/{id}/tests") 
	public ResponseEntity<?> getTestsforAppointment(@PathVariable(value = "id") long id) throws AppointmentNotFoundException {
		ResponseEntity<?> response = null;
		
			response = new ResponseEntity<>(asl.getTestsForAppointment(id), HttpStatus.OK);
		
		return response;

	}

	@DeleteMapping("/appointments/{appointment_id}/tests/{test_id}")
	public ResponseEntity<?> deleteTestsfoAppointment(@PathVariable(value = "appointment_id") long id,
			@PathVariable(value = "test_id") long test_id) {
		ResponseEntity<?> response = null;
		try {
			asl.deleteTestsfoAppointment(id, test_id);
			response = new ResponseEntity<Appointment>(HttpStatus.OK);
		} catch (AppointmentNotFoundException e) {
			response = new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		return response;

	}

	@GetMapping("/appointments/accept") 
	@Operation(summary = "To get accepted appointments ")
	public ResponseEntity<?> getfilterconfirmedAppointments() {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.getfilterconfirmedAppointments(), HttpStatus.OK);

			return response;
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/appointments/cancel") 
	@Operation(summary = "To get cancelled appointments")
	public ResponseEntity<?> getfiltercallcelledAppointments() {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.getfiltercancelledAppointments(), HttpStatus.OK);

			return response;
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/appointments/close") 
	@Operation(summary = "To get closed appointments")
	public ResponseEntity<?> getfilterclosedAppointments() {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.getfilterclosedAppointments(), HttpStatus.OK);

			return response;
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("/appointments/total") 
	public int getTotalAppointments() {
		int count = asl.gettotalAppointments();
		return count;
	}

	
	@GetMapping("/appointment/cancelled/total")
	public int getCancelledAppointments() {
		int count = asl.getCancelledAppointments();
		return count;
	}

	@GetMapping("/appointments/{id}/vitals") 
	public ResponseEntity<?> getvitals(@PathVariable(value = "id") long id) throws AppointmentNotFoundException {
		ResponseEntity<?> response = null;
		response = new ResponseEntity<>(asl.getVitalsbyAppoinmentId(id), HttpStatus.OK);
		return response;

	}

	/// Put This In Vitals
	// edit or save vitals by appointment id
	@PutMapping("/appointments/{id}/vitals/")
	public ResponseEntity<?> editvital(@PathVariable(value = "id") Long id, @RequestBody Vitals vital)
			throws VitalsNotFoundException, AppointmentNotFoundException {
		ResponseEntity<?> response = null;
		response = new ResponseEntity<>(asl.editVitals(vital, id), HttpStatus.OK);
		return response;
	}

	////////////////////////////////////////////////////////////////////// Pending

	@GetMapping("/appointments/pending")
	@Operation(summary = "To get pending appointments")
	public ResponseEntity<?> getpendingAppointments() {
		ResponseEntity<?> response = null;
		try {
			response = new ResponseEntity<>(service.getpendingAppointments(), HttpStatus.OK);

			return response;
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@DeleteMapping("/appointments/{id}")
	@Operation(summary = "To delete a appointment using id")
	public ResponseEntity<?> deleteAppointment(@PathVariable(value = "id") long id) {
		try {

			asl.deleteAppointment(id);

			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@PutMapping(value = "appointment/{id},{status}")
	public ResponseEntity<?> updateAppointment(@PathVariable(value = "id") long id,
			@PathVariable(value = "status") String status) {
		ResponseEntity<?> response = null;
		System.out.println(status);
		response = new ResponseEntity<Appointment>(service.updateAppointmnet(id, status), HttpStatus.OK);

		return response;
	}


}
