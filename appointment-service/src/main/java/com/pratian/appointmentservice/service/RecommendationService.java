package com.pratian.appointmentservice.service;

import java.util.List;

import com.pratian.appointmentservice.entities.DoctorDetails;
import com.pratian.appointmentservice.entities.Recommendation;
import com.pratian.appointmentservice.exceptions.DoctorNameNotFoundException;



public interface RecommendationService {
	
		Recommendation addRecommendation(Recommendation rec) throws DoctorNameNotFoundException;

		void removeRecommendation(long recommendationId) throws DoctorNameNotFoundException;

		List<Recommendation> getAllRecommendation() throws DoctorNameNotFoundException;

		List<DoctorDetails> getAllDoctors() throws DoctorNameNotFoundException;
	
	}
