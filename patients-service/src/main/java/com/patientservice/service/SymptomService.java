package com.patientservice.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.patientservice.entities.Symptom;

public interface SymptomService {
	
	public List<Symptom> viewAllSymptoms(long id); 
	public Symptom addSymptom(long id,Symptom symptom);
	public Symptom editSymptom(Symptom symptom,long patientId,long symptomId);
	public HttpStatus removeSymptom(long patientId,long symptomId);	
}
