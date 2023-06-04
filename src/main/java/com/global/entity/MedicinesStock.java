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

@Entity
@Component
public class MedicinesStock {
	
	@Id
	@SequenceGenerator(name = "myMedSeq", sequenceName = "myMedSeq", initialValue = 70000, allocationSize = 1)
	@GeneratedValue(generator = "myMedSeq")
	private int msId;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String medicineId;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String medicineName;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String companyName;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private  String genericName;
	
	@NotNull(message = "is required")
	private int quantity;
	
	@NotNull(message = "is required")
	private double price;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String isActive="true";
	
	@OneToMany(mappedBy = "medicinesStock")
	private List<MedicinePrescription> medicinePrescription;

	public MedicinesStock() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMsId() {
		return msId;
	}

	public void setMsId(int msId) {
		this.msId = msId;
	}

	public String getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(String medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getGenericName() {
		return genericName;
	}

	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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
		return "MedicinesStock [msId=" + msId + ", medicineId=" + medicineId + ", medicineName=" + medicineName
				+ ", companyName=" + companyName + ", genericName=" + genericName + ", quantity=" + quantity
				+ ", price=" + price + ", isActive=" + isActive + ", medicinePrescription=" + medicinePrescription
				+ "]";
	}

	

	
}
