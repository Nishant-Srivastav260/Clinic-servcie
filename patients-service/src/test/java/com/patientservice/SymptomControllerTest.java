package com.patientservice;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.patientservice.controller.SymptomController;
import com.patientservice.entities.Patient;
import com.patientservice.entities.Symptom;
import com.patientservice.service.impl.PatientSeviceImpl;
import com.patientservice.service.impl.SymptomServiceImpl;
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = {SymptomController.class})
class SymptomControllerTest {

	@MockBean
    SymptomServiceImpl mockSymptomService;

    @MockBean
    PatientSeviceImpl mockPatientService;

    @Autowired
    MockMvc mockMvc;

    
    @Test
    void viewAllSymptomsTest() throws Exception {
        Patient patient =new Patient();
        patient.setPatientId(1l);
        List<Symptom> symptoms =new ArrayList<Symptom>();
        Symptom symptomToBeTested =new Symptom(2L, "cold", "heavy Cold", "sam");
        symptoms.add(symptomToBeTested);
        patient.setSymptoms(symptoms);
        when(mockPatientService.getPatientById(1L)).thenReturn(patient);
        Mockito.when(mockSymptomService.viewAllSymptoms(1L)).thenReturn(symptoms);
        mockMvc.perform(MockMvcRequestBuilders.get("/patients/{patientId}/symptoms",1L))
        .andExpect(MockMvcResultMatchers.status().is(200));
    }
    @Test
    void  deleteSymptomsById() throws Exception {
        Patient pat = new Patient(1L, "sdf", null, null, null, 0, null, null, 0, null, null, null, null, null, null, null, null);
        pat.setPatientId(1L);
        List<Symptom>symptoms=new ArrayList<Symptom>();
        Symptom sym1 = new Symptom();
        sym1.setSymptomId(1L);
        symptoms.add(sym1);
        pat.setSymptoms(symptoms);
        // Mockito.when( mockpatientService.existsById(1L)).thenReturn(HttpStatus.OK);
        Mockito.when(mockSymptomService.removeSymptom(1L, 1L)).thenReturn(HttpStatus.OK);
        mockMvc.perform(MockMvcRequestBuilders.delete("/patients/{patientId}/symptoms/{symptomId}",1L,1L))
        .andExpect(MockMvcResultMatchers.status().is(200));

    }
    @Test
    void addSymptomsByPaientId() throws Exception {
        Symptom sym1 = new Symptom(1l,"Cough","coughing","Mani");
        Patient pat = new Patient();
        pat.setPatientId(1l);
        Mockito.when(mockSymptomService.addSymptom(1l,sym1)).thenReturn(sym1);
        mockMvc.perform(MockMvcRequestBuilders.get("/patients/{patientId}/symptoms",1l))
        .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
