package com.clinic.service;

import java.util.List;

import javax.management.ServiceNotFoundException;

import com.clinic.exception.ClinicAlreadyExitsException;
import com.clinic.exception.ClinicNotFoundException;
import com.clinic.exception.ServiceAlreadyPresentException;
import com.clinic.model.ServicesOffered;
import com.clinic.pojo.ServicesRequest;

public interface ServicesOfferedService {

	public ServicesOffered addService(ServicesRequest servR) throws ServiceAlreadyPresentException;

	public ServicesOffered addServicesToClinics(long clinicId,long serviceId) throws ClinicAlreadyExitsException,ServiceAlreadyPresentException,ClinicNotFoundException,ServiceNotFoundException ;
	
	public List<ServicesOffered> viewServiceForClinic(long clinicId) throws ClinicNotFoundException;

	public ServicesOffered getServiceById(long serviceId);
	
	
}
