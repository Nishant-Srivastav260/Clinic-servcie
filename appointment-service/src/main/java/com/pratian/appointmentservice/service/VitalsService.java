package com.pratian.appointmentservice.service;

import java.util.List;

import com.pratian.appointmentservice.entities.Vitals;
import com.pratian.appointmentservice.exceptions.AppointmentNotFoundException;
import com.pratian.appointmentservice.exceptions.VitalAlreadyPresentException;
import com.pratian.appointmentservice.exceptions.VitalsNotFoundException;

public interface VitalsService {

	public List<Vitals>getVitals() throws VitalsNotFoundException;

	public Vitals getVitalsById(long vitalsId) throws VitalsNotFoundException;
	public Vitals saveVital(Vitals vital) throws VitalAlreadyPresentException;
	//public Vitals updateVital(Vitals vital);
	public Vitals updateVital( long vitalsID ,Vitals vital) throws VitalsNotFoundException;

	public Vitals addVitalsToAppointmentId(long id,Vitals vital) throws AppointmentNotFoundException;




}
