package com.clinic.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;

@Entity
public class Clinic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long clinicId;
	
	private String clinicName;
	private String bussinessName;
	private String streetAddr;
	private String clinicCountry;
	private String longitude;
	private String latitude;
	private Date dateCreated;
	private String zipcode;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="clinic_doctor_mapping",
	joinColumns=@JoinColumn(name="clinicId"),
	inverseJoinColumns=@JoinColumn(name="docId"))
	@JsonIgnore
	private List<Doctor> doctor=new ArrayList<>();
		

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="clinic_service_mapping",
	joinColumns=@JoinColumn(name="clinicId"),
	inverseJoinColumns=@JoinColumn(name="serviceId"))
	@JsonIgnore
	private List<ServicesOffered> service=new ArrayList<>();
	

	public Clinic(long clinicId, String clinicName, String bussinessName, String streetAddr, String clinicCountry,
			String longitude, String latitude, Date dateCreated,String zipcode,
			List<Doctor> doctor, List<ServicesOffered> service) {
		super();
		this.clinicId = clinicId;
		this.clinicName = clinicName;
		this.bussinessName = bussinessName;
		this.streetAddr = streetAddr;
		this.clinicCountry = clinicCountry;
		this.longitude = longitude;
		this.latitude = latitude;
		this.dateCreated = dateCreated;
		this.zipcode = zipcode;
		this.doctor = doctor;
		this.service = service;
	}


	public Clinic() {
		super();
	}


	public long getClinicId() {
		return clinicId;
	}


	public void setClinicId(long clinicId) {
		this.clinicId = clinicId;
	}


	public String getClinicName() {
		return clinicName;
	}


	public void setClinicName(String clinicName) {
		this.clinicName = clinicName;
	}


	public String getBussinessName() {
		return bussinessName;
	}


	public void setBussinessName(String bussinessName) {
		this.bussinessName = bussinessName;
	}


	public String getStreetAddr() {
		return streetAddr;
	}


	public void setStreetAddr(String streetAddr) {
		this.streetAddr = streetAddr;
	}


	public String getClinicCountry() {
		return clinicCountry;
	}


	public void setClinicCountry(String clinicCountry) {
		this.clinicCountry = clinicCountry;
	}


	public String getLongitude() {
		return longitude;
	}


	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}


	public String getLatitude() {
		return latitude;
	}


	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}


	public Date getDateCreated() {
		return dateCreated;
	}


	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}


	public String getZipcode() {
		return zipcode;
	}


	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}


	public List<Doctor> getDoctor() {
		return doctor;
	}


	public void setDoctor(List<Doctor> doctor) {
		this.doctor = doctor;
	}




	public List<ServicesOffered> getService() {
		return service;
	}


	public void setService(List<ServicesOffered> service) {
		this.service = service;
	}



	
	
}
