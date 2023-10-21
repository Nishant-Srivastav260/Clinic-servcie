package com.patientservice.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name= "patient_id")
	@JsonIgnore
	private List<Feedback> feedbacks;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name= "patient_id")
	@JsonIgnore
	private List<Symptom> symptoms;


	public Patient() {
		super();
	}


	public Patient(long patientId, String patientName, String patientPhone, String patientLocation,
			String patientImageUrl, int patientAge, String patientMail, String patientBloodgroup, float patientHeight,
			String patientGender, String title, String patientDOB, String allergie, String activeIssue,
			String medicalProblem, List<Feedback> feedbacks, List<Symptom> symptoms) {
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
		this.feedbacks = feedbacks;
		this.symptoms = symptoms;
	}


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

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public List<Symptom> getSymptoms() {
		return symptoms;
	}

	public void setSymptoms(List<Symptom> symptoms) {
		this.symptoms = symptoms;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activeIssue == null) ? 0 : activeIssue.hashCode());
		result = prime * result + ((allergie == null) ? 0 : allergie.hashCode());
		result = prime * result + ((feedbacks == null) ? 0 : feedbacks.hashCode());
		result = prime * result + ((medicalProblem == null) ? 0 : medicalProblem.hashCode());
		result = prime * result + patientAge;
		result = prime * result + ((patientBloodgroup == null) ? 0 : patientBloodgroup.hashCode());
		result = prime * result + ((patientDOB == null) ? 0 : patientDOB.hashCode());
		result = prime * result + ((patientGender == null) ? 0 : patientGender.hashCode());
		result = prime * result + Float.floatToIntBits(patientHeight);
		result = prime * result + (int) (patientId ^ (patientId >>> 32));
		result = prime * result + ((patientImageUrl == null) ? 0 : patientImageUrl.hashCode());
		result = prime * result + ((patientLocation == null) ? 0 : patientLocation.hashCode());
		result = prime * result + ((patientMail == null) ? 0 : patientMail.hashCode());
		result = prime * result + ((patientName == null) ? 0 : patientName.hashCode());
		result = prime * result + ((patientPhone == null) ? 0 : patientPhone.hashCode());
		result = prime * result + ((symptoms == null) ? 0 : symptoms.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (activeIssue == null) {
			if (other.activeIssue != null)
				return false;
		} else if (!activeIssue.equals(other.activeIssue))
			return false;
		if (allergie == null) {
			if (other.allergie != null)
				return false;
		} else if (!allergie.equals(other.allergie))
			return false;
		if (feedbacks == null) {
			if (other.feedbacks != null)
				return false;
		} else if (!feedbacks.equals(other.feedbacks))
			return false;
		if (medicalProblem == null) {
			if (other.medicalProblem != null)
				return false;
		} else if (!medicalProblem.equals(other.medicalProblem))
			return false;
		if (patientAge != other.patientAge)
			return false;
		if (patientBloodgroup == null) {
			if (other.patientBloodgroup != null)
				return false;
		} else if (!patientBloodgroup.equals(other.patientBloodgroup))
			return false;
		if (patientDOB == null) {
			if (other.patientDOB != null)
				return false;
		} else if (!patientDOB.equals(other.patientDOB))
			return false;
		if (patientGender == null) {
			if (other.patientGender != null)
				return false;
		} else if (!patientGender.equals(other.patientGender))
			return false;
		if (Float.floatToIntBits(patientHeight) != Float.floatToIntBits(other.patientHeight))
			return false;
		if (patientId != other.patientId)
			return false;
		if (patientImageUrl == null) {
			if (other.patientImageUrl != null)
				return false;
		} else if (!patientImageUrl.equals(other.patientImageUrl))
			return false;
		if (patientLocation == null) {
			if (other.patientLocation != null)
				return false;
		} else if (!patientLocation.equals(other.patientLocation))
			return false;
		if (patientMail == null) {
			if (other.patientMail != null)
				return false;
		} else if (!patientMail.equals(other.patientMail))
			return false;
		if (patientName == null) {
			if (other.patientName != null)
				return false;
		} else if (!patientName.equals(other.patientName))
			return false;
		if (patientPhone == null) {
			if (other.patientPhone != null)
				return false;
		} else if (!patientPhone.equals(other.patientPhone))
			return false;
		if (symptoms == null) {
			if (other.symptoms != null)
				return false;
		} else if (!symptoms.equals(other.symptoms))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

}
