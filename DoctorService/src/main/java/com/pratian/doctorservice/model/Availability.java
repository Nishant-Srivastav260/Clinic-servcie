package com.pratian.doctorservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Availability {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AvailabilityId")
	private long availId;
	
	@Enumerated(EnumType.STRING)
	private Day day;
	
	@Enumerated(EnumType.STRING)
	private AvailabilityStatus status;
	
	
	private long doctorId;


	public Day getDay() {
		return day;
	}

	public void setDay(Day day) {
		this.day = day;
	}

	public AvailabilityStatus getStatus() {
		return status;
	}
 

	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	public void setStatus(AvailabilityStatus status) {
		this.status = status;
	}

	public long getAvailId() {
		return availId;
	}

	public void setAvailId(long availId) {
		this.availId = availId;
	}

	

}
