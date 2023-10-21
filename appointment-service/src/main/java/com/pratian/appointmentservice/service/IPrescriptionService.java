package com.pratian.appointmentservice.service;

import java.util.List;

import com.pratian.appointmentservice.entities.Prescriptions;
import com.pratian.appointmentservice.exceptions.AppointmentNotFoundException;
import com.pratian.appointmentservice.exceptions.PrescriptionServiceException;


public interface IPrescriptionService {
	

	
	Prescriptions editPrescription(long id, Prescriptions pre) throws PrescriptionServiceException;	
	
	void deletePrescription(long prescriptionId) throws PrescriptionServiceException;	
	
	Prescriptions getOnePrescriprion(long id) throws PrescriptionServiceException;
	
	Prescriptions addPrescription(Prescriptions pre, long id) throws AppointmentNotFoundException;
	
	List<Prescriptions> viewPrescriptionbyAppointmentId(long id) throws PrescriptionServiceException, AppointmentNotFoundException;
	
			

	
}
