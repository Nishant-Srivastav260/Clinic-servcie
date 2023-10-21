package com.pratian.appointmentservice.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pratian.appointmentservice.entities.Appointment;
import com.pratian.appointmentservice.entities.Prescriptions;
import com.pratian.appointmentservice.service.IPrescriptionService;


@WebMvcTest(controllers = {PrescriptionController.class})
public class PrescriptionControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	IPrescriptionService mockService;

	
	private static ObjectMapper mapper = new ObjectMapper();

	@Test
	void add_New_Prescription() throws Exception {
		Appointment appointment=new Appointment();
		appointment.setId(1);
		Prescriptions prescription=new Prescriptions();
		prescription.setPrescriptionId(1);
		prescription.setMedicineName("sumo");
		String json = mapper.writeValueAsString(prescription);
		when(mockService.addPrescription(ArgumentMatchers.any(),ArgumentMatchers.anyLong())).thenReturn(prescription);
		mockMvc.perform(post("/appointments/"+appointment.getId()+"/prescriptions").content(json).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8"))
		.andExpect(status().isOk())
		//.andExpect(jsonPath("$.id", Matchers.equalTo(1)))
		.andExpect(jsonPath("$.prescriptionId", Matchers.equalTo(1)))
		.andExpect(jsonPath("$.medicineName", Matchers.equalTo("sumo")));
		
	}
	
	@Test
	void update_Prescription() throws Exception {
		Prescriptions prescription=new Prescriptions();
		prescription.setPrescriptionId(1);
		prescription.setMedicineName("sumo");
		String json = mapper.writeValueAsString(prescription);
		when(mockService.editPrescription(ArgumentMatchers.anyLong(),ArgumentMatchers.any())).thenReturn(prescription);
		mockMvc.perform(put("/prescriptions/"+prescription.getPrescriptionId()).content(json).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.prescriptionId", Matchers.equalTo(1)))
		.andExpect(jsonPath("$.medicineName", Matchers.equalTo("sumo")));
		
	}
	
	@Test
	void get_Prescription() throws Exception {
		Prescriptions prescription=new Prescriptions();
		prescription.setPrescriptionId(1);
		
		when(mockService.getOnePrescriprion(ArgumentMatchers.anyLong())).thenReturn(prescription);
		mockMvc.perform(get("/prescriptions/"+prescription.getPrescriptionId()).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.prescriptionId", Matchers.equalTo(1)));
		
	}
	
	@Test
	void get_Prescription_By_Appoinment() throws Exception {
		Appointment appointment=new Appointment();
		appointment.setId(1);
		List<Prescriptions> listPrescriptions=new ArrayList<Prescriptions>();
		Prescriptions prescription=new Prescriptions();
		prescription.setPrescriptionId(1);
		Prescriptions prescription1=new Prescriptions();
		prescription1.setPrescriptionId(2);
		listPrescriptions.add(prescription);
		listPrescriptions.add(prescription1);
		
		when(mockService.viewPrescriptionbyAppointmentId(appointment.getId())).thenReturn(listPrescriptions);
		mockMvc.perform(get("/appointments/"+appointment.getId()+"/prescriptions").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.[0]prescriptionId", Matchers.equalTo(1)))
		.andExpect(jsonPath("$.[1]prescriptionId", Matchers.equalTo(2)));
	}

}
