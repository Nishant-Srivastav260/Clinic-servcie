
package com.clinic;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

import com.clinic.model.Clinic;
import com.clinic.model.ServicesOffered;
import com.clinic.service.CityService;
import com.clinic.service.ClinicAvalabilityService;
import com.clinic.service.ClinicService;
import com.clinic.service.ServicesOfferedService;
import com.clinic.service.StateService;
import com.fasterxml.jackson.databind.ObjectMapper;


@WebMvcTest
public class ClinicTests {

	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	private ClinicService clinicser;
	
	@MockBean
	private ServicesOfferedService serviceoff;
	
	@MockBean
	private CityService cityser;
	
	@MockBean
	private StateService stateser;
	
	@MockBean
	private ClinicAvalabilityService clinicAvailSer;
	
	private static ObjectMapper mapper =new ObjectMapper();
	
	@Test
	public void PositiveAddClinicTest() throws Exception {
		Clinic clinic=new Clinic();
		clinic.setClinicId(1);
		clinic.setBussinessName("business");
		clinic.setClinicCountry("country");
		clinic.setClinicName("prajnfc");
		clinic.setStreetAddr("streetAddr");
		clinic.setLatitude("latitude");
		clinic.setLongitude("longitude");
		clinic.setZipcode("523698");
		
		String json=mapper.writeValueAsString(clinic);
		
		when(clinicser.addClinic(ArgumentMatchers.any())).thenReturn(clinic);
		mockmvc.perform(post("/clinic").content(json).contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8")).andExpect(status().isOk())
		.andExpect(jsonPath("$.clinicId", Matchers.equalTo(1)))
		.andExpect(jsonPath("$.clinicName", Matchers.equalTo("prajnfc")))
		.andExpect(jsonPath("$.bussinessName", Matchers.equalTo("business")))
		.andExpect(jsonPath("$.streetAddr", Matchers.equalTo("streetAddr")))
		.andExpect(jsonPath("$.clinicCountry", Matchers.equalTo("country")))
		.andExpect(jsonPath("$.longitude", Matchers.equalTo("longitude")))
		.andExpect(jsonPath("$.latitude", Matchers.equalTo("latitude")))
		.andExpect(jsonPath("$.zipcode", Matchers.equalTo("523698")));
	}
	
	@Test
	public void NegativeAddClinicTest() throws Exception {
		Clinic clinic=new Clinic();
		clinic.setClinicId(1);
		clinic.setBussinessName("business");
		clinic.setClinicCountry("country");
		clinic.setClinicName("prajnfc");
		clinic.setStreetAddr("streetAddr");
		clinic.setLatitude("latitude");
		clinic.setLongitude("longitude");
		clinic.setZipcode("523698");
		
		String json=mapper.writeValueAsString(clinic);
		
		when(clinicser.addClinic(ArgumentMatchers.any())).thenReturn(clinic);
		mockmvc.perform(post("/clinic").content(json).contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8")).andExpect(status().isOk())
		.andExpect(jsonPath("$.clinicId", Matchers.not(0)))
		.andExpect(jsonPath("$.clinicName", Matchers.not("prnfc")))
		.andExpect(jsonPath("$.bussinessName", Matchers.equalTo("business")))
		.andExpect(jsonPath("$.streetAddr", Matchers.equalTo("streetAddr")))
		.andExpect(jsonPath("$.clinicCountry", Matchers.not("couny")))
		.andExpect(jsonPath("$.longitude", Matchers.equalTo("longitude")))
		.andExpect(jsonPath("$.latitude", Matchers.equalTo("latitude")))
		.andExpect(jsonPath("$.zipcode", Matchers.equalTo("523698")));
	}
	
	@Test
	public void PositiveViewAllClinicsTest() throws Exception {
		List<Clinic>clinics=new ArrayList();
		Clinic clinic=new Clinic();
		
		clinic.setClinicId(1);
		clinic.setBussinessName("business");
		clinic.setClinicCountry("country");
		clinic.setClinicName("prajnfc");
		clinic.setStreetAddr("streetAddr");
		clinic.setLatitude("latitude");
		clinic.setLongitude("longitude");
		clinic.setZipcode("523698");
		
		Clinic c1=new Clinic();
		c1.setClinicId(2);
		c1.setBussinessName("name");
		c1.setClinicCountry("hj");
		c1.setClinicName("oi");
		c1.setStreetAddr("jx");
		c1.setLatitude("m");
		c1.setLongitude("f");
		c1.setZipcode("236589");
		clinics.add(clinic);
		clinics.add(c1);
		System.out.println(clinics);
		
		String json=mapper.writeValueAsString(clinics);
		
		when(clinicser.getViewAllClinic()).thenReturn(clinics);
		mockmvc.perform(get("/clinics").content(json).contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8")).andExpect(status().isOk())
		.andExpect(jsonPath("$[0].clinicId", Matchers.equalTo(1)))
		.andExpect(jsonPath("$[1].clinicName", Matchers.equalTo("oi")))
		.andExpect(jsonPath("$[0].bussinessName", Matchers.equalTo("business")))
		.andExpect(jsonPath("$[1].streetAddr", Matchers.equalTo("jx")));
	
	}
	@Test
	public void NegativeViewAllClinicsTest() throws Exception {
		List<Clinic>clinics=new ArrayList();
		Clinic clinic=new Clinic();
		
		clinic.setClinicId(1);
		clinic.setBussinessName("business");
		clinic.setClinicCountry("country");
		clinic.setClinicName("prajnfc");
		clinic.setStreetAddr("streetAddr");
		clinic.setLatitude("latitude");
		clinic.setLongitude("longitude");
		clinic.setZipcode("523698");
		
		Clinic c1=new Clinic();
		c1.setClinicId(2);
		c1.setBussinessName("name");
		c1.setClinicCountry("hj");
		c1.setClinicName("oi");
		c1.setStreetAddr("jx");
		c1.setLatitude("m");
		c1.setLongitude("f");
		c1.setZipcode("236589");
		clinics.add(clinic);
		clinics.add(c1);
		System.out.println(clinics);
		
		String json=mapper.writeValueAsString(clinics);
		
		when(clinicser.getViewAllClinic()).thenReturn(clinics);
		mockmvc.perform(get("/clinics").content(json).contentType(MediaType.APPLICATION_JSON)
		.accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8")).andExpect(status().isOk())
		.andExpect(jsonPath("$[0].clinicId", Matchers.not(4)))
		.andExpect(jsonPath("$[1].clinicName", Matchers.equalTo("oi")))
		.andExpect(jsonPath("$[0].bussinessName", Matchers.not("fgh")))
		.andExpect(jsonPath("$[1].streetAddr", Matchers.equalTo("jx")));
	
	}
	
	@Test
    public void PositiveViewServiceForClinicTest() throws Exception{
        Clinic clinic=new Clinic();
        List<ServicesOffered>service=new ArrayList<>();
        ServicesOffered s1=new ServicesOffered();        
        clinic.setClinicId(1);


        s1.setServiceId(2);
        s1.setServiceName("service");
        s1.setServiceCode("345");
        service.add(s1);


        clinic.setService(service);

        System.out.println(clinic);

        String json=mapper.writeValueAsString(clinic);

        when(serviceoff.viewServiceForClinic(clinic.getClinicId())).thenReturn(service);
        mockmvc.perform(get("/clinic/"+clinic.getClinicId()+"/services").content(json).contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8")).andExpect(status().isOk())

        .andExpect(jsonPath("$[0].serviceId", Matchers.equalTo(2)))
        .andExpect(jsonPath("$[0].serviceName", Matchers.equalTo("service")))
        .andExpect(jsonPath("$[0].serviceCode",Matchers.equalTo("345")));

    }
    @Test
    public void NegativeViewServiceForClinicTest() throws Exception{
        Clinic clinic=new Clinic();
        List<ServicesOffered>service=new ArrayList<>();
        ServicesOffered s1=new ServicesOffered();        
        clinic.setClinicId(1);


        s1.setServiceId(2);
        s1.setServiceName("service");
        s1.setServiceCode("345");
        service.add(s1);


        clinic.setService(service);

        System.out.println(clinic);

        String json=mapper.writeValueAsString(clinic);

        when(serviceoff.viewServiceForClinic(clinic.getClinicId())).thenReturn(service);
        mockmvc.perform(get("/clinic/"+clinic.getClinicId()+"/services").content(json).contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON).characterEncoding("utf-8")).andExpect(status().isOk())

        .andExpect(jsonPath("$[0].serviceId", Matchers.not(34)))
        .andExpect(jsonPath("$[0].serviceName", Matchers.equalTo("service")))
        .andExpect(jsonPath("$[0].serviceCode",Matchers.not("34")));

    }
}
