package com.clinic.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.exception.ClinicNotFoundException;
import com.clinic.model.Clinic;
import com.clinic.model.ClinicAvailability;
import com.clinic.model.Status;
import com.clinic.model.Week;
import com.clinic.repository.ClinicAvailabilityRepository;
import com.clinic.repository.ClinicRepository;
import com.clinic.service.ClinicAvalabilityService;

@Service
public class ClinicAvalabilityServiceImpl implements ClinicAvalabilityService{

	@Autowired
	ClinicRepository clinicRepo;
	
	@Autowired
	ClinicAvailabilityRepository clinicAvailRepo;
	
	@Override
	public ClinicAvailability setClinicAvailability(long id, Week week, Status status) throws ClinicNotFoundException{
		if(clinicRepo.existsById(id)) {
			ClinicAvailability ca=new ClinicAvailability();
			ca.setWeek(week);
			ca.setStatus(status);
			ca.setClinic(clinicRepo.getClinicObject(id));
			clinicAvailRepo.save(ca);
			return ca;
		}
		else {
			throw new ClinicNotFoundException();
		}
	}

	@Override
	public List<Clinic> getClinicAvailability(Week week) {
		List<ClinicAvailability> ca=clinicAvailRepo.getClinicByDay(week);
		List<Clinic> cli=new ArrayList<>();		
		for(ClinicAvailability c:ca) {
			if(c.getStatus()!=Status.Closed) {
				cli.add(c.getClinic());				
			}
		}
		return cli;
	}


}
