package com.pratian.doctorservice.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.pratian.doctorservice.controller.dto.DoctorDto;
import com.pratian.doctorservice.exception.DoctorAlreadyExistException;
import com.pratian.doctorservice.exception.DoctorNotFoundException;
import com.pratian.doctorservice.model.Appointment;
import com.pratian.doctorservice.model.Availability;
import com.pratian.doctorservice.model.Day;
import com.pratian.doctorservice.model.Doctor;
import com.pratian.doctorservice.model.Patient;

@Service
public interface DoctorService {
	
	public Doctor getDoctorInfo(long id) throws DoctorNotFoundException;
	public Doctor saveDoctorInfo(Doctor doctor) throws DoctorAlreadyExistException;
	public Doctor editDoctor(Doctor doctor) throws DoctorNotFoundException;
	public DoctorDto getDoctorDtoById(long id) throws DoctorNotFoundException;
	public List<DoctorDto> getAllDoctors() throws DoctorNotFoundException;
	public List<Patient> getPatientForDoctor(long id);
	public List<Appointment> getAppointmentForDoctor(long id);
	public Doctor addDoctorProfilePicture(long id, String profile_picture) throws DoctorNotFoundException;
	public Doctor deleteDoctorProfilePicture(long id) throws DoctorNotFoundException;
	List<DoctorDto> getDoctorBySpeciality(String speciality) throws DoctorNotFoundException;
	Availability getDoctorAvailability(long id, Day day);
}
