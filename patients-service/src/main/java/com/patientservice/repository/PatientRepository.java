package com.patientservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.patientservice.entities.Patient;
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
	@Query(value="select p from Patient p where p.patientId=:id ")
    public Patient getPatientById(@Param(value="id")long id);
}
