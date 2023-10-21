package com.pratian.doctorservice;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.pratian.doctorservice.controller.dto.DoctorDto;
import com.pratian.doctorservice.model.Doctor;
import com.pratian.doctorservice.service.AvailabilityService;
import com.pratian.doctorservice.service.DoctorService;

@ExtendWith(MockitoExtension.class)
@WebMvcTest
public class DoctorControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	DoctorService mockDoctorService;
	
	@MockBean
	AvailabilityService availService;
	
	
	
	@Test
	void put_DoctorsId() throws Exception
	{
		Doctor doctor =new Doctor();
		doctor.setId(1);
		doctor.setTitle("data");
		doctor.setName("adfa");
		doctor.setEmail("acd");
		doctor.setPhone_no("dacd");
		doctor.setSpeciality("cdcd");
		doctor.setNpi_no("faaaaa");
		doctor.setPractice_location("dv ad");
		doctor.setGender("adva");
		doctor.setBlood_group("adv");
		doctor.setDob("dcd");
		doctor.setUsername("avda");
		doctor.setPassword("scer");
		doctor.setProfile_picture("vqae");
		doctor.setRole("sfv");
		
		Mockito.when(mockDoctorService.getDoctorInfo(1)).thenReturn(doctor);
		mockMvc.perform(MockMvcRequestBuilders.get("/doctors/{id}",1)).andExpect(MockMvcResultMatchers.status().isOk());
	
	}
	
	@Test
	void post_Doctor() throws Exception
	{
		Doctor doctor = new Doctor();
		doctor.setId(2);
		doctor.setTitle("cfa");
		doctor.setEmail("acd");
		doctor.setPhone_no("dacd");
		doctor.setSpeciality("cdcd");
		doctor.setNpi_no("faaaaa");
		doctor.setPractice_location("dv ad");
		doctor.setGender("adva");
		doctor.setBlood_group("adv");
		doctor.setDob("dcd");
		doctor.setUsername("avda");
		doctor.setPassword("scer");
		doctor.setProfile_picture("vqae");
		doctor.setRole("sfv");
		
		
		Mockito.when(mockDoctorService.getDoctorInfo(2)).thenReturn(doctor);
		mockMvc.perform(MockMvcRequestBuilders.get("/doctors",2)).andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	void get_Doctor_speciality() throws Exception
	{
		List<DoctorDto> doctor = new ArrayList<>();
		DoctorDto doc = new DoctorDto();
		 doc.setId(2);
         doc.setName("adfa");
         doc.setPhone_no("dacd");
         doc.setSpeciality("cdcd");
         doctor.add(doc);
         Mockito.when(mockDoctorService.getDoctorBySpeciality("cdcd")).thenReturn(doctor);
         mockMvc.perform(MockMvcRequestBuilders.get("/speciality/{speciality}","cdcd")).andExpect(MockMvcResultMatchers.status().isOk());

	}
	
	@Test
	void get_Doctor_Dtoby_id() throws Exception {
        DoctorDto doctor =new DoctorDto();
        doctor.setId(1);
        doctor.setName("adfa");
        doctor.setPhone_no("dacd");
        doctor.setSpeciality("cdcd");
        Mockito.when(mockDoctorService.getDoctorDtoById(1L)).thenReturn(doctor);
        mockMvc.perform(MockMvcRequestBuilders.get("/doctor/{id}",1)).andExpect(MockMvcResultMatchers.status().isOk());

   }
	
	@Test
    void get_All_Doctors() throws Exception {
        java.util.List<DoctorDto> doc=new ArrayList<DoctorDto>();
         DoctorDto doctor =new DoctorDto();
         doctor.setId(1);
         doctor.setName("adfa");
         doctor.setPhone_no("dacd");
         doctor.setSpeciality("cdcd");
         doc.add(doctor);
         Mockito.when(mockDoctorService.getAllDoctors()).thenReturn(doc);
         mockMvc.perform(MockMvcRequestBuilders.get("/doctors")).andExpect(MockMvcResultMatchers.status().isOk());
    }
	

}
