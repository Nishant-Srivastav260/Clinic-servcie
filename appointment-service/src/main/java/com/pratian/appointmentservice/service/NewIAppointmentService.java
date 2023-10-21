package com.pratian.appointmentservice.service;

import java.util.List;

import com.pratian.appointmentservice.entities.NewAppointment;

public interface NewIAppointmentService {
	
	public NewAppointment AddAppointment(NewAppointment appointment) ;
	public List<NewAppointment> getAppointmentAll();
	public NewAppointment getAppointmentById(long id);
	

}

