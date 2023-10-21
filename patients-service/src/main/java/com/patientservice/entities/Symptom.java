package com.patientservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Symptom {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long symptomId;	
	private String symptomName;
	private String reading;
	private String doctorname;	
}
