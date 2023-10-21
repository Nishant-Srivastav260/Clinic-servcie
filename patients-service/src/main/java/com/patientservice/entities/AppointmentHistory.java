package com.patientservice.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class AppointmentHistory {


	private long appointmentHistoryId;
	private int year;
	private String doctorname;
	private String specialist;
	private String appointmentDate;
	private String comment;
	private String time;
	public long getAppointmentHistoryId() {
		return appointmentHistoryId;
	}
	public void setAppointmentHistoryId(long appointmentHistoryId) {
		this.appointmentHistoryId = appointmentHistoryId;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	public String getSpecialist() {
		return specialist;
	}
	public void setSpecialist(String specialist) {
		this.specialist = specialist;
	}
	public String getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public AppointmentHistory(long appointmentHistoryId, int year, String doctorname, String specialist,
			String appointmentDate, String comment, String time) {
		super();
		this.appointmentHistoryId = appointmentHistoryId;
		this.year = year;
		this.doctorname = doctorname;
		this.specialist = specialist;
		this.appointmentDate = appointmentDate;
		this.comment = comment;
		this.time = time;
	}
	public AppointmentHistory() {
		super();
	}
	
	
	
}
