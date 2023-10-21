package com.pratian.appointmentservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pratian.appointmentservice.entities.DoctorDetails;


@Repository
public interface DoctorDetailsRepository extends JpaRepository<DoctorDetails, Long> {
	//@Query(value="select c from Comment c where c.Id=:id")
	@Query(value="select d from  DoctorDetails d where d.id=:id")
	public DoctorDetails getDoctorDetailsById(@Param(value ="id")long id);


}
