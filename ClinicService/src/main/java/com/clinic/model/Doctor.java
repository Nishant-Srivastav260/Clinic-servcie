package com.clinic.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long docId;
	
		private String title;
		private String name;
		private String email;
		private String phone_no;
		private String speciality;
		private String npi_no;
		private String practice_location;
		private String gender;
		
		
		@ManyToMany(mappedBy = "doctor")
		@JsonIgnore
		private List<Clinic> clinic=new ArrayList<>();
	
	public Doctor(long docId, String title, String name, String email, String phone_no, String speciality, String npi_no,
			String practice_location, String gender, String blood_group, String dob, String username, String password,
			String profile_picture, String role) {
		super();
		this.docId = docId;
		this.title = title;
		this.name = name;
		this.email = email;
		this.phone_no = phone_no;
		this.speciality = speciality;
		this.npi_no = npi_no;
		this.practice_location = practice_location;
		this.gender = gender;
	}
	public Doctor() {
		super();
	}
	
	public long getDocId() {
		return docId;
	}
	public void setDocId(long docId) {
		this.docId = docId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	public String getNpi_no() {
		return npi_no;
	}
	public void setNpi_no(String npi_no) {
		this.npi_no = npi_no;
	}
	public String getPractice_location() {
		return practice_location;
	}
	public void setPractice_location(String practice_location) {
		this.practice_location = practice_location;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Clinic> getClinic() {
		return clinic;
	}
	public void setClinic(List<Clinic> clinic) {
		this.clinic = clinic;
	}
}
