package com.pratian.doctorservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Doctors")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DoctorId")
	private long id;
	
	 @Column(name = "Title")
	   private String title;
	  @Column(name = "Name")
		private String name;
	  @Column(name = "Email")
		private String email;
	  @Column(name = "Phone_no")
		private String phone_no;
	  @Column(name = "Speciality")
		private String speciality;
	  @Column(name = "npi_no")
		private String npi_no;
	  @Column(name = "Practice_Location")
		private String practice_location;
	  @Column(name = "gender")
		private String gender;
	  @Column(name = "blood_group")
		private String blood_group;
	  @Column(name = "Date_of_Birth")
		private String dob;
	  @Column(name = "username")
		private String username;
	  @Column(name = "password")
		private String password;
	  @Column(name = "Profile_picture")
		private String profile_picture;
	  @Column(name = "Role")
	  private String role;
	 

	
	public Doctor(long id, String title, String name, String email, String phone_no, String speciality, String npi_no,
			String practice_location, String gender, String blood_group, String dob, String username, String password,
			String profile_picture, String role) {
		super();
		this.id = id;
		this.title = title;
		this.name = name;
		this.email = email;
		this.phone_no = phone_no;
		this.speciality = speciality;
		this.npi_no = npi_no;
		this.practice_location = practice_location;
		this.gender = gender;
		this.blood_group = blood_group;
		this.dob = dob;
		this.username = username;
		this.password = password;
		this.profile_picture = profile_picture;
		this.role = role;
	}
	public Doctor() {
		super();
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	public String getBlood_group() {
		return blood_group;
	}
	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProfile_picture() {
		return profile_picture;
	}
	public void setProfile_picture(String profile_picture) {
		this.profile_picture = profile_picture;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}

	  
}
