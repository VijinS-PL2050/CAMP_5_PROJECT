package com.global.entity;

import java.time.LocalDate;
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
public class PatientRecords {
	
	
	@Id
	@SequenceGenerator(name = "myPatSeq", sequenceName = "myPatSeq", initialValue = 100100100, allocationSize = 1)
	@GeneratedValue(generator = "myPatSeq")
	private int pId;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String mrNo;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String patientName;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private long patientPhone;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String patientAddress;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 4)
	private short patientAge;
	
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

	public long getPatientPhone() {
		return patientPhone;
	}

	public void setPatientPhone(long patientPhone) {
		this.patientPhone = patientPhone;
	}

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	public short getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(short patientAge) {
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
