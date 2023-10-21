package com.pratian.appointmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pratian.appointmentservice.entities.Recommendation;
@Repository
public interface RecommendationRepository  extends JpaRepository<Recommendation,Long>{
	
	
}
