package com.pratian.appointmentservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pratian.appointmentservice.entities.DoctorDetails;
import com.pratian.appointmentservice.entities.Recommendation;
import com.pratian.appointmentservice.exceptions.DoctorNameNotFoundException;
import com.pratian.appointmentservice.repository.DoctorDetailsRepository;
import com.pratian.appointmentservice.repository.RecommendationRepository;
import com.pratian.appointmentservice.service.RecommendationService;

@Service
public class RecommendationServiceImpl implements RecommendationService {

	@Autowired
	RecommendationRepository rRepo;
	
	@Autowired
	DoctorDetailsRepository dRepo;
	
	
	@Override
	public Recommendation addRecommendation(Recommendation rec) throws DoctorNameNotFoundException {
		/*
		 * boolean status; List<Recommendation> lst=new ArrayList<Recommendation>();
		 * lst=repo.findAll(); status=lst.stream().filter(
		 * obj->obj.getDoctor().getName().equals(rec.getDoctor().getName())).findFirst()
		 * .isPresent(); if(status) {
		 * 
		 * throw new DoctorNameNotFoundException("Doctor name Already exits"); } else {
		 */
			rRepo.save(rec);
			return rec;
		//}
	}

	@Override
	public void removeRecommendation(long recommendationId) throws DoctorNameNotFoundException {
//		if(rRepo.existsById(recommendationId)) {
		rRepo.deleteById(recommendationId);
//		}else {
//			throw new DoctorNameNotFoundException("Recommendation Id not found ");
//		}

	}

	@Override
	public List<Recommendation> getAllRecommendation() throws DoctorNameNotFoundException {
//		if(rRepo.findAll()==null) {
//			throw new DoctorNameNotFoundException("Data not found");
//		}
//		else
		return rRepo.findAll();
	}

	@Override
	public List<DoctorDetails> getAllDoctors() throws DoctorNameNotFoundException{
		
		List<DoctorDetails> drList = dRepo.findAll();
//		if(dRepo.findAll()==null) {
//			throw new DoctorNameNotFoundException("No Doctors");
//		}
//		//return drList;
		return drList;
	}

	
}

	

