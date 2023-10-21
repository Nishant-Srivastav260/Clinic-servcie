package com.pratian.appointmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pratian.appointmentservice.entities.Vitals;

@Repository
public interface VitalsRepo extends JpaRepository<Vitals, Long>{

	

	@Query(value="select v from Vitals v where v.id=:id")
	Vitals findByvitalId(@Param(value="id") long id);
}
