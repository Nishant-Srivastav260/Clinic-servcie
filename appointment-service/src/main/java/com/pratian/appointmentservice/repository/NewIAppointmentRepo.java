package com.pratian.appointmentservice.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pratian.appointmentservice.entities.NewAppointment;

@Repository
public interface NewIAppointmentRepo extends JpaRepository<NewAppointment , Long>{
	@Query(value = "select m from NewAppointment m")
	public List<NewAppointment> getAppointmentAll();
	
	@Query(value="select m from NewAppointment m where m.id=:id")
	public NewAppointment getAppointmentById(@Param(value="id") Long id);


}

