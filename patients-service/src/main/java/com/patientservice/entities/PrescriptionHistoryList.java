package com.patientservice.entities;

import java.util.ArrayList;
import java.util.List;

public class PrescriptionHistoryList {
	
	
	public List<Prescriptions>  prescriptionList = new ArrayList<>();

	public List<Prescriptions> getPrescriptionList() {
		return prescriptionList;
	}

	public void setPrescriptionList(List<Prescriptions> prescriptionList) {
		this.prescriptionList = prescriptionList;
	}

	public PrescriptionHistoryList() {
		super();
		
	}

	public PrescriptionHistoryList(List<Prescriptions> prescriptionList) {
		super();
		this.prescriptionList = prescriptionList;
	}
	
	

}
