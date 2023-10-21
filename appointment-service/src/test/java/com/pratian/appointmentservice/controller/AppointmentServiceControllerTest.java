package com.pratian.appointmentservice.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.pratian.appointmentservice.service.impl.AppointmentServiceImpl;
import com.pratian.appointmentservice.service.impl.CommentServiceImpl;
import com.pratian.appointmentservice.service.impl.DoctorDetailsServiceImpl;
import com.pratian.appointmentservice.service.impl.FeedbackServiceImpl;
import com.pratian.appointmentservice.service.impl.NewAppointmentServiceImpl;
import com.pratian.appointmentservice.service.impl.PatientDetailsServiceImpl;
import com.pratian.appointmentservice.service.impl.PrescriptionServiceIml;
import com.pratian.appointmentservice.service.impl.RecommendationServiceImpl;
import com.pratian.appointmentservice.service.impl.TestServiceImpl;
import com.pratian.appointmentservice.service.impl.VitalsServiceImpl;

@WebMvcTest
public class AppointmentServiceControllerTest {

	@Autowired
	private MockMvc mockMvc;

//	@MockBean
//	private IAppointmentService appointmentService;

	@MockBean
	private AppointmentServiceImpl appointmentServiceImpl;

	@MockBean
	public CommentServiceImpl commentServiceImpl;

	@MockBean
	public TestServiceImpl testServiceImpl;

	@MockBean
	public DoctorDetailsServiceImpl detailsServiceImpl;

	@MockBean
	public FeedbackServiceImpl feedbackServiceImpl;

	@MockBean
	public VitalsServiceImpl vitalsServiceImpl;

	@MockBean
	public PatientDetailsServiceImpl patientDetailsServiceImpl;

	@MockBean
	public PrescriptionServiceIml prescriptionServiceIml;

	@MockBean
	public RecommendationServiceImpl recommendationServiceImpl;

	@MockBean
	public NewAppointmentServiceImpl newAppointmentServiceImpl;

	private static ObjectMapper mapper = new ObjectMapper();

	@Test
	public void addAppointmentTest() throws Exception {

		Appointment appointment = new Appointment();
		appointment.setId(1000);
		appointment.setIssue("headache");
		appointment.setTime("5:00AM");
		appointment.setStatus("true");
		appointment.setAge(25);
		appointment.setDate("20-12-2020");

		String json = mapper.writeValueAsString(appointment);
		when(appointmentServiceImpl.addAppointment(ArgumentMatchers.any())).thenReturn(appointment);
		mockMvc.perform(post("/appointments").content(json).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8")).andExpect(status().isOk())

				.andExpect(jsonPath("$.id", Matchers.equalTo(1000)))
				.andExpect(jsonPath("$.issue", Matchers.equalTo("headache")))
				.andExpect(jsonPath("$.time", Matchers.equalTo("5:00AM")))
				.andExpect(jsonPath("$.status", Matchers.equalTo("true")))
				.andExpect(jsonPath("$.age", Matchers.equalTo(25)))
				.andExpect(jsonPath("$.date", Matchers.equalTo("20-12-2020")));

	}

	@Test
	public void addAppointmentTestNeg() throws Exception {

		Appointment appointment = new Appointment();
		appointment.setId(1000);
		appointment.setIssue("headache");
		appointment.setTime("5:00AM");
		appointment.setStatus("true");
		appointment.setAge(25);
		appointment.setDate("20-12-2020");

		String json = mapper.writeValueAsString(appointment);
		when(appointmentServiceImpl.addAppointment(ArgumentMatchers.any())).thenReturn(appointment);
		// when(appointmentServiceImpl.addAppointment(appointment)).thenReturn(appointment);
		mockMvc.perform(post("/appointments").content(json).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8")).andExpect(status().isOk())

				.andExpect(jsonPath("$.id", Matchers.not(500)))
				.andExpect(jsonPath("$.issue", Matchers.equalTo("headache")))
				.andExpect(jsonPath("$.time", Matchers.equalTo("5:00AM")))
				.andExpect(jsonPath("$.status", Matchers.equalTo("true")))
				.andExpect(jsonPath("$.age", Matchers.equalTo(25)))
				.andExpect(jsonPath("$.date", Matchers.equalTo("20-12-2020")));

	}

//	@Test
//	public void getTestsForAppointmentTest() throws Exception {
//		//Appointment appoin= new ArrayList<Appointment>();
//		Appointment appoin = new Appointment();
//		appoin.setId(1000);
//		appoin.setIssue("headeck");
//		appoin.setTime("5:00AM");
//		appoin.setStatus("true");
//		appoin.setAge(25);
//		appoin.setDate("20-12-2020");
//		
//		when(appointmentServiceImpl.getTestsForAppointment(ArgumentMatchers.anyInt())).thenReturn(appoin);
//		mockMvc.perform(get("/appointment/getAllTestForAppointment/1000").contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8")).andExpect(status().isOk());
//	
//	}
//	@Test
//	public void getTestsForAppointmentTestNeg() throws Exception {
//		//Appointment appoin= new ArrayList<Appointment>();
//		Appointment appoin = new Appointment();
//		appoin.setId(1000);
//		appoin.setIssue("headeck");
//		appoin.setTime("5:00AM");
//		appoin.setStatus("true");
//		appoin.setAge(25);
//		appoin.setDate("20-12-2020");
//		
//		when(appointmentServiceImpl.getTestsForAppointment(ArgumentMatchers.anyInt())).thenReturn(appoin);
//		mockMvc.perform(get("/appointment/getAllTestForAppointment/1000").contentType(MediaType.APPLICATION_JSON)
//				.accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8")).andExpect(status().isOk());
//	
//	}
//	
	
}
