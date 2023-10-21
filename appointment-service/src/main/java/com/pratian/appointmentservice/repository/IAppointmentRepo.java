package com.pratian.appointmentservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pratian.appointmentservice.entities.Appointment;
import com.pratian.appointmentservice.entities.DoctorDetails;

@Repository
public interface IAppointmentRepo extends JpaRepository<Appointment, Long>{
	
	@Query("select m from Appointment m  where m.id= :id")
	public Appointment getTestsforAppointment(@Param(value="id") long id);
	
	 @Query("select a from Appointment a where a.id = :id")
	  public Appointment getAppointmentByIdForRecommendation(@Param(value="id") long id);
	

		@Query(value="select a from Appointment a where a.id=:id")
		public Appointment getAppointmentById(@Param(value="id") long id);
		
		@Query(value="select d from  DoctorDetails d where d.id=:id")
		public DoctorDetails getDoctorDetailsById(@Param(value ="id")long id);
		
//		
//		@Query(value="select a from Appointment a where a.patientId=:id")
//		public Appointment getAppointmentByPatientId(@Param(value="id")long id);
		
		@Query(value="select a from Appointment a where a.patientId=:id")
		public List<Appointment> getAppointmentByPatientId(@Param(value="id")long id);
	
		
}
	

