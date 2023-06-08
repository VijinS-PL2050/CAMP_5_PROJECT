package com.global.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;


@Entity
@Component
public class DoctorDetails {

	@Id
	@SequenceGenerator(name = "myDocSeq", sequenceName = "myDocSeq", initialValue = 500, allocationSize = 1)
	@GeneratedValue(generator = "myDocSeq")
	private int doId;
	
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String doctorId;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String doctorName;
	
	@NotNull(message = "is required")
	private LocalDate dateOfBirth;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String gender;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String bloodGroup;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String phoneno;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String address;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String adharNo;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String qualification;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String email;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String specialization;
	
	@NotNull(message = "is required")
	private double consultationFee;
	
	@NotNull(message = "is required")
	private int noOfToken;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String IsActive="true";
	
	@ManyToOne
	@JoinColumn(name = "dId")
	private DoctorDepartment doctorDepartment;
	
	
	@OneToOne
	@JoinColumn(name = "uId")
	private User user;
	
	
	@OneToMany(mappedBy = "doctorDetails")
	private List<Appointment> appointment;


	public DoctorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getNoOfToken() {
		return noOfToken;
	}


	public void setNoOfToken(int noOfToken) {
		this.noOfToken = noOfToken;
	}


	public int getDoId() {
		return doId;
	}


	public void setDoId(int doId) {
		this.doId = doId;
	}


	public String getDoctorId() {
		return doctorId;
	}


	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
	}


	public String getDoctorName() {
		return doctorName;
	}


	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}


	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getBloodGroup() {
		return bloodGroup;
	}


	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}


	public String getPhoneno() {
		return phoneno;
	}


	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getAdharNo() {
		return adharNo;
	}


	public void setAdharNo(String adharNo) {
		this.adharNo = adharNo;
	}


	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSpecialization() {
		return specialization;
	}


	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}


	public double getConsultationFee() {
		return consultationFee;
	}


	public void setConsultationFee(double consultationFee) {
		this.consultationFee = consultationFee;
	}


	public String getIsActive() {
		return IsActive;
	}


	public void setIsActive(String isActive) {
		IsActive = isActive;
	}


	public DoctorDepartment getDoctorDepartment() {
		return doctorDepartment;
	}


	public void setDoctorDepartment(DoctorDepartment doctorDepartment) {
		this.doctorDepartment = doctorDepartment;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public List<Appointment> getAppointment() {
		return appointment;
	}


	public void setAppointment(List<Appointment> appointment) {
		this.appointment = appointment;
	}


	@Override
	public String toString() {
		return "DoctorDetails [doId=" + doId + ", doctorId=" + doctorId + ", doctorName=" + doctorName
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", bloodGroup=" + bloodGroup + ", phoneno="
				+ phoneno + ", address=" + address + ", adharNo=" + adharNo + ", qualification=" + qualification
				+ ", email=" + email + ", specialization=" + specialization + ", consultationFee=" + consultationFee
				+ ", IsActive=" + IsActive + ", doctorDepartment=" + doctorDepartment + ", user=" + user
				+ ", appointment=" + appointment + "]";
	}


	
	
	
}
