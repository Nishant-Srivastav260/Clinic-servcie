package com.patientservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.patientservice.dto.PatientDTO;
import com.patientservice.entities.Patient;
import com.patientservice.service.PatientService;

import io.swagger.v3.oas.annotations.Operation;

@CrossOrigin(origins = "*")
@RestController
//@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping(value="/patients/{id}") //  for getting all patients we use GET API
    @Operation(summary = "To get patient with Id")
    public ResponseEntity<Patient> get(@PathVariable(value="id")long id) {
        ResponseEntity<Patient> response  = null;
        response = new ResponseEntity<Patient>(patientService.getPatientById(id),HttpStatus.OK);
        return  response;
    }

    @GetMapping(value = "/patients")
    public ResponseEntity<List<Patient>> get() {
        ResponseEntity<List<Patient>> responseEntity = null;
        responseEntity = new ResponseEntity<List<Patient>>(patientService.getPatients(), HttpStatus.OK);
        return responseEntity;
    }


    @PostMapping("/patients") 
    @Operation(summary = "To add patient Details")
    public ResponseEntity<?> post(@RequestBody Patient patient){

        ResponseEntity<?> response = null;
        response = new ResponseEntity<Patient>(patientService.savePatient(patient), HttpStatus.OK);
        return response;
    }
    @GetMapping("patients/{id}/profile")
    public ResponseEntity<?> getPatientProfile(@PathVariable long id)
    {
        ResponseEntity<?> response = new ResponseEntity<>(patientService.viewPatientProfileInfo(id),HttpStatus.OK);
        return response;
    } 

    @PutMapping("patients/{id}/{patient}")
    public ResponseEntity<?> editPatientProfile(@PathVariable long id,@RequestBody PatientDTO patient)
    {
        ResponseEntity<?> response = new ResponseEntity<>(patientService.editPatientProfileInfo(id, patient),HttpStatus.OK);
        return response;
    } 

    @PatchMapping("patients/{id},{image}")
    public ResponseEntity<?> updateProfileImage (@PathVariable long id,@PathVariable String image)
    {
        ResponseEntity<?> response = new ResponseEntity<>(patientService.addPatientProfilePicture(id, image),HttpStatus.OK);
        return response;
    }

    @DeleteMapping("patients/{id}/image")
    public ResponseEntity<?> deleteProfileImage(@PathVariable long id)
    {
        ResponseEntity<?> response = new ResponseEntity<>(patientService.deletePatientProfilePicture(id),HttpStatus.OK);
        return response;
    }
}
