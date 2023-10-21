package com.pratian.appointmentservice.controller;

import static org.mockito.Mockito.mock;
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
import com.pratian.appointmentservice.entities.Vitals;
import com.pratian.appointmentservice.service.VitalsService;

@WebMvcTest(controllers = {VitalsController.class})
public class VitalControllerTest {		
		@Autowired
		private MockMvc mockMvc;
		
		@MockBean
		VitalsService mockService;

		
		private static ObjectMapper mapper = new ObjectMapper();
		

		@Test
		void get_Vital() throws Exception {
			List<Vitals> listVital = new ArrayList<>();
			Vitals vital1=new Vitals();
			vital1.setId(1);
			vital1.setECG(12);
			vital1.setTemperature(35);
			
			Vitals vital2=new Vitals();
			vital2.setId(2);
			vital2.setECG(14);
			vital2.setTemperature(35);
			listVital.add(vital1);
			listVital.add(vital2);
			
			String json = mapper.writeValueAsString(listVital);
			when(mockService.getVitals()).thenReturn(listVital);
			mockMvc.perform(get("/vitals").content(json).contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.[0]id",Matchers.equalTo(1)))
			.andExpect(jsonPath("$.[0]ecg",Matchers.equalTo(12)))
			.andExpect(jsonPath("$.[1]id",Matchers.equalTo(2)))
			.andExpect(jsonPath("$.[1]ecg",Matchers.equalTo(14)));
			
		}

		@Test
		void add_New_Vital_By_AppoinmentId() throws Exception {
			Appointment appointment=new Appointment();
			appointment.setId(1);
			Vitals vital = new Vitals();
			vital.setId(1);
			vital.setECG(12);
			vital.setTemperature(35);
			String json = mapper.writeValueAsString(vital);
			when(mockService.addVitalsToAppointmentId(ArgumentMatchers.anyLong(),ArgumentMatchers.any())).thenReturn(vital);
			mockMvc.perform(post("/appointments/"+appointment.getId()+"/vitals").content(json).contentType(MediaType.APPLICATION_JSON)
					.accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.id",Matchers.equalTo(1)))
			.andExpect(jsonPath("$.ecg",Matchers.equalTo(12)));
			
		}
		

         @Test
         void update_Vital() throws Exception{
        	 Vitals vital = new Vitals();
        	vital.setId(1);
        	 vital.setTemperature(55);
        	 String json = mapper.writeValueAsString(vital);
        	 when(mockService.updateVital(ArgumentMatchers.anyLong(),ArgumentMatchers.any())).thenReturn(vital);
        	 mockMvc.perform(put("/vitals/"+vital.getId()).content(json).contentType(MediaType.APPLICATION_JSON)
        			 .accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8"))
        	         .andExpect(status().isOk())
        	         .andExpect(jsonPath("$.id",Matchers.equalTo(1)))
        	         .andExpect(jsonPath("$.temperature",Matchers.equalTo(55)));
         }
   
       
         @Test
         void get_Vitals() throws Exception{
        	 Vitals vitals = new Vitals();
        	 vitals.setId(2);
        	 
        	 when(mockService.getVitalsById(ArgumentMatchers.anyLong())).thenReturn(vitals);
        	 mockMvc.perform(get("/vitals/"+vitals.getId()).contentType(MediaType.APPLICATION_JSON)
        			 .accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8"))
        	        .andExpect(jsonPath("$.id", Matchers.equalTo(2)));
        	 
        	 
         }
         
         }
