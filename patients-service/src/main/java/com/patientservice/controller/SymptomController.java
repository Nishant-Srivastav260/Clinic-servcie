package com.patientservice.controller;

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

import com.patientservice.entities.Symptom;
import com.patientservice.service.SymptomService;

import io.swagger.v3.oas.annotations.Operation;
@CrossOrigin(origins = "*")
@RestController
//@RequestMapping(value = "/patient/symptom")
public class SymptomController {

	@Autowired
    SymptomService symptomService;

    @GetMapping("patients/{patientId}/symptoms")
    @Operation(summary="To get all symptoms")
    public ResponseEntity<?> get(@PathVariable(value="patientId") long patientId){
        ResponseEntity<?> response=new ResponseEntity<>(symptomService.viewAllSymptoms(patientId), HttpStatus.OK);
        return response;
    }

    @PostMapping("patients/{patientId}/symptoms")
    @Operation(summary = "To add Symptom")
    public ResponseEntity<?> post(@PathVariable(value="patientId")long patientId, @RequestBody Symptom symptom){
        ResponseEntity<?> response=new ResponseEntity<>(symptomService.addSymptom(patientId, symptom),HttpStatus.OK);
        return response;
    }

    @PutMapping("patients/{patientId}/symptoms/{symptomId}")
    @Operation(summary = "To update Symptom")
    public ResponseEntity<?> put(@PathVariable (value="patientId") long patientId,@PathVariable (value="symptomId") long symptomId,@RequestBody Symptom symptom){
        ResponseEntity<?> response=new ResponseEntity<>(symptomService.editSymptom(symptom,patientId,symptomId),HttpStatus.OK);
        return response;
    }


    @DeleteMapping("patients/{patientId}/symptoms/{symptomId}")
    @Operation (summary = "To delete Symptom")
    public ResponseEntity<?> delete(@PathVariable (value="patientId")long patientId,@PathVariable(value="symptomId")long symptomId){
        ResponseEntity<?> response=new ResponseEntity<>(symptomService.removeSymptom(patientId, symptomId),HttpStatus.OK);
        return response;
    }
}
