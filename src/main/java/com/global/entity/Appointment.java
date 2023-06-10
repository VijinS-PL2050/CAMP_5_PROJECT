package com.global.entity;

import java.time.LocalDateTime;

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

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;


@Entity
@Component
public class Appointment {

	
	@Id
	@SequenceGenerator(name = "myAppSeq", sequenceName = "myAppSeq", initialValue = 5000, allocationSize = 1)
	@GeneratedValue(generator = "myAppSeq")
	private int aId;
	
<<<<<<< HEAD
=======
	
	@Size(min = 1, max = 25)
>>>>>>> branch 'master' of https://github.com/VijinS-PL2050/CAMP_5_PROJECT.git
	@Column(unique=true)
	private String bookingNo;

	@NotNull(message = "is required")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime appointmentDateTime;
	
	@NotNull(message = "is required")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
	private LocalDateTime appointmentValidity;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String isActive="true";
	
	@ManyToOne
	@JoinColumn(name = "dId")
	private DoctorDepartment doctorDepartment;
	
	@ManyToOne
	@JoinColumn(name = "doId")
	private DoctorDetails doctorDetails;
	
	@ManyToOne
	@JoinColumn(name = "pId")
	private PatientRecords patientRecords;
	
	
	@OneToOne(mappedBy = "appointment")
	private TokenGenarator tokenGenarator;
	
	@OneToOne(mappedBy = "appointment")
	private BillAppoinment billAppoinment;

	public Appointment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getaId() {
		return aId;
	}

	public void setaId(int aId) {
		this.aId = aId;
	}

	public String getBookingNo() {
		return bookingNo;
	}

	public void setBookingNo(String bookingNo) {
		this.bookingNo = bookingNo;
	}

	public LocalDateTime getAppointmentDateTime() {
		return appointmentDateTime;
	}

	public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
		this.appointmentDateTime = appointmentDateTime;
	}

	public LocalDateTime getAppointmentValidity() {
		return appointmentValidity;
	}

	public void setAppointmentValidity(LocalDateTime appointmentValidity) {
		this.appointmentValidity = appointmentValidity;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public DoctorDepartment getDoctorDepartment() {
		return doctorDepartment;
	}

	public void setDoctorDepartment(DoctorDepartment doctorDepartment) {
		this.doctorDepartment = doctorDepartment;
	}

	public DoctorDetails getDoctorDetails() {
		return doctorDetails;
	}

	public void setDoctorDetails(DoctorDetails doctorDetails) {
		this.doctorDetails = doctorDetails;
	}

	public PatientRecords getPatientRecords() {
		return patientRecords;
	}

	public void setPatientRecords(PatientRecords patientRecords) {
		this.patientRecords = patientRecords;
	}

	public TokenGenarator getTokenGenarator() {
		return tokenGenarator;
	}

	public void setTokenGenarator(TokenGenarator tokenGenarator) {
		this.tokenGenarator = tokenGenarator;
	}

	public BillAppoinment getBillAppoinment() {
		return billAppoinment;
	}

	public void setBillAppoinment(BillAppoinment billAppoinment) {
		this.billAppoinment = billAppoinment;
	}

	@Override
	public String toString() {
		return "Appointment [aId=" + aId + ", bookingNo=" + bookingNo + ", appointmentDateTime=" + appointmentDateTime
				+ ", appointmentValidity=" + appointmentValidity + ", isActive=" + isActive + ", doctorDepartment="
				+ doctorDepartment + ", doctorDetails=" + doctorDetails + ", patientRecords=" + patientRecords
				+ ", tokenGenarator=" + tokenGenarator + ", billAppoinment=" + billAppoinment + "]";
	}
	
	
	
	

	
	


}
