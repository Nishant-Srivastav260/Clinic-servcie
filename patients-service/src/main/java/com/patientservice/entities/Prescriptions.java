package com.patientservice.entities;

public class Prescriptions{	
	
	private long prescriptionId;
	
	
	private String medicineName;
	
	
	private long duration;
	
	private String medicineCycle;
	
	
	private boolean take_With_Food;
	
	private String description;

	public long getPrescriptionId() {
		return prescriptionId;
	}

	public void setPrescriptionId(long prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public String getMedicineCycle() {
		return medicineCycle;
	}

	public void setMedicineCycle(String medicineCycle) {
		this.medicineCycle = medicineCycle;
	}

	public boolean isTake_With_Food() {
		return take_With_Food;
	}

	public void setTake_With_Food(boolean take_With_Food) {
		this.take_With_Food = take_With_Food;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Prescriptions(long prescriptionId, String medicineName, long duration, String medicineCycle,
			boolean take_With_Food, String description) {
		super();
		this.prescriptionId = prescriptionId;
		this.medicineName = medicineName;
		this.duration = duration;
		this.medicineCycle = medicineCycle;
		this.take_With_Food = take_With_Food;
		this.description = description;
	}

	public Prescriptions() {
		super();
	}

	
	
	
}