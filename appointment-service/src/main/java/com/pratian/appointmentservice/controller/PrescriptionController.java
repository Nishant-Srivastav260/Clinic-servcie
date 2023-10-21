package com.pratian.appointmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pratian.appointmentservice.entities.PrescriptionHistoryList;
import com.pratian.appointmentservice.entities.Prescriptions;
import com.pratian.appointmentservice.exceptions.AppointmentNotFoundException;
import com.pratian.appointmentservice.exceptions.PrescriptionServiceException;
import com.pratian.appointmentservice.service.IPrescriptionService;


@RestController
// @CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true", allowedHeaders = "*", exposedHeaders = "If_Match")
@CrossOrigin(origins = "*")

//@RequestMapping("/prescriptions")
public class PrescriptionController {
	@Autowired
	private IPrescriptionService prescriptionServiceIml;	
	
	
	@PutMapping("/prescriptions/{id}")
	public ResponseEntity<?> editPrescriptionById(@PathVariable(value = "id") long id, @RequestBody Prescriptions pre)throws PrescriptionServiceException {
		
		ResponseEntity<?> responseEntity = null;

	
			responseEntity = new ResponseEntity<>(prescriptionServiceIml.editPrescription(id, pre), HttpStatus.OK);

		return  responseEntity;
		
	}	

	@DeleteMapping("/prescription/{id}")
	public ResponseEntity<?> deleteMedicine(@PathVariable(value = "id") long id)  throws PrescriptionServiceException{
		ResponseEntity<?> responseEntity = null;

	
			prescriptionServiceIml.deletePrescription(id);

		return responseEntity;
	}
	
	
	
	@GetMapping("/prescriptions/{id}")
	public ResponseEntity<?> getOnePrescriprion(@PathVariable(value = "id") long id) throws PrescriptionServiceException
			 {
		
		ResponseEntity<?> responseEntity = null;
			responseEntity = new ResponseEntity<>(prescriptionServiceIml.getOnePrescriprion(id), HttpStatus.OK);

		return  responseEntity;	
		
	}
	
	
	@PostMapping("/appointments/{id}/prescriptions")
	public ResponseEntity<?> addNewPrescription(@PathVariable(value = "id") long id , @RequestBody Prescriptions pre) throws AppointmentNotFoundException{ 
			
		ResponseEntity<?> responseEntity = null;

	
			responseEntity = new ResponseEntity<>(prescriptionServiceIml.addPrescription(pre,id), HttpStatus.OK);
			
		
		return  responseEntity;
	}
	
	
//	
//	@GetMapping("/appointments/{id}/prescriptions")    //Correct  Method Commented for testing something
//	public ResponseEntity<?> viewAllPrescriptions(@PathVariable(value = "id") long id) throws PrescriptionServiceException, AppointmentNotFoundException  {
//
//		ResponseEntity<?> responseEntity = null;
//	
//			responseEntity = new ResponseEntity<>(prescriptionServiceIml.viewPrescriptionbyAppointmentId(id), HttpStatus.OK);
//		
//		return  responseEntity;
//	}
	
	@GetMapping("/appointments/{id}/prescriptions")
	public ResponseEntity<?> viewAllPrescriptions(@PathVariable(value = "id") long id) throws PrescriptionServiceException, AppointmentNotFoundException  {

		ResponseEntity<?> responseEntity = null;
		PrescriptionHistoryList  prescriptionHistory=new PrescriptionHistoryList();
		prescriptionHistory.setPrescriptionList(prescriptionServiceIml.viewPrescriptionbyAppointmentId(id));
	
			responseEntity = new ResponseEntity<>(prescriptionHistory, HttpStatus.OK);
		
		return  responseEntity;
	}
	
	

}
