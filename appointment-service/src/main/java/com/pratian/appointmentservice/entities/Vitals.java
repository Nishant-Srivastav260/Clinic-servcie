package com.pratian.appointmentservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "vitals")
public class Vitals {
	
	@Id
	@Column(name = "vitals_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  long id;
	
	@Column(name = "ECG")
	private int  ECG;
	
	@Column(name = "temperature")
	private int temperature;
	
	@Column(name = "diabetes")
	private int diabetes;
	
	@Column(name = "respiration_rate")
	private int respiration_rate;
	
	


	public  long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getECG() {
		return ECG;
	}


	public void setECG(int eCG) {
		ECG = eCG;
	}


	public int getTemperature() {
		return temperature;
	}


	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}


	public int getDiabetes() {
		return diabetes;
	}


	public void setDiabetes(int diabetes) {
		this.diabetes = diabetes;
	}


	public int getRespiration_rate() {
		return respiration_rate;
	}


	public void setRespiration_rate(int respiration_rate) {
		this.respiration_rate = respiration_rate;
	}


	
	
	
	
	

}