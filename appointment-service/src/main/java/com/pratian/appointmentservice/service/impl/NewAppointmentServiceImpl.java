package com.pratian.appointmentservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratian.appointmentservice.entities.NewAppointment;
import com.pratian.appointmentservice.repository.NewIAppointmentRepo;
import com.pratian.appointmentservice.service.NewIAppointmentService;

@Service
public class NewAppointmentServiceImpl implements NewIAppointmentService {
	@Autowired
	private NewIAppointmentRepo appointmentRepo;

	@Override
	public NewAppointment AddAppointment(NewAppointment appointment) {
		
		return appointmentRepo.save(appointment);
	}

	@Override
	public List<NewAppointment> getAppointmentAll() {

		return appointmentRepo.getAppointmentAll();
	}

	@Override
	public NewAppointment getAppointmentById(long id) {
		
		return appointmentRepo.getAppointmentById(id);
	}

}
