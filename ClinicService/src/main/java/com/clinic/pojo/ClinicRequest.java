package com.clinic.pojo;

import java.sql.Date;
import java.util.HashMap;

//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;



public class ClinicRequest {
	
	private long clinicId;
	private String clinicName;
	private String bussinessName;
	private String streetAddr;
	private String clinicCountry;
	private String longitude;
	private String latitude;
	private Date dateCreated;
	private String zipcode;
	public ClinicRequest(long clinicId, String clinicName, String bussinessName, String streetAddr,
			String clinicCountry, String longitude, String latitude, Date dateCreated, String zipcode) {
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
	}

	public ClinicRequest() {
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

	
	
	
	
	
}
