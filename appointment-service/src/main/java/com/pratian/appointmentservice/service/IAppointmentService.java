package com.pratian.appointmentservice.service;

import java.util.List;

import com.pratian.appointmentservice.entities.Appointment;
import com.pratian.appointmentservice.entities.Recommendation;
import com.pratian.appointmentservice.entities.Test;
import com.pratian.appointmentservice.entities.Vitals;
import com.pratian.appointmentservice.exceptions.AppointmentAlreadyExistsException;
import com.pratian.appointmentservice.exceptions.AppointmentNotFoundException;
import com.pratian.appointmentservice.exceptions.VitalsNotFoundException;

public interface IAppointmentService {
	//public Appointment addAppointment(Appointment appointment) throws AppointmentNotFoundException;
	public Appointment addAppointment(Appointment appointment) throws AppointmentAlreadyExistsException;
	
	public List<Appointment> getAllAppointments()throws AppointmentNotFoundException;

	public Appointment getAppointmentById(long id)throws AppointmentNotFoundException;


	//public Appointment updateAppointment(Test test[], long id) throws AppointmentNotFoundException;

	public void deleteTestsfoAppointment(long id, long testId) throws AppointmentNotFoundException;

	public List<Test> getTestsForAppointment(long id) throws AppointmentNotFoundException;

	Appointment updateRecommendationAppo(Recommendation rec[], long id) throws AppointmentNotFoundException;  ///dinesh

	void deleteRecommendationAppointment(long id, long recommendationId) throws AppointmentNotFoundException;

	public Vitals getVitalsbyAppoinmentId(long id) throws AppointmentNotFoundException;

	public Vitals editVitals(Vitals vital, long vitalsId) throws VitalsNotFoundException, AppointmentNotFoundException;

	public Appointment getAllAppointment(long appointmnetId) throws AppointmentNotFoundException;

	//public List<Appointment> getallAppointments();
	
	
	
	public int getAcceptedAppointments();

	public int getCancelledAppointments();

	public int gettotalAppointments();

	public List<Appointment> getfilterconfirmedAppointments() throws AppointmentNotFoundException;

	public List<Appointment> getfiltercancelledAppointments() throws AppointmentNotFoundException;

	public List<Appointment> getfilterclosedAppointments() throws AppointmentNotFoundException;

	List<Appointment> findAll();

	public Appointment updateAppointmnet(long id, String status);

	//public void cancelAppointment(long id);

	//public List<Appointment> getpendingAppointments();
	public void deleteAppointment(long id)throws AppointmentNotFoundException;
	public List<Appointment> getpendingAppointments()throws AppointmentNotFoundException;
	

}
