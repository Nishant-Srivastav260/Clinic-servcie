

package com.pratian.appointmentservice.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "prescriptions")
public class Prescriptions{	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="prescription_id")
	private long prescriptionId;
	
	@Column(name="medicine_name")
	private String medicineName;
	
	@Column(name="duration")
	private long duration;
	
	@Column(name="medicine_cycle")
	private String medicineCycle;
	
	@Column(name="take_with_food")
	private boolean take_With_Food;
	
	@Column(name="description")
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
}
