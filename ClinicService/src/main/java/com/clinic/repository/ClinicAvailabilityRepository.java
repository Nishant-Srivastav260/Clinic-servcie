package com.clinic.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clinic.model.ClinicAvailability;
import com.clinic.model.Week;


@Repository
public interface ClinicAvailabilityRepository extends JpaRepository<ClinicAvailability, Long>{

	@Query("Select c from ClinicAvailability c where c.week= :week")
	public List<ClinicAvailability> getClinicByDay(@Param("week") Week week);

}
