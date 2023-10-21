package com.pratian.doctorservice.service;

import org.springframework.stereotype.Service;

import com.pratian.doctorservice.exception.DoctorNotFoundException;
import com.pratian.doctorservice.model.Availability;
import com.pratian.doctorservice.model.AvailabilityStatus;
import com.pratian.doctorservice.model.Day;


@Service
public interface AvailabilityService {

	public Availability setDoctorAvailability(long id, Day day, AvailabilityStatus status) throws DoctorNotFoundException;
	public Availability getDoctorAvailability(long id);
	Availability getDoctorAvailability(long id, Day day);
}
