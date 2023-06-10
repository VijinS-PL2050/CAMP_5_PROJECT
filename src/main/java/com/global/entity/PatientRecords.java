package com.global.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

@Entity
@Component
public class PatientRecords {
	
	
	@Id
	@SequenceGenerator(name = "myPatSeq", sequenceName = "myPatSeq", initialValue = 1001000, allocationSize = 1)
	@GeneratedValue(generator = "myPatSeq")
	private int pId;
	
<<<<<<< HEAD
	//@Size(min = 1, max = 25)
=======
	
	@Size(min = 1, max = 25)
>>>>>>> branch 'master' of https://github.com/VijinS-PL2050/CAMP_5_PROJECT.git
	@Column(unique=true)
	private String mrNo;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String patientName;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String patientPhone;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String patientAddress;
	
	@NotNull(message = "is required")
	@Range(min=0, max=90)
	private int patientAge;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 10)
	private String patientGender;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String patientBlood;
	
	@NotNull(message = "is required")
	private LocalDate registrationDate;
	
	@NotNull(message = "is required")
	private LocalDate validityDate;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String isActive="true";
	
	@OneToMany(mappedBy = "patientRecords")
	private List<Appointment> appointment;
	
	@OneToMany(mappedBy = "patientRecords", cascade=CascadeType.ALL)
	private List<BillAppoinment> billAppoinment;

	public List<BillAppoinment> getBillAppoinment() {
		return billAppoinment;
	}

	public void setBillAppoinment(List<BillAppoinment> billAppoinment) {
		this.billAppoinment = billAppoinment;
	}

	public PatientRecords() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getMrNo() {
		return mrNo;
	}

	public void setMrNo(String mrNo) {
		this.mrNo = mrNo;
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

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	public int getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}

	public String getPatientGender() {
		return patientGender;
	}

	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}

	public String getPatientBlood() {
		return patientBlood;
	}

	public void setPatientBlood(String patientBlood) {
		this.patientBlood = patientBlood;
	}

	public LocalDate getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(LocalDate registrationDate) {
		this.registrationDate = registrationDate;
	}

	public LocalDate getValidityDate() {
		return validityDate;
	}

	public void setValidityDate(LocalDate validityDate) {
		this.validityDate = validityDate;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public List<Appointment> getAppointment() {
		return appointment;
	}

	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}

	@Override
	public String toString() {
		return "PatientRecords [pId=" + pId + ", mrNo=" + mrNo + ", patientName=" + patientName + ", patientPhone="
				+ patientPhone + ", patientAddress=" + patientAddress + ", patientAge=" + patientAge
				+ ", patientGender=" + patientGender + ", patientBlood=" + patientBlood + ", registrationDate="
				+ registrationDate + ", validityDate=" + validityDate + ", isActive=" + isActive + ", appointment="
				+ appointment + "]";
	}

	
	
	

}
