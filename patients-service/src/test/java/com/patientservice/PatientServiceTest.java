package com.patientservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.patientservice.entities.Patient;
import com.patientservice.exception.PatientNotFoundException;
import com.patientservice.repository.PatientRepository;
import com.patientservice.service.impl.PatientSeviceImpl;

@ExtendWith(MockitoExtension.class)
class PatientServiceTest {
	 @Mock
	    PatientRepository patientRepository;

	    @InjectMocks
	    PatientSeviceImpl patientServiceImpl;

	    @Test
	    void getAllPatientsTest() throws PatientNotFoundException {

	        Patient patient1 = new Patient();
	        patient1.setPatientId(1l);
	        Patient patient2 = new Patient();
	        patient2.setPatientId(1l);
	        Patient patient3 = new Patient();
	        patient3.setPatientId(1l);
	        Patient patient4 = new Patient();
	        patient4.setPatientId(1l);
	        Patient patient5 = new Patient();
	        patient5.setPatientId(1l);
	        Patient patient6 = new Patient();
	        patient6.setPatientId(1l);

	        

	        List<Patient> patientsToTestMethod = new ArrayList<Patient>();
	        patientsToTestMethod.add(patient6);
	        patientsToTestMethod.add(patient5);
	        patientsToTestMethod.add(patient4);
	        patientsToTestMethod.add(patient3);
	        patientsToTestMethod.add(patient2);
	        patientsToTestMethod.add(patient1);

	        Mockito.when(patientRepository.findAll()).thenReturn(patientsToTestMethod);
	        int size =patientServiceImpl.getPatients().size();
	        assertEquals(6, size);
	    }

	   

	    @Test
	    void getAllPatientsFalseTest()  {

	     //   List<Patient> patientsToTestMethod = new ArrayList<Patient>();


	        Mockito.when(patientRepository.findAll()).thenReturn(null);
	        assertThrows(PatientNotFoundException.class, ()-> patientServiceImpl.getPatients());

	    }

	    

	    @Test
	    void getPatientByIdTest() throws PatientNotFoundException
	    {
	        Patient patient1 = new Patient();
	        patient1.setPatientId(1l);
	        Patient patient2 = new Patient();
	        patient2.setPatientId(1l);

	        
	        Mockito.when(patientRepository.existsById(patient1.getPatientId())).thenReturn(true);
	        Mockito.when(patientRepository.getPatientById(patient1.getPatientId())).thenReturn(patient1);


	       


	        assertEquals(patientServiceImpl.getPatientById(patient1.getPatientId()), patient2);

	    }

	    @Test
	    void getPatientByIdFalseTest()
	    {
	        Patient patient1 = new Patient();
	        Patient patient2 = new Patient();
	        patient1.setPatientId(1l);
	        patient2.setPatientId(1l);

	        Mockito.when(patientRepository.existsById(patient1.getPatientId())).thenReturn(false);

	        assertThrows(PatientNotFoundException.class, ()-> patientServiceImpl.getPatientById(patient2.getPatientId()));
	    }

}
