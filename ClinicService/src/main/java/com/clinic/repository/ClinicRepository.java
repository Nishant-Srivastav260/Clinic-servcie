package com.clinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.clinic.model.Clinic;

public interface ClinicRepository extends JpaRepository<Clinic, Long>{
	
	
	@Query(value="select c from Clinic c where c.clinicId= :clinicId")
	public Clinic getClinicObject(@Param("clinicId") long clinicId);
	
	  @Query(value = "select c from Clinic c")
	  public List<Clinic> getViewAllClinic();

	
	

}
