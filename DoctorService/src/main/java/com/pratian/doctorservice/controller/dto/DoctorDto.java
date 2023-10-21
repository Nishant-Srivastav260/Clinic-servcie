package com.pratian.doctorservice.controller.dto;

public class DoctorDto {

	private long id;
	private String name;
	private String phone_no;
	private String speciality;
	
	public DoctorDto(long id, String name, String phone_no, String speciality) {
		super();
		this.id = id;
		this.name = name;
		this.phone_no = phone_no;
		this.speciality = speciality;
	}
	

	public DoctorDto() {
		super();
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	
	
}
