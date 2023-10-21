package com.clinic;

import static org.mockito.Mockito.when;
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

import com.clinic.controller.ServicesOfferedController;
import com.clinic.model.City;
import com.clinic.model.ServicesOffered;
import com.clinic.service.CityService;
import com.clinic.service.ClinicAvalabilityService;
import com.clinic.service.ClinicService;
import com.clinic.service.ServicesOfferedService;
import com.clinic.service.StateService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(controllers= {ServicesOfferedController.class})
public class ServicesOfferedTests {
	
	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	private ServicesOfferedService serviceoff;

	@MockBean
	private CityService citySer;
	
	@MockBean
	private ClinicService clinicser;
	
	@MockBean
	private ClinicAvalabilityService clinicAvailSer;

	@MockBean
	private StateService stateSer;
	
	private static ObjectMapper mapper=new ObjectMapper(); 
	
	@Test
	public void PositiveAddServiceTest() throws Exception{
		ServicesOffered service=new ServicesOffered();
		service.setServiceId(2);
		service.setServiceName("Xray");
		service.setServiceDesc("Xray Scan");
		service.setServiceCode("s45");
		service.setAvgPrice(1500.0);
		service.setActive(true);
		
		String json=mapper.writeValueAsString(service);
		
		when(serviceoff.addService(ArgumentMatchers.any())).thenReturn(service);
		mockmvc.perform(post("/services").content(json).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8")).andExpect(status().isOk())
				.andExpect(jsonPath("$.serviceId", Matchers.equalTo(2)))
				.andExpect(jsonPath("$.serviceName", Matchers.equalTo("Xray")))
				.andExpect(jsonPath("$.serviceDesc", Matchers.equalTo("Xray Scan")))
				.andExpect(jsonPath("$.serviceCode", Matchers.equalTo("s45")))
				.andExpect(jsonPath("$.avgPrice", Matchers.equalTo(1500.0)))
				.andExpect(jsonPath("$.active", Matchers.equalTo(true)));
				
	}
	
	
	
}
