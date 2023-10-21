package com.clinic.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.exception.ClinicAlreadyExitsException;
import com.clinic.exception.ClinicNotFoundException;
import com.clinic.exception.ServiceAlreadyPresentException;
import com.clinic.exception.ServiceNotFoundException;
import com.clinic.model.Clinic;
import com.clinic.model.ServicesOffered;
import com.clinic.pojo.ServicesRequest;
import com.clinic.repository.ClinicRepository;
import com.clinic.repository.ServicesRepository;
import com.clinic.service.ServicesOfferedService;


@Service
public class ServicesOfferedServiceImpl implements ServicesOfferedService{
	
	@Autowired
	ServicesRepository serviceRepo;

	@Autowired
	ClinicRepository  clinicRepo;

	@Override
	public ServicesOffered addService(ServicesRequest servR) throws ServiceAlreadyPresentException {
		ServicesOffered serviceOff=new ServicesOffered();


		serviceOff.setServiceId(servR.getServiceId());
		serviceOff.setServiceName(servR.getServiceName());
		serviceOff.setServiceCode(servR.getServiceCode());
		serviceOff.setServiceDesc(servR.getServiceDesc());
		serviceOff.setAvgPrice(servR.getAvgPrice());
		serviceOff.setActive(servR.isActive());


		if(serviceRepo.existsById(servR.getServiceId())) {
			throw new ServiceAlreadyPresentException();
		}
		else {
			serviceOff= serviceRepo.save(serviceOff);

			return serviceOff;
		}

	}

	@Override
	public ServicesOffered addServicesToClinics(long clinicId, long serviceId) throws ClinicAlreadyExitsException,
			ServiceAlreadyPresentException, ClinicNotFoundException, ServiceNotFoundException {
		boolean s=serviceRepo.existsById(serviceId);
		boolean c=clinicRepo.existsById(clinicId);

		if(s && c) {

			Clinic clinic=clinicRepo.getClinicObject(clinicId);
			ServicesOffered service=serviceRepo.getServiceObject(serviceId);
			if(clinic.getService().contains(service)) {
				throw new ServiceAlreadyPresentException("Service Already Present");
			}
			else if(service.getClinic().contains(clinic)){
				throw new ClinicAlreadyExitsException("Clinic Already Present");
			}
			else {
				clinic.getService().add(service);
				service.getClinic().add(clinic);
				clinicRepo.save(clinic);
				serviceRepo.save(service);

				return service;
			}
		}
		else if(!s){
			throw new ServiceNotFoundException("Service Not Found");
		}
		else {
			throw new ClinicNotFoundException("Clinic Not Found");
		}
	}
	
	
	@Override
	public List<ServicesOffered> viewServiceForClinic(long clinicId) throws ClinicNotFoundException {
		List<ServicesOffered> ser=null;
		if(clinicRepo.existsById(clinicId)) {
			ser=clinicRepo.getClinicObject(clinicId).getService();
		}
		else
		{
			throw new ClinicNotFoundException();
		}
		return ser;
	}
	
	@Override
    public ServicesOffered getServiceById(long serviceId) {
        ServicesOffered service = serviceRepo.getServiceObject(serviceId);
        return service;
    }

}
