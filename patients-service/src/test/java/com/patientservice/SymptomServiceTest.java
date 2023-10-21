package com.patientservice;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.patientservice.entities.Patient;
import com.patientservice.entities.Symptom;
import com.patientservice.exception.PatientNotFoundException;
import com.patientservice.exception.SymptomNotFoundException;
import com.patientservice.repository.PatientRepository;
import com.patientservice.repository.SymptomRepository;
import com.patientservice.service.impl.PatientSeviceImpl;
import com.patientservice.service.impl.SymptomServiceImpl;

@ExtendWith(MockitoExtension.class)
class SymptomServiceTest {

	@Mock
    SymptomRepository symptomRepository;

    @Mock
    PatientRepository patientRepository;

    @MockBean
    @InjectMocks
    PatientSeviceImpl patientService;

    @MockBean
    @InjectMocks
    SymptomServiceImpl symptomService;

    @Test
    void viewAllSymptomByPatientId_Gives_Positive_Response_And_Returns_All_Symptoms() {

        Patient patientToBeTested=new Patient();
        patientToBeTested.setPatientId(1L);
        List<Symptom> listToTest=new ArrayList<Symptom>();

        Symptom symptom1=new Symptom(1, "Fever", "93F", "Ben");
        Symptom symptom2=new Symptom(2, "Cold", "Heavy Cold", "Clar");
        listToTest.add(symptom1);
        listToTest.add(symptom2);

        patientToBeTested.setSymptoms(listToTest);

        when(patientRepository.existsById(ArgumentMatchers.any())).thenReturn(true);
        when(patientRepository.getPatientById(1l)).thenReturn(patientToBeTested);

        List<Symptom> listToCompare=symptomService.viewAllSymptoms(1l);
        assertEquals(listToTest.size(),listToCompare.size());
        assertEquals(listToTest.get(0).getDoctorname(), listToCompare.get(0).getDoctorname());

    }

    @Test
    void  viewAllSymptomByPatientId_Gives_Negative_Response_And_Returns_PatientNotFoundException() {
        Patient patientToBeTested=new Patient();
        patientToBeTested.setPatientId(1L);        
        Mockito.when(patientRepository.existsById(ArgumentMatchers.any())).thenReturn(false);
        assertThrows(PatientNotFoundException.class,()-> symptomService.viewAllSymptoms(1L));
    }

    @Test
    void removeSymptomThrowsPatientNotFoundException() throws Exception {
        Patient S1 = new Patient();
        S1.setPatientId(1);
        Mockito.when(patientRepository.existsById(1l)).thenReturn(false);
        assertThrows(PatientNotFoundException.class, () -> symptomService.removeSymptom(1L, 1L));

    }

    @Test
    void removeSymptomReturnsStatusOkWhenDeleted() throws Exception {
        Patient p1 = new Patient();
        p1.setPatientId(1);
        List<Symptom> s = new ArrayList<Symptom>();
        Symptom s1 = new Symptom();
        s1.setSymptomId(1l);
        s.add(s1);
        p1.setSymptoms(s);
        Mockito.when(patientRepository.existsById(1l)).thenReturn(true);
        Mockito.when(patientRepository.getPatientById(1l)).thenReturn(p1);
        assertEquals(HttpStatus.OK, symptomService.removeSymptom(1L, 1L));

    }

    @Test
    void removeSymptomSymptonNotFoundException() throws Exception {
        Patient p1 = new Patient();
        p1.setPatientId(1);
        List<Symptom> s = new ArrayList<Symptom>();
        p1.setSymptoms(s);
        Mockito.when(patientRepository.existsById(1l)).thenReturn(true);
        Mockito.when(patientRepository.getPatientById(1l)).thenReturn(p1);
        assertThrows(SymptomNotFoundException.class, () -> symptomService.removeSymptom(1L, 1L));

    }



}
