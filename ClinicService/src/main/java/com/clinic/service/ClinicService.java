package com.clinic.service;

import java.util.List;

import com.clinic.exception.CityNotFoundException;
import com.clinic.exception.ClinicAlreadyExitsException;
import com.clinic.exception.ClinicNotFoundException;
import com.clinic.exception.DoctorAlreadyExistException;
import com.clinic.exception.DoctorNotFoundException;
import com.clinic.model.Clinic;
import com.clinic.model.Doctor;
import com.clinic.pojo.ClinicRequest;
import com.clinic.pojo.DoctorRequest;

public interface ClinicService {


	
	public Clinic addClinic(ClinicRequest clinicReq) throws ClinicAlreadyExitsException;

	public Clinic addClinicToCity(long cityId, ClinicRequest clinicReq) throws CityNotFoundException;

	public Clinic editClinicDetails(Clinic clinic)throws ClinicNotFoundException;

	public String deleteClinic(long clinicId) throws ClinicNotFoundException;
	
	public List<Clinic> getViewAllClinic() throws ClinicNotFoundException;
	
	public Doctor addDoctorsToClinic(DoctorRequest doctor,long clinicId) throws DoctorAlreadyExistException, ClinicAlreadyExitsException, DoctorNotFoundException;

	public Clinic getClinicById(long clinicId);
}
