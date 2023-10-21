package com.clinic.service;

import java.util.List;

import com.clinic.model.Clinic;
import com.clinic.model.ClinicAvailability;
import com.clinic.model.Status;
import com.clinic.model.Week;

public interface ClinicAvalabilityService {
		
	public ClinicAvailability setClinicAvailability(long id,Week week,Status status);
	
	public List<Clinic> getClinicAvailability(Week week);
	
}
