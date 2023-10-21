package com.patientservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.patientservice.entities.Patient;
import com.patientservice.entities.Symptom;
import com.patientservice.exception.PatientNotFoundException;
import com.patientservice.exception.SymptomListIsEmptyException;
import com.patientservice.exception.SymptomNotFoundException;
import com.patientservice.repository.PatientRepository;
import com.patientservice.repository.SymptomRepository;
import com.patientservice.service.SymptomService;

@Service
public class SymptomServiceImpl implements SymptomService{

	@Autowired
	SymptomRepository symptomRepository;

	@Autowired
	PatientRepository patientRepository;

	@Override
	public List<Symptom> viewAllSymptoms(long id) {
		if(patientRepository.existsById(id)) {
			Patient patient=patientRepository.getPatientById(id);

			List<Symptom> symptoms=patient.getSymptoms();
			if(symptoms.isEmpty()) {
				throw new SymptomListIsEmptyException("Symptom list is empty for patient with id "+id);
			}
			return symptoms ;
		}
		else {
			throw new PatientNotFoundException("Patient not found with the id "+id);
		}
	}

	@Override
	public Symptom addSymptom(long id ,Symptom symptom) {
		if(patientRepository.existsById(id)) {
			Patient patient=patientRepository.getPatientById(id);
			patient.getSymptoms().add(symptom);
			Symptom symptomToBeAdded=symptomRepository.save(symptom);
			return symptomToBeAdded;
		}
		else
			throw new PatientNotFoundException("Patient not found with the id "+id);
	}

	@Override
	public Symptom editSymptom(Symptom symptom,long patientId,long symptomId) {
		if(patientRepository.existsById(patientId)) {
			if(symptomRepository.existsById(symptomId)) {
				Symptom symptomToBeUpdated=symptomRepository.getSymptomById(symptomId);
				symptomToBeUpdated.setSymptomName(symptom.getSymptomName());
				symptomToBeUpdated.setReading(symptom.getReading());
				symptomToBeUpdated.setDoctorname(symptom.getDoctorname());
				symptomRepository.save(symptomToBeUpdated);
				return symptomToBeUpdated;
			}
			else 
				throw new SymptomNotFoundException("Symptom not found with id "+symptomId);

		}
		else
			throw new PatientNotFoundException("Patient not found with the Patient Id "+patientId);
	}

	@Override
	public HttpStatus removeSymptom(long patientId,long symptomId) {
		if(patientRepository.existsById(patientId)) {
			Patient patient=patientRepository.getPatientById(patientId);
			List<Symptom> symptoms=patient.getSymptoms();
			if(!symptoms.isEmpty()) {
				symptomRepository.deleteById(symptomId);
				return HttpStatus.OK;
			}
			else
				throw new SymptomNotFoundException("Symptom not found with id "+symptomId);
		}
		else
			throw new PatientNotFoundException("Patient not found with the id "+patientId);
	}

}
