package com.pratian.doctorservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.pratian.doctorservice.model.Availability;
import com.pratian.doctorservice.model.Day;

@Repository
@EnableJpaRepositories
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
	
	@Query(value = "select * from Availability a where a.doctor_id =:id",nativeQuery = true)
	Availability findAvailabilityById(long id);

	@Query(value = "select * from Availability a where a.doctor_id = :id and a.day = :day",nativeQuery = true)
	Availability getDoctorAvailabilityByDay(@Param(value = "id")long id, @Param(value = "day")Day day);
}
