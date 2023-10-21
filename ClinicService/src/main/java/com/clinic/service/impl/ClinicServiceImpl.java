package com.clinic.service.impl;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clinic.exception.CityNotFoundException;
import com.clinic.exception.ClinicAlreadyExitsException;
import com.clinic.exception.ClinicNotFoundException;
import com.clinic.exception.DoctorAlreadyExistException;
import com.clinic.exception.DoctorNotFoundException;
import com.clinic.model.Clinic;
import com.clinic.model.Doctor;
import com.clinic.model.ServicesOffered;
import com.clinic.pojo.ClinicRequest;
import com.clinic.pojo.DoctorRequest;
import com.clinic.repository.CityRepository;
import com.clinic.repository.ClinicRepository;
import com.clinic.repository.DoctorRepository;
import com.clinic.service.ClinicService;

@Service
public class ClinicServiceImpl implements ClinicService{

	
	@Autowired
	ClinicRepository clinicRepo;
	
	@Autowired
	CityRepository cityRepo;
	
	@Autowired
	DoctorRepository doctorRepo;
	 
	


	public Clinic addClinic(ClinicRequest clinicReq) throws ClinicAlreadyExitsException {
		Clinic clinic =new Clinic();
		clinic.setClinicId(clinicReq.getClinicId());
		clinic.setClinicName(clinicReq.getClinicName());
		clinic.setBussinessName(clinicReq.getBussinessName());
		clinic.setClinicCountry(clinicReq.getClinicCountry());
		clinic.setStreetAddr(clinicReq.getStreetAddr());
		clinic.setDateCreated(clinicReq.getDateCreated());
		clinic.setZipcode(clinicReq.getZipcode());
		clinic.setLatitude(clinicReq.getLatitude());
		clinic.setLongitude(clinicReq.getLongitude());
	
		if(clinicRepo.existsById(clinicReq.getClinicId())) {
			throw new ClinicAlreadyExitsException();
		}
		return clinicRepo.save(clinic);
	}


	@Override
	public Clinic addClinicToCity(long cityId, ClinicRequest clinicReq) throws CityNotFoundException{
		
		if(!cityRepo.existsById(cityId)) {
			
			throw new CityNotFoundException();

			}else 
			{
				List<Clinic> cl=cityRepo.getCityById(cityId).getClinic();
				//cityrepo.getCityById(cityId).getClinic();
				Clinic c=new Clinic();
				c.setClinicId(clinicReq.getClinicId());
				c.setClinicName(clinicReq.getClinicName());
				c.setBussinessName(clinicReq.getBussinessName());
				c.setClinicCountry(clinicReq.getClinicCountry());
				c.setStreetAddr(clinicReq.getStreetAddr());
				c.setDateCreated(clinicReq.getDateCreated());
				c.setLatitude(clinicReq.getLatitude());
				c.setLongitude(clinicReq.getLongitude());
				c.setZipcode(clinicReq.getZipcode());
				cl.add(c);
				clinicRepo.save(c);
				return c;
			}
	}


	@Override
		public Clinic editClinicDetails(Clinic clinic) throws ClinicNotFoundException {
			if(clinicRepo.existsById(clinic.getClinicId())) {
				Clinic c = new Clinic();
				c=clinicRepo.getClinicObject(clinic.getClinicId());
				c.setClinicName(clinic.getClinicName());
				c.setBussinessName(clinic.getBussinessName());
				c.setStreetAddr(clinic.getStreetAddr());
				c.setClinicCountry(clinic.getClinicCountry());
				c.setDateCreated(clinic.getDateCreated());
				c.setLongitude(clinic.getLongitude());
				c.setLatitude(clinic.getLatitude());
				c.setZipcode(clinic.getZipcode());
				clinicRepo.save(c);
				return c;
				}
		else {
			throw new ClinicNotFoundException();
		}
	}

	
		@Override
		public String deleteClinic(long clinicId) throws ClinicNotFoundException {
			if(clinicRepo.existsById(clinicId)) {
					clinicRepo.deleteById(clinicId);
				}else {
					throw new ClinicNotFoundException();
				}
			return "Deleted successfully";
		}
		
		public List<Clinic> getViewAllClinic() throws ClinicNotFoundException {

	        List<Clinic> clinics = clinicRepo.getViewAllClinic();
	        if(clinics.isEmpty()) {
	            throw new ClinicNotFoundException();
	        }
	        return clinics;
	    }


		@Override
		public Doctor addDoctorsToClinic(DoctorRequest doctor, long clinicId) throws DoctorAlreadyExistException, ClinicAlreadyExitsException, DoctorNotFoundException {
			if(clinicRepo.existsById(clinicId)) {				
				Clinic clinic=clinicRepo.getClinicObject(clinicId);
				Doctor doc=new Doctor();
				doc.setName(doctor.getUsername());
				doc.setTitle(doctor.getTitle());
				doc.setNpi_no(doctor.getNpi_no());
				doc.setSpeciality(doctor.getSpeciality());
				doc.setPhone_no(doctor.getPhone_no());
				doc.setGender(doctor.getGender());
				doc.setEmail(doctor.getEmail());
				doc.setPractice_location(doctor.getPractice_location());
				doctorRepo.save(doc);
				clinic.getDoctor().add(doc);
				doc.getClinic().add(clinic);
				clinicRepo.save(clinic);
				doctorRepo.save(doc);
				return doc;
			}else {
				throw new ClinicNotFoundException();
			}
		}
		
		@Override
        public Clinic getClinicById(long clinicId) throws ClinicNotFoundException {
            Clinic clini = null;
            if(clinicRepo.existsById(clinicId)) {
                clini = clinicRepo.getClinicObject(clinicId);
            }
            else{
                throw new ClinicNotFoundException();
            }
            return clini;
        }
		
		
}
