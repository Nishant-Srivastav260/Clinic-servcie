package com.pratian.appointmentservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratian.appointmentservice.entities.DoctorDetails;
import com.pratian.appointmentservice.repository.DoctorDetailsRepository;
import com.pratian.appointmentservice.repository.IAppointmentRepo;
import com.pratian.appointmentservice.service.DoctorDetailsService;

@Service
public class DoctorDetailsServiceImpl implements DoctorDetailsService {

	@Autowired
	DoctorDetailsRepository doctordetailsrepository;
	@Autowired
	IAppointmentRepo appointmentrepository;
	@Override
	public DoctorDetails getDoctorDetails(long id) {
		return appointmentrepository.getAppointmentById(id).getDoctordetails();
//		return doctordetailsrepository.getDoctorDetailsById(id);
	}
	
	
	
}
