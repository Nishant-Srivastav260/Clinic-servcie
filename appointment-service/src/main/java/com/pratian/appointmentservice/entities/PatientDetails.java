package com.pratian.appointmentservice.entities;

//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

public class PatientDetails {
	
	private long patientId;
	private String  patientName;
	private String patientPhone;
	private String patientLocation;
	private String patientImageUrl;
	private int patientAge;
	private String patientMail;
	private String patientBloodgroup;
	private float patientHeight;
	private String patientGender;
	private String title;
	private String patientDOB;
	private String allergie;
	private String activeIssue;
	private String medicalProblem;
	public long getPatientId() {
		return patientId;
	}
	public void setPatientId(long patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientPhone() {
		return patientPhone;
	}
	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}
	public String getPatientLocation() {
		return patientLocation;
	}
	public void setPatientLocation(String patientLocation) {
		this.patientLocation = patientLocation;
	}
	public String getPatientImageUrl() {
		return patientImageUrl;
	}
	public void setPatientImageUrl(String patientImageUrl) {
		this.patientImageUrl = patientImageUrl;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	public String getPatientMail() {
		return patientMail;
	}
	public void setPatientMail(String patientMail) {
		this.patientMail = patientMail;
	}
	public String getPatientBloodgroup() {
		return patientBloodgroup;
	}
	public void setPatientBloodgroup(String patientBloodgroup) {
		this.patientBloodgroup = patientBloodgroup;
	}
	public float getPatientHeight() {
		return patientHeight;
	}
	public void setPatientHeight(float patientHeight) {
		this.patientHeight = patientHeight;
	}
	public String getPatientGender() {
		return patientGender;
	}
	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPatientDOB() {
		return patientDOB;
	}
	public void setPatientDOB(String patientDOB) {
		this.patientDOB = patientDOB;
	}
	public String getAllergie() {
		return allergie;
	}
	public void setAllergie(String allergie) {
		this.allergie = allergie;
	}
	public String getActiveIssue() {
		return activeIssue;
	}
	public void setActiveIssue(String activeIssue) {
		this.activeIssue = activeIssue;
	}
	public String getMedicalProblem() {
		return medicalProblem;
	}
	public void setMedicalProblem(String medicalProblem) {
		this.medicalProblem = medicalProblem;
	}
	public PatientDetails() {
		super();
		
	}
	public PatientDetails(long patientId, String patientName, String patientPhone, String patientLocation,
			String patientImageUrl, int patientAge, String patientMail, String patientBloodgroup, float patientHeight,
			String patientGender, String title, String patientDOB, String allergie, String activeIssue,
			String medicalProblem) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.patientPhone = patientPhone;
		this.patientLocation = patientLocation;
		this.patientImageUrl = patientImageUrl;
		this.patientAge = patientAge;
		this.patientMail = patientMail;
		this.patientBloodgroup = patientBloodgroup;
		this.patientHeight = patientHeight;
		this.patientGender = patientGender;
		this.title = title;
		this.patientDOB = patientDOB;
		this.allergie = allergie;
		this.activeIssue = activeIssue;
		this.medicalProblem = medicalProblem;
	}
	
	
}
