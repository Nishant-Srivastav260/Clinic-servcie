package com.pratian.appointmentservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratian.appointmentservice.entities.Appointment;
import com.pratian.appointmentservice.entities.Prescriptions;
import com.pratian.appointmentservice.exceptions.AppointmentNotFoundException;
import com.pratian.appointmentservice.exceptions.PrescriptionServiceException;
import com.pratian.appointmentservice.repository.IAppointmentRepo;
import com.pratian.appointmentservice.repository.IPrescriptionRepo;
import com.pratian.appointmentservice.service.IPrescriptionService;



@Service
public class PrescriptionServiceIml implements IPrescriptionService {
	@Autowired
	IPrescriptionRepo iPrescriptionRepo;
	@Autowired
	IAppointmentRepo iApprepo;
	
	// method for add Prescriptions
	@Override
	public Prescriptions addPrescription(Prescriptions pre, long id) throws AppointmentNotFoundException {
		
		if(!iApprepo.existsById(id)) {
			throw new AppointmentNotFoundException();
		}
		else {
			Appointment oldAppointment = iApprepo.getAppointmentById(id);
			if(iPrescriptionRepo.existsById(pre.getPrescriptionId())) {
				oldAppointment.getPrescriptions().add(iPrescriptionRepo.getByPrescriptionId(pre.getPrescriptionId()));
				return pre;
			}
			else {
				iPrescriptionRepo.save(pre);
				oldAppointment.getPrescriptions().add(pre);			
                iApprepo.save(oldAppointment);	
                return pre;
				
			}
			}}

	// getOne Prescriptions by PrescriptionsId

	@Override
	public Prescriptions getOnePrescriprion(long id) throws PrescriptionServiceException {
         if(iPrescriptionRepo.existsById(id))
		return iPrescriptionRepo.getByPrescriptionId(id);
         else {
        	 throw new PrescriptionServiceException();
         }
				
				
	}

	// method for delete Prescriptions

	@Override
	public void deletePrescription(long prescriptionId) throws PrescriptionServiceException {

		if (iPrescriptionRepo.existsById(prescriptionId))
			iPrescriptionRepo.deleteById(prescriptionId);
		else
			throw new PrescriptionServiceException();

	}

	// method for edit Prescriptions
	@Override
	public Prescriptions editPrescription(long id, Prescriptions pre) throws PrescriptionServiceException {

	//	Prescriptions oldPre = iPrescriptionRepo.findById(id).orElseThrow(() -> new PrescriptionServiceException());
		if(!iPrescriptionRepo.existsById(id)) {
			throw new PrescriptionServiceException();
		}
		else { 
			Prescriptions oldPre = iPrescriptionRepo.getByPrescriptionId(id);
		oldPre.setDescription(pre.getDescription());
		oldPre.setDuration(pre.getDuration());
		oldPre.setMedicineCycle(pre.getMedicineCycle());
		oldPre.setMedicineName(pre.getMedicineName());
		oldPre.setTake_With_Food(pre.isTake_With_Food());

		return iPrescriptionRepo.save(oldPre);
	}}
	
	// getAll Prescriptions by AppointmentId
	@Override
	public List<Prescriptions> viewPrescriptionbyAppointmentId(long id) throws PrescriptionServiceException, AppointmentNotFoundException {
		if(iApprepo.existsById(id)) {
		Appointment oldAppointment = iApprepo.getAppointmentById(id);
		List<Prescriptions> preList=oldAppointment.getPrescriptions();
		if(preList.size()==0) {
			throw new PrescriptionServiceException();
		}
		return oldAppointment.getPrescriptions();
	}
	else {
		throw new AppointmentNotFoundException();
	}}


}
