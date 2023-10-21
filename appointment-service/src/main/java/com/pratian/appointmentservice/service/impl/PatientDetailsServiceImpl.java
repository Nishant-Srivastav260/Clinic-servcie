package com.pratian.appointmentservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratian.appointmentservice.entities.Appointment;
import com.pratian.appointmentservice.entities.PatientDetails;
import com.pratian.appointmentservice.repository.IAppointmentRepo;

import com.pratian.appointmentservice.service.PatientDetailsService;

@Service
public class PatientDetailsServiceImpl implements PatientDetailsService {


	@Autowired
	IAppointmentRepo appointmentRepository;


	@Override
	public Appointment addAppointmentToPatientId(PatientDetails p, Appointment appointment) {
//		if(appointmentRepository.existsById(appId)) {
//		appointmentRepository.getAppointmentById(appId).setPatientId(p.getPatientId());;
//			return appointmentRepository.findById(appId).get();
//		}
//		else {
	    	appointment.setPatientId(p.getPatientId());
			appointmentRepository.save(appointment);
			//appointment.setPatientId(p.getPatientId());
			return appointment;
		}
	
	
	@Override
	public List<Appointment> getAppointmentsForPatientId(long patId) {
		
		return appointmentRepository.getAppointmentByPatientId(patId);
	}
	
	
	@Override
	public long getPatientIdByAppointmentId(long appId) {
		return appointmentRepository.getAppointmentById(appId).getPatientId();
	}
	}


