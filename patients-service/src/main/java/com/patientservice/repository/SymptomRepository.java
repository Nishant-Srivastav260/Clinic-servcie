package com.patientservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.patientservice.entities.Symptom;
@Repository
public interface SymptomRepository extends JpaRepository<Symptom, Long> ,CrudRepository<Symptom,Long> {

	@Query(value="select s from Symptom s where s.symptomId=:id")
	public Symptom getSymptomById(@Param(value="id")long id); 
	
}
