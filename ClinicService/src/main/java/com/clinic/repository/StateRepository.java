package com.clinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.clinic.model.State;


public interface StateRepository extends JpaRepository<State, Long>{

	
	@Query(value="select s from State s where s.name= :name")
	public State getStateObj(@Param("name") String name);

}
