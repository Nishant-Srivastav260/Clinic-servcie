package com.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.clinic.model.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{

	@Query(value="select ci from City ci where ci.cityId=:cityId")
	public City getCityById(@Param("cityId") long cityId);

	
	
}
