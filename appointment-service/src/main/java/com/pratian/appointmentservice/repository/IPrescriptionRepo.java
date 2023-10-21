package com.pratian.appointmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pratian.appointmentservice.entities.Prescriptions;



@Repository
public interface IPrescriptionRepo extends JpaRepository<Prescriptions, Long>{

	@Query(value="select p from Prescriptions p where p.prescriptionId=:presId")
	public Prescriptions getByPrescriptionId(@Param(value="presId") long presId);
}
