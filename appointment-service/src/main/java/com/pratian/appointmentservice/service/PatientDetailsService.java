package com.pratian.appointmentservice.service;

import java.util.List;

import com.pratian.appointmentservice.entities.Appointment;
import com.pratian.appointmentservice.entities.PatientDetails;

public interface PatientDetailsService {
	//public PatientDetails getPatientDetails(long id);

	public Appointment addAppointmentToPatientId(PatientDetails p, Appointment appointment);

	public List<Appointment> getAppointmentsForPatientId(long patId);

	public long getPatientIdByAppointmentId(long appId);
}