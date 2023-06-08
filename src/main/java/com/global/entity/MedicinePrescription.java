package com.global.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

//HERE medicine id is foreign key to medicine table.....shalini undakeela
//dosage id is foreignkey to dosagetable...
//Here diagnosisId is a foreign key to diagnosis table


@Entity
@Component
public class MedicinePrescription {
	
	@Id
	@SequenceGenerator(name = "myMedPreSeq", sequenceName = "myMedPreSeq", initialValue = 300, allocationSize = 1)
	@GeneratedValue(generator = "myMedPreSeq")
	private int mpId;
	
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String medicinePrescriptionId;
	
	@NotNull(message = "is required")
	private int noOfDay;
	
	@NotNull(message = "is required")
	private LocalDate medicinePrescriptionDate;
	
	@NotNull(message = "is required")
	private String isActive="true";
	
	@ManyToOne
	@JoinColumn(name = "diId")
	private Diagnosis  diagnosis;
	
	@ManyToOne
	@JoinColumn(name = "dosId")
	private Dosage dosage;
	
	
	@ManyToOne
	@JoinColumn(name = "msId")
	private MedicinesStock medicinesStock;
	
	
	@OneToOne(mappedBy = "medicinePrescription")
	private BillMedicine BillMedicine;


	public MedicinePrescription() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getMpId() {
		return mpId;
	}


	public void setMpId(int mpId) {
		this.mpId = mpId;
	}


	public String getMedicinePrescriptionId() {
		return medicinePrescriptionId;
	}


	public void setMedicinePrescriptionId(String medicinePrescriptionId) {
		this.medicinePrescriptionId = medicinePrescriptionId;
	}


	public int getNoOfDay() {
		return noOfDay;
	}


	public void setNoOfDay(int noOfDay) {
		this.noOfDay = noOfDay;
	}


	public LocalDate getMedicinePrescriptionDate() {
		return medicinePrescriptionDate;
	}


	public void setMedicinePrescriptionDate(LocalDate medicinePrescriptionDate) {
		this.medicinePrescriptionDate = medicinePrescriptionDate;
	}


	public String getIsActive() {
		return isActive;
	}


	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}


	public Diagnosis getDiagnosis() {
		return diagnosis;
	}


	public void setDiagnosis(Diagnosis diagnosis) {
		this.diagnosis = diagnosis;
	}


	public Dosage getDosage() {
		return dosage;
	}


	public void setDosage(Dosage dosage) {
		this.dosage = dosage;
	}


	public MedicinesStock getMedicinesStock() {
		return medicinesStock;
	}


	public void setMedicinesStock(MedicinesStock medicinesStock) {
		this.medicinesStock = medicinesStock;
	}


	public BillMedicine getBillMedicine() {
		return BillMedicine;
	}


	public void setBillMedicine(BillMedicine billMedicine) {
		BillMedicine = billMedicine;
	}


	@Override
	public String toString() {
		return "MedicinePrescription [mpId=" + mpId + ", medicinePrescriptionId=" + medicinePrescriptionId
				+ ", noOfDay=" + noOfDay + ", medicinePrescriptionDate=" + medicinePrescriptionDate + ", isActive="
				+ isActive + ", diagnosis=" + diagnosis + ", dosage=" + dosage + ", medicinesStock=" + medicinesStock
				+ ", BillMedicine=" + BillMedicine + "]";
	}


	
}
