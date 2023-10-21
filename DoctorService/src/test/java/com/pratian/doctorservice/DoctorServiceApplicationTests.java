package com.pratian.doctorservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pratian.doctorservice.controller.dto.DoctorDto;
import com.pratian.doctorservice.exception.DoctorAlreadyExistException;
import com.pratian.doctorservice.mapper.DoctorMapper;
import com.pratian.doctorservice.model.Doctor;
import com.pratian.doctorservice.repository.AvailabilityRepository;
import com.pratian.doctorservice.repository.DoctorRepository;
import com.pratian.doctorservice.service.impl.DoctorServiceImpl;


@ExtendWith(MockitoExtension.class)
class DoctorServiceApplicationTests {


	@Mock
	AvailabilityRepository availRepo;
	
	@Mock
	DoctorRepository docRepo;
	
	@Mock
	DoctorMapper mapper;
	
	@InjectMocks
	DoctorServiceImpl docServImpl;
	

	@Test
	void checking_post_doctors() throws DoctorAlreadyExistException
	{
		Doctor doc= new Doctor(1,"lk","rf","sd","string","string","string","string","string","string","string","string","string","string","string");
		when(docRepo.save(doc)).thenReturn(doc);
		when(docRepo.existsById(ArgumentMatchers.anyLong())).thenReturn(false);
		assertEquals(doc, docServImpl.saveDoctorInfo(doc));
		
	}
	
	@Test
	void checking_Post_Doctors_Throws_Exception() throws DoctorAlreadyExistException
	{
		Doctor doc= new Doctor(1,"lk","rf","sd","string","string","string","string","string","string","string","string","string","string","string");
		when(docRepo.existsById(ArgumentMatchers.anyLong())).thenReturn(true);
		assertThrows(DoctorAlreadyExistException.class, ()-> docServImpl.saveDoctorInfo(doc));
	}
	
	@Test
	void checking_Update_Doctor_Id() throws DoctorAlreadyExistException
	{
		Doctor doct= new Doctor(1,"gf","rf","sd","string","fgh","fh","string","fh","string","string","string","string","string","string");
		when(docRepo.save(doct)).thenReturn(doct);
		assertEquals(doct, docServImpl.saveDoctorInfo(doct));
	}
	


	   
	   @Test
	   public void get_all_DoctorDtos_Test()
	   {
		   List<DoctorDto> docs = new ArrayList<>();
		   Doctor doc= new Doctor(1,"lk","rf","sd","string","string","string","string","string","string","string","string","string","string","string");
		   DoctorDto docDto = mapper.convertToDto(doc);
		   docs.add(docDto);
		   when(docRepo.findAll()).thenReturn(Stream.of(new Doctor( )).collect(Collectors.toList()));
		   assertEquals(docs, docServImpl.getAllDoctors() );
	   }
	
	   @Test
	   public void searchDoctors_Speciality_Test() {
		   List<DoctorDto> docDtos = new ArrayList<>();
		   Doctor doc= new Doctor(1,"lk","rf","sd","string","string","string","string","string","string","string","string","string","string","string");
		   DoctorDto docDto = mapper.convertToDto(doc);
		   docDtos.add(docDto);
		   //when(docRepo.findBySpeciality("speciality")).thenReturn(Stream.of(new Doctor()).collect(Collectors.toList()));
		   when(docServImpl.getDoctorBySpeciality("string")).thenReturn(docDtos);
		   assertEquals(docDtos,docServImpl.getDoctorBySpeciality("string"));
	   }
	
	
}
