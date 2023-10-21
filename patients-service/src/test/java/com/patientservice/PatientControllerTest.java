package com.patientservice;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.patientservice.controller.PatientController;
import com.patientservice.entities.Feedback;
import com.patientservice.entities.Patient;
import com.patientservice.entities.Symptom;
import com.patientservice.service.PatientService;
@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = {PatientController.class})
class PatientControllerTest {
	@MockBean
    PatientService patientService;

    @Autowired
    MockMvc mockMvc;

    @Test
    void getAllPatientTest() throws Exception 
    {
        List<Patient> patients= null;
        long id = 10;
        Patient patient1 = new Patient();
        patient1.setPatientId(id);
        Patient patient2 = new Patient();
        patient2.setPatientId(id);
        Patient patient3 = new Patient();
        patient3.setPatientId(id);
        Patient patient4 = new Patient();
        patient4.setPatientId(id);


        Mockito.when(patientService.getPatients()).thenReturn(patients);


        mockMvc
            .perform(MockMvcRequestBuilders.get("/patients"))
            .andExpect(MockMvcResultMatchers.status().isOk());

    }


    @Test
    void getPatientByIdTest() throws Exception {
        List<Symptom> symptoms = null;
        List<Feedback> feedbacks = null;
        List<Patient> p1 = new ArrayList<Patient>();
        Patient dataReturnedByMock = new Patient(1L, "cxv", "vx", "cxv", "gf", 5, "gd", "trt", 02, "g", "gdf", "FGd",
                "fdg", "we", "xz", feedbacks, symptoms);
        p1.add(dataReturnedByMock);
        Mockito.when(patientService.getPatientById(1L)).thenReturn(dataReturnedByMock);
        mockMvc.perform(MockMvcRequestBuilders.get("/patients/{id}", 1L))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}
