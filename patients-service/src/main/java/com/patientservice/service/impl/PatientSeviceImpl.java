package com.patientservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patientservice.dto.PatientDTO;
import com.patientservice.entities.Patient;
import com.patientservice.exception.PatientAlreadyExistsException;
import com.patientservice.exception.PatientNotFoundException;
import com.patientservice.mapper.PatientMapper;
import com.patientservice.repository.PatientRepository;
import com.patientservice.service.PatientService;

@Service

public class PatientSeviceImpl implements PatientService{
	@Autowired
    PatientRepository patientRepository;

    @Override
    public List<Patient> getPatients()  {
        if(patientRepository.findAll()==null)
        {
            throw new PatientNotFoundException();
        }
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatientById(long id)  {
        if(patientRepository.existsById(id))
        {
            return patientRepository.getPatientById(id);
        }
        else
        {
            throw new PatientNotFoundException();
        }

    }

    @Override
    public Patient savePatient(Patient patient) {
        if (patientRepository.existsById(patient.getPatientId())) {
            throw new PatientAlreadyExistsException("Patient Already Exists");
        } else {
            return patientRepository.save(patient);
        }
    }
    @Autowired
    PatientMapper mapper;

    @Override
    public PatientDTO viewPatientProfileInfo(long id) {
        if(patientRepository.existsById(id)) {
            Patient patient = patientRepository.getPatientById(id);
            PatientDTO patientDto = mapper.converToDto(patient);
            return patientDto;
        }
        else
        {
            throw new PatientNotFoundException("Patient_Not_found");
        }

    }

    @Override
    public PatientDTO editPatientProfileInfo(long id, PatientDTO patientDto) {
        if(patientRepository.existsById(id)) {
            Patient patient = patientRepository.getPatientById(id);

            patient.setPatientName(patientDto.getPatientName());
            patient.setPatientPhone(patientDto.getPatientPhone());
            patient.setPatientLocation(patientDto.getPatientLocation());
            patient.setPatientImageUrl(patientDto.getPatientImageUrl());
            patient.setPatientAge(patientDto.getPatientAge());
            patient.setPatientMail(patientDto.getPatientMail());
            patient.setPatientBloodgroup(patientDto.getPatientBloodgroup());
            patient.setPatientHeight(patientDto.getPatientHeight());
            patient.setPatientGender(patientDto.getPatientGender());
            patient.setTitle(patientDto.getTitle());
            patient.setPatientDOB(patientDto.getPatientDOB());
            patient.setAllergie(patientDto.getAllergie());
            patient.setActiveIssue(patientDto.getActiveIssue());
            patient.setActiveIssue(patientDto.getActiveIssue());
            patientRepository.save(patient);
            PatientDTO pDto = mapper.converToDto(patient);
            return pDto;
        }
        else
        {
            throw new PatientNotFoundException("Patient_Not_found");
        }
    }

    @Override
    public PatientDTO addPatientProfilePicture(long id, String profileImageUrl) {
        if(patientRepository.existsById(id))
        {
                Patient patientUpdated = patientRepository.getPatientById(id);
                patientUpdated.setPatientImageUrl(profileImageUrl);
                patientRepository.save(patientUpdated);
                PatientDTO pDto = mapper.converToDto(patientUpdated);
                return pDto;    
        }
        else
        {
            throw new PatientNotFoundException("Patient_Not_found");
        }
    }

    @Override
    public PatientDTO deletePatientProfilePicture(long id) {
        if(patientRepository.existsById(id))
        {
            Patient patient = patientRepository.getPatientById(id);
            patient.setPatientImageUrl(null);
            patientRepository.save(patient);
            PatientDTO pDto = mapper.converToDto(patient);
            return pDto;
        }
        else
        {
            throw new PatientNotFoundException("Patient_Not_found");
        }
    }

}
