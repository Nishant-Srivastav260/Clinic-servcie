package com.clinic.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.clinic.exception.CityNotFoundException;
import com.clinic.exception.ClinicAlreadyExitsException;
import com.clinic.exception.ClinicNotFoundException;
import com.clinic.exception.DoctorAlreadyExistException;
import com.clinic.exception.DoctorNotFoundException;
import com.clinic.model.Clinic;
import com.clinic.model.Doctor;
import com.clinic.model.Status;
import com.clinic.model.Week;
import com.clinic.pojo.ClinicRequest;
import com.clinic.pojo.DoctorRequest;
import com.clinic.service.ClinicAvalabilityService;
import com.clinic.service.ClinicService;
import com.clinic.service.ServicesOfferedService;

import lombok.extern.log4j.Log4j2;


@Log4j2
@RestController
public class ClinicController {
	
	@Autowired
	ClinicService clinicser;
	
	@Autowired
	ClinicAvalabilityService clinicAvailSer;
	
	@Autowired
	ServicesOfferedService serviceOffService;

	@Autowired
	RestTemplate restTemplate;
	
	
	@PostMapping(value="/clinic")
	public ResponseEntity<?> post(@RequestBody ClinicRequest clinic)throws ClinicAlreadyExitsException {
		ResponseEntity<?> response = null;
			response = new ResponseEntity<>(clinicser.addClinic(clinic), HttpStatus.OK);
			log.info("Clinic added Successfully");
			return response;

	}
	
	
	@PostMapping("/city/{cityId}/clinics")
	public ResponseEntity<?>post(@PathVariable(value="cityId") long cityId,@RequestBody ClinicRequest clinicReq) throws CityNotFoundException{
		ResponseEntity<?> response = null;
			response=new ResponseEntity<>(clinicser.addClinicToCity(cityId, clinicReq),HttpStatus.OK);
			log.info("Clinics added to City Successfully");
			return response;	
	}
	
	@PutMapping("/clinic")
	public ResponseEntity<?> put(@RequestBody Clinic clinic) throws ClinicNotFoundException{
		ResponseEntity<?> response = null;
			response = new ResponseEntity<>(clinicser.editClinicDetails(clinic), HttpStatus.OK);
			log.info("Clinic edited Successfully");
			return response;
	}
	
	@DeleteMapping("/clinic/{clinicId}")
	public ResponseEntity<?> deleteClinic(@PathVariable(value="clinicId")long clinicId) throws ClinicNotFoundException{
		ResponseEntity<?> response = null;
			response = new ResponseEntity<> (clinicser.deleteClinic(clinicId),HttpStatus.OK);
			log.info("Clinic deleted Successfully");
			return response;
	}
	
	@GetMapping("/clinics")
    public ResponseEntity<?> get() throws ClinicNotFoundException{
        ResponseEntity<?> response = null;
            response = new ResponseEntity<>(clinicser.getViewAllClinic(), HttpStatus.OK);
            log.info("All Clinics are fetched Successfully");
            return response;
    }
	
	
	@PostMapping("/clinics/{clinicId}/{docId}")
	public ResponseEntity<?> post(@PathVariable long clinicId,@PathVariable long docId) throws DoctorAlreadyExistException, ClinicAlreadyExitsException, DoctorNotFoundException{ 
		DoctorRequest doctor=restTemplate.getForObject("http://doctor-service/doctor/doctors/"+docId, DoctorRequest.class);
		ResponseEntity<?> response = new ResponseEntity<>(clinicser.addDoctorsToClinic(doctor, clinicId),HttpStatus.OK);
		log.info("Doctors added to Clinics Successfully");
		return response;
	}
	
	
	@PostMapping("/clinic/{clinicId}/{week}/{status}")
	public ResponseEntity<?> post(@PathVariable long clinicId,@PathVariable Week week,@PathVariable Status status){
		ResponseEntity<?> response=new ResponseEntity<>(clinicAvailSer.setClinicAvailability(clinicId, week, status),HttpStatus.OK);	
		return response;	
	}
	
	@GetMapping("/clinic/{clinicId}/services")
	 public ResponseEntity<?> get(@PathVariable(value="clinicId") long clinicId) throws ClinicNotFoundException{
		ResponseEntity<?> response=null;
			response = new ResponseEntity<>(serviceOffService.viewServiceForClinic(clinicId),HttpStatus.OK); 
			log.info("Services added successfully");
		return response;
	 }
	
	@GetMapping("/clinic/{clinicId}")
    public ResponseEntity<?> getClinicById(@PathVariable(value = "clinicId")long clinicId) throws ClinicNotFoundException{
        ResponseEntity<?> response = new ResponseEntity<>(clinicser.getClinicById(clinicId),HttpStatus.OK);
        log.info("Clinics are fetched Successfully");
        return response;
    }
	
	
	@GetMapping("/clinic/{week}")
	public ResponseEntity<?> getClinicByAvailabilty(@RequestParam(value="week") Week week){
		ResponseEntity<?> response=new ResponseEntity<>(clinicAvailSer.getClinicAvailability(week),HttpStatus.OK);
		log.info("Opened Cinics are fetched Successfully");
		return response;
	}
}
	
