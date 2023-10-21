package com.pratian.appointmentservice.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DoctorDetails{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private long id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Phone_number")
	private String mobileNumber;
	
	@Column(name="Email")
	private String mailId;
	
	@Column(name="NPI_number")
	private String npi;
	
	@Column(name="Practice_Location")
	private String pracLocation;
	
	@Column(name="Specialist")
	private String specialist;
	
	@Column(name="Image_Name")
	private String imageName;
	
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public long getId() {
		return id;
	}
	public String getSpecialist() {
		return specialist;
	}
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
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
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}


	public String getNpi() {
		return npi;
	}
	public void setNpi(String npi) {
		this.npi = npi;
	}
	public String getPracLocation() {
		return pracLocation;
	}
	public void setPracLocation(String pracLocation) {
		this.pracLocation = pracLocation;
	}
	
}	