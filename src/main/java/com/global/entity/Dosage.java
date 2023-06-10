package com.global.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

//This is the dosage Parent table

@Entity
@Component
public class Dosage {
	
	@Id
	@SequenceGenerator(name = "myDosSeq", sequenceName = "myDosSeq", initialValue = 70000, allocationSize = 1)
	@GeneratedValue(generator = "myDosSeq")
	private int dosId;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String dosageId;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String dosage;
	
	@NotNull(message = "is required")
	private int quantity;
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@NotNull(message = "is required")
	private String isActive="true";

	@OneToMany(mappedBy = "dosage")
	private List<MedicinePrescription> medicinePrescription;

	public Dosage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getDosId() {
		return dosId;
	}

	public void setDosId(int dosId) {
		this.dosId = dosId;
	}

	public String getDosageId() {
		return dosageId;
	}

	public void setDosageId(String dosageId) {
		this.dosageId = dosageId;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public List<MedicinePrescription> getMedicinePrescription() {
		return medicinePrescription;
	}

	public void setMedicinePrescription(List<MedicinePrescription> medicinePrescription) {
		this.medicinePrescription = medicinePrescription;
	}

	@Override
	public String toString() {
		return "Dosage [dosId=" + dosId + ", dosageId=" + dosageId + ", dosage=" + dosage + ", isActive=" + isActive
				+ ", medicinePrescription=" + medicinePrescription + "]";
	}

	
	

}
