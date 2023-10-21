package com.pratian.appointmentservice.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
//import org.hamcrest.comparator.ComparatorMatcherBuilder;
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

//@SpringBootTest
@WebMvcTest
class AppointmentServiceAppointmentcontrollerTests {



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
		// when(appointmentServiceImpl.addAppointment(appointment)).thenReturn(appointment);
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
		appointment.setTime("11:00AM");
		appointment.setStatus("true");
		appointment.setAge(25);
		appointment.setDate("20-12-2020");

		String json = mapper.writeValueAsString(appointment);
		when(appointmentServiceImpl.addAppointment(ArgumentMatchers.any())).thenReturn(appointment);
		// when(appointmentServiceImpl.addAppointment(appointment)).thenReturn(appointment);
		mockMvc.perform(post("/appointments").content(json).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8")).andExpect(status().isOk())

				.andExpect(jsonPath("$.id", Matchers.equalTo(1000)))
				.andExpect(jsonPath("$.issue", Matchers.equalTo("headache")))
				.andExpect(jsonPath("$.time", Matchers.not("5:00AM")))
				.andExpect(jsonPath("$.status", Matchers.equalTo("true")))
				.andExpect(jsonPath("$.age", Matchers.not(26)))
				.andExpect(jsonPath("$.date", Matchers.equalTo("20-12-2020")));

	}

	
	@Test
    public void PositiveAppointmentGetById() throws Exception
    {
        Appointment appointment = new Appointment();
        appointment.setId(6474);
        appointment.setIssue("Panic Attack");
        appointment.setTime("4:00AM");
        appointment.setStatus("Recieved Treatment");
        appointment.setAge(30);
        String json = mapper.writeValueAsString(appointment);
        when(appointmentServiceImpl.getAppointmentById(appointment.getId())).thenReturn(appointment);  
        mockMvc.perform(get("/appointments/" + appointment.getId()).content(json).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id", Matchers.equalTo(6474)))
        .andExpect(jsonPath("$.issue", Matchers.equalTo("Panic Attack")))
        .andExpect(jsonPath("$.time", Matchers.equalTo("4:00AM")))
        .andExpect(jsonPath("$.status", Matchers.equalTo("Recieved Treatment")))
        .andExpect(jsonPath("$.age", Matchers.equalTo(30)));

    }


    @Test
    public void NegAppointmentGetById() throws Exception
    {
        Appointment appointment = new Appointment();
        appointment.setId(6474);
        appointment.setIssue("Panic Attack");
        appointment.setTime("4:00AM");
        appointment.setStatus("Recieved Treatment");
        appointment.setAge(30);
        String json = mapper.writeValueAsString(appointment);
        when(appointmentServiceImpl.getAppointmentById(appointment.getId())).thenReturn(appointment);  
        mockMvc.perform(get("/appointments/" + appointment.getId()).content(json).contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8"))
//        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id", Matchers.not(567)))
        .andExpect(jsonPath("$.issue", Matchers.equalTo("Panic Attack")))
        .andExpect(jsonPath("$.time", Matchers.equalTo("4:00AM")))
        .andExpect(jsonPath("$.status", Matchers.equalTo("Recieved Treatment")))
        .andExpect(jsonPath("$.age", Matchers.equalTo(30)));

    }
    
    @Test
    public void NegativeGetAllAppointment() throws Exception
    {
    	List<Appointment> added = new ArrayList<>();
    	Appointment appointment = new Appointment();
        appointment.setId(6474);
        appointment.setIssue("Panic Attack");
        appointment.setTime("4:00AM");
        appointment.setStatus("Recieved Treatment");
        appointment.setAge(30);
        added.add(appointment);
		Appointment appointment1 = new Appointment();
		appointment1.setId(1000);
		appointment1.setIssue("headache");
		appointment1.setTime("11:00AM");
		appointment1.setStatus("true");
		appointment1.setAge(25);
		added.add(appointment1);
		System.out.println(added);
		String json = mapper.writeValueAsString(added);
        when(appointmentServiceImpl.getAllAppointments()).thenReturn(added);  
        mockMvc.perform(get("/appointments").content(json)
        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
        .characterEncoding("utf-8")).andExpect(status().isOk())
        .andExpect(jsonPath("$", Matchers.hasSize(2)))
        .andExpect(jsonPath("$[0].id", Matchers.not(1000)))
        .andExpect(jsonPath("$[1].issue", Matchers.equalTo("headache")))
        .andExpect(jsonPath("$[1].time", Matchers.equalTo("11:00AM")));
    	
    	
    }
    
    @Test
    public void PositiveGetAllAppointment() throws Exception
    {
    	List<Appointment> added = new ArrayList<>();
    	Appointment appointment = new Appointment();
        appointment.setId(6474);
        appointment.setIssue("Panic Attack");
        appointment.setTime("4:00AM");
        appointment.setStatus("Recieved Treatment");
        appointment.setAge(30);
        added.add(appointment);
		Appointment appointment1 = new Appointment();
		appointment1.setId(1000);
		appointment1.setIssue("headache");
		appointment1.setTime("11:00AM");
		appointment1.setStatus("true");
		appointment1.setAge(25);
		added.add(appointment1);
		System.out.println(added);
		String json = mapper.writeValueAsString(added);
        when(appointmentServiceImpl.getAllAppointments()).thenReturn(added);  
        mockMvc.perform(get("/appointments").content(json)
        .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
        .characterEncoding("utf-8")).andExpect(status().isOk())
        .andExpect(jsonPath("$", Matchers.hasSize(2)))
        .andExpect(jsonPath("$[0].id", Matchers.equalTo(6474)))
        .andExpect(jsonPath("$[1].issue", Matchers.equalTo("headache")))
        .andExpect(jsonPath("$[1].time", Matchers.equalTo("11:00AM")));
    	
    	
    }
    
    @Test
	public void PositiveAddVitalTest() throws Exception {
		
		Vitals vital = new Vitals();
		vital.setId(56);
		vital.setDiabetes(45);
		vital.setRespiration_rate(67);
		vital.setTemperature(68);
		String json = mapper.writeValueAsString(vital);
		when(vitalsServiceImpl.saveVital(ArgumentMatchers.any())).thenReturn(vital);
		mockMvc.perform(post("/vitals").content(json).contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8")).andExpect(status().isOk())
		.andExpect(jsonPath("$.id", Matchers.equalTo(56)))
		.andExpect(jsonPath("$.diabetes", Matchers.equalTo(45)))
		.andExpect(jsonPath("$.respiration_rate", Matchers.equalTo(67)))
		.andExpect(jsonPath("$.temperature", Matchers.equalTo(68)));

	}
    
    @Test
	public void NegativeAddVitalTest() throws Exception {
		
		Vitals vital = new Vitals();
		vital.setId(56);
		vital.setDiabetes(45);
		vital.setRespiration_rate(67);
		vital.setTemperature(68);
		String json = mapper.writeValueAsString(vital);
		when(vitalsServiceImpl.saveVital(ArgumentMatchers.any())).thenReturn(vital);
		mockMvc.perform(post("/vitals").content(json).contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8")).andExpect(status().isOk())
		.andExpect(jsonPath("$.id", Matchers.not(57)))
		.andExpect(jsonPath("$.diabetes", Matchers.equalTo(45)))
		.andExpect(jsonPath("$.respiration_rate", Matchers.equalTo(67)))
		.andExpect(jsonPath("$.temperature", Matchers.equalTo(68)));

	}
    
    @Test
    public void PositiveGetByIdVitalTest() throws Exception {
    	Vitals vital = new Vitals();
		vital.setId(56);
		vital.setECG(66);
		vital.setDiabetes(45);
		vital.setRespiration_rate(67);
		vital.setTemperature(68);
		String json = mapper.writeValueAsString(vital);
		when(vitalsServiceImpl.getVitalsById(ArgumentMatchers.anyLong())).thenReturn(vital);
		mockMvc.perform(get("/vitals/" + vital.getId()).content(json).contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8")).andExpect(status().isOk())
		.andExpect(jsonPath("$.id", Matchers.equalTo(56)));
		
    	
    }
    
    @Test
    public void NegativeGetByIdVitalTest() throws Exception {
    	Vitals vital = new Vitals();
		vital.setId(56);
		vital.setECG(66);
		vital.setDiabetes(45);
		vital.setRespiration_rate(67);
		vital.setTemperature(68);
		String json = mapper.writeValueAsString(vital);
		when(vitalsServiceImpl.getVitalsById(ArgumentMatchers.anyLong())).thenReturn(vital);
		mockMvc.perform(get("/vitals/" + vital.getId()).content(json).contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8")).andExpect(status().isOk())
		.andExpect(jsonPath("$.id", Matchers.not(58)));
		
    	
    }
    
   
    
    
    
    
//    @Test
//    public void PositiveGetVitalByAppointmentId() throws Exception {
//    	Appointment appointment = new Appointment();
//    	Vitals vital = new Vitals();
//    	vital.setDiabetes(56);
//    	vital.setId(23);
//    	vital.setRespiration_rate(45);
//    	vital.setTemperature(34);
//    	appointment.setVitals(vital);
//    	String json = mapper.writeValueAsString(appointment.getVitals());
//    	when(appointmentServiceImpl.getVitalsbyAppoinmentId(vital.getId())).thenReturn(appointment.getVitals());
//    	mockMvc.perform(get("/test/getOnetest/" + appointment.getVitals()).content(json).contentType(MediaType.APPLICATION_JSON)
//        .accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8")).andExpect(status().isOk())
//    	.andExpect(jsonPath("$.id", Matchers.equalTo(23)))
//    	.andExpect(jsonPath("$.temperature", Matchers.equalTo(34)))
//    	.andExpect(jsonPath("$.diabetes", Matchers.equalTo(56)))
//    	.andExpect(jsonPath("$.respiration_rate", Matchers.equalTo(45)));
//    	
//    }
	
    @Test
    public void PositiveAddTest() throws Exception {
    	
    	
    	
    }


}