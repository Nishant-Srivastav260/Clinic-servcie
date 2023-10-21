package com.pratian.appointmentservice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratian.appointmentservice.entities.Appointment;
import com.pratian.appointmentservice.entities.Vitals;
import com.pratian.appointmentservice.exceptions.AppointmentNotFoundException;
import com.pratian.appointmentservice.exceptions.VitalAlreadyPresentException;
import com.pratian.appointmentservice.exceptions.VitalsNotFoundException;
import com.pratian.appointmentservice.repository.IAppointmentRepo;
import com.pratian.appointmentservice.repository.VitalsRepo;
import com.pratian.appointmentservice.service.VitalsService;

@Service
public class VitalsServiceImpl implements VitalsService {

	@Autowired
	private VitalsRepo vitalsrepo;

	@Autowired
	IAppointmentRepo appointmentrepo;

	public VitalsServiceImpl() {

	}

	//Get All Vitals
	@Override
	public List<Vitals> getVitals() throws VitalsNotFoundException {
      List<Vitals> list=new ArrayList<Vitals>();
      list=vitalsrepo.findAll();
      if(list.size()>0) {
    	  return list;
      }
      else {
    	  throw new VitalsNotFoundException();
      }
		}

	// get Vitals by vital id
	@Override
	public Vitals getVitalsById(long vitalsId) throws VitalsNotFoundException {
		if (vitalsrepo.existsById(vitalsId)) {
			return vitalsrepo.findByvitalId(vitalsId);

		} else {
			throw new VitalsNotFoundException();
		}

	}

	// save Vitals or add vitals by vital id
	@Override
	public Vitals saveVital(Vitals vital) throws VitalAlreadyPresentException{

		if (vitalsrepo.existsById(vital.getId())) {
			throw new VitalAlreadyPresentException();
		}

		else {
			return vitalsrepo.save(vital);
		}
	}

	// update vitals by id by vital id
	@Override
	public Vitals updateVital(long vitalsId, Vitals vital) throws VitalsNotFoundException {

		if (vitalsrepo.existsById(vitalsId)) {
			Vitals v = vitalsrepo.findByvitalId(vitalsId);
			v.setECG(vital.getECG());
			v.setDiabetes(vital.getDiabetes());
			v.setTemperature(vital.getTemperature());
			v.setRespiration_rate(vital.getRespiration_rate());
			vitalsrepo.save(v);
			return vital;
		} else {

			throw new VitalsNotFoundException();
		}
	}

	@Override
	public Vitals addVitalsToAppointmentId(long id, Vitals vital) throws AppointmentNotFoundException {
		if(!appointmentrepo.existsById(id)) {
			throw new AppointmentNotFoundException();
		}
		else {
			Appointment a=appointmentrepo.getAppointmentById(id);
			
			if(vitalsrepo.existsById(vital.getId())) {
				a.setVitals(vitalsrepo.findByvitalId(vital.getId()));
				return vital;
			}
			else {
				Vitals vital1 = vitalsrepo.save(vital);
				a.setVitals(vital1);
				 appointmentrepo.save(a);
				return vital;
			
	}
	}}
}
