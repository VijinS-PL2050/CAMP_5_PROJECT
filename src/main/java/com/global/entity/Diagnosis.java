package com.global.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

//here appointmant id is foreignkey

@Entity
@Component
public class Diagnosis {
	
	
	@Id
	@SequenceGenerator(name = "myDiaSeq", sequenceName = "myDiaSeq", initialValue = 2000, allocationSize = 1)
	@GeneratedValue(generator = "myDiaSeq")
	private int diId;
	
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String diagnosisId;
	
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String diagnosis;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String notes;
	
	@NotNull(message = "is required")
	private LocalDate diagnosisDate;
	
	@NotNull(message = "is required")
	private String isActive="true";
	
	@OneToOne
	@JoinColumn(name = "tId")
	private TokenGenarator tokenGenarator;
	
	
	@OneToMany(mappedBy = "diagnosis")
	private List< MedicinePrescription> medicinePrescription;
	
	
	


	public Diagnosis() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getDiId() {
		return diId;
	}


	public void setDiId(int diId) {
		this.diId = diId;
	}


	public String getDiagnosisId() {
		return diagnosisId;
	}


	public void setDiagnosisId(String diagnosisId) {
		this.diagnosisId = diagnosisId;
	}


	public String getDiagnosis() {
		return diagnosis;
	}


	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}


	public String getNotes() {
		return notes;
	}


	public void setNotes(String notes) {
		this.notes = notes;
	}


	public LocalDate getDiagnosisDate() {
		return diagnosisDate;
	}


	public void setDiagnosisDate(LocalDate diagnosisDate) {
		this.diagnosisDate = diagnosisDate;
	}


	public String getIsActive() {
		return isActive;
	}


	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}


	public TokenGenarator getTokenGenarator() {
		return tokenGenarator;
	}


	public void setTokenGenarator(TokenGenarator tokenGenarator) {
		this.tokenGenarator = tokenGenarator;
	}


	


	public List<MedicinePrescription> getMedicinePrescription() {
		return medicinePrescription;
	}


	public void setMedicinePrescription(List<MedicinePrescription> medicinePrescription) {
		this.medicinePrescription = medicinePrescription;
	}


	@Override
	public String toString() {
		return "Diagnosis [diId=" + diId + ", diagnosisId=" + diagnosisId + ", diagnosis=" + diagnosis + ", notes="
				+ notes + ", diagnosisDate=" + diagnosisDate + ", isActive=" + isActive + ", tokenGenarator="
				+ tokenGenarator + ", medicinePrescription=" + medicinePrescription + "]";
	}





	
	
	
	
}
