package com.pratian.appointmentservice.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;

//import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pratian.appointmentservice.entities.Test;
//import com.pratian.appointmentservice.entities.Test;
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
public class AppointmentServiceTestControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
//	@MockBean
//	private AppointmentServiceImpl asi;
//	@MockBean
//	private TestServiceImpl ts;
//	

	@MockBean
	private AppointmentServiceImpl asi;

	@MockBean
	public CommentServiceImpl commentServiceImpl;

	@MockBean
	public TestServiceImpl ts;

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

	
	private static ObjectMapper mapper= new ObjectMapper();          
	
	
       @org.junit.jupiter.api.Test
	public void add_new_test_Test() throws Exception {
		Test test= new Test();
		test.setTestId(1);
		test.setTestName("Blood");
		String json=mapper.writeValueAsString(test);
		Mockito.when(ts.addTest(ArgumentMatchers.any())).thenReturn(test);
		mockMvc.perform(post("/tests").content(json).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
				.characterEncoding("utf-8"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.testId",Matchers.equalTo(1)))
		.andExpect(jsonPath("$.testName",Matchers.equalTo("Blood")));		
	}
	
	@org.junit.jupiter.api.Test
	public void get_test_details_ByName() throws Exception {
		Test test=new Test();
		test.setTestId(2);
		test.setTestName("Blood");
		
		Mockito.when(ts.getTestByName(test.getTestName())).thenReturn(test);
		mockMvc.perform(get("/tests/name/"+test.getTestName()).contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.testId", Matchers.equalTo(2)))
		.andExpect(jsonPath("$.testName", Matchers.equalTo("Blood")));
	}
	
	@org.junit.jupiter.api.Test
    public void PositiveGetAllTests() throws Exception {
    	
    	List<Test> alltests = new ArrayList<>();
    	Test test = new Test(); 
    	test.setTestId(1);
    	test.setTestName("g");
    	alltests.add(test);
    	Test test1 = new Test();
    	test1.setTestId(12);
    	test1.setTestName("gh");
    	alltests.add(test1);
    	System.out.println(alltests);
    	String json = mapper.writeValueAsString(alltests);
    	when(ts.getAllTest()).thenReturn(alltests);
    	mockMvc.perform(get("/tests").content(json).contentType(MediaType.APPLICATION_JSON)
    			.accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8")).andExpect(status().isOk())
    	.andExpect(jsonPath("$[0].testId", Matchers.equalTo(1)))
    	.andExpect(jsonPath("$[1].testName", Matchers.equalTo("gh")));
    	
    }
    
    @org.junit.jupiter.api.Test
    public void NegativeGetAllTests() throws Exception {
    	
    	List<Test> alltests = new ArrayList<>();
    	Test test = new Test(); 
    	test.setTestId(1);
    	test.setTestName("g");
    	alltests.add(test);
    	Test test1 = new Test();
    	test1.setTestId(12);
    	test1.setTestName("gh");
    	alltests.add(test1);
    	System.out.println(alltests);
    	String json = mapper.writeValueAsString(alltests);
    	when(ts.getAllTest()).thenReturn(alltests);
    	mockMvc.perform(get("/tests").content(json).contentType(MediaType.APPLICATION_JSON)
    			.accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8")).andExpect(status().isOk())
    	.andExpect(jsonPath("$[0].testId", Matchers.not(12)))
    	.andExpect(jsonPath("$[1].testName", Matchers.equalTo("gh")));
    	
    }
    
    @org.junit.jupiter.api.Test
    public void PositiveTestGetById() throws Exception {
    	
    	Test test = new Test(); 
    	
    	test.setTestId(1);
    	test.setTestName("g");
    	
    	String json = mapper.writeValueAsString(test);
    	when(ts.getTestById(test.getTestId())).thenReturn(test);
    	mockMvc.perform(get("/tests/id/" + test.getTestId() ).content(json).contentType(MediaType.APPLICATION_JSON)
    			.accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8")).andExpect(status().isOk())
    	.andExpect(jsonPath("$.testId", Matchers.equalTo(1)))
    	.andExpect(jsonPath("$.testName", Matchers.equalTo("g")));
    	
    }
    
    @org.junit.jupiter.api.Test
    public void NegativeTestGetById() throws Exception {
    	
    	Test test = new Test(); 
    	
    	test.setTestId(1);
    	test.setTestName("g");
    	
    	String json = mapper.writeValueAsString(test);
    	when(ts.getTestById(test.getTestId())).thenReturn(test);
    	mockMvc.perform(get("/tests/id/" + test.getTestId() ).content(json).contentType(MediaType.APPLICATION_JSON)
    			.accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8")).andExpect(status().isOk())
    	.andExpect(jsonPath("$.testId", Matchers.not(12)))
    	.andExpect(jsonPath("$.testName", Matchers.equalTo("g")));
    	
    }
    
    @org.junit.jupiter.api.Test
    public void PositiveTestGetByName() throws Exception {
    	
    	Test test = new Test(); 
    	
//    	test.setTestId(1);
    	test.setTestName("g");
    	
    	String json = mapper.writeValueAsString(test);
    	when(ts.getTestByName(test.getTestName())).thenReturn(test);
    	mockMvc.perform(get("/tests/name/" + test.getTestName() ).content(json).contentType(MediaType.APPLICATION_JSON)
    			.accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8")).andExpect(status().isOk())
//    	.andExpect(jsonPath("$.testId", Matchers.equalTo(1)))
    	.andExpect(jsonPath("$.testName", Matchers.equalTo("g")));
    	
    }
    
    @org.junit.jupiter.api.Test
    public void NegativeTestGetByName() throws Exception {
    	
    	Test test = new Test(); 
    	
//    	test.setTestId(1);
    	test.setTestName("g");
    	
    	String json = mapper.writeValueAsString(test);
    	when(ts.getTestByName(test.getTestName())).thenReturn(test);
    	mockMvc.perform(get("/tests/name/" + test.getTestName() ).content(json).contentType(MediaType.APPLICATION_JSON)
    			.accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8")).andExpect(status().isOk())
//    	.andExpect(jsonPath("$.testId", Matchers.equalTo(1)))
    	.andExpect(jsonPath("$.testName", Matchers.not("gh")));
    	
    }

}
