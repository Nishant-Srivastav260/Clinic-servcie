package com.pratian.appointmentservice.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Recommendation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long recommendationId;
	@OneToOne(cascade = CascadeType.ALL)
	private DoctorDetails doctor;
	public long getRecommendationId() {
		return recommendationId;
	}
	public void setRecommendationId(long recommendationId) {
		this.recommendationId = recommendationId;
	}
	public DoctorDetails getDoctor() {
		return doctor;
	}
	public void setDoctor(DoctorDetails doctor) {
		this.doctor = doctor;
	}
	

}
