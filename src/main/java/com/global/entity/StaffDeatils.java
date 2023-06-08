package com.global.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Component
public class StaffDeatils {
	
	
	@Id
	@SequenceGenerator(name = "myStaffSeq", sequenceName = "myStaffSeq", initialValue = 90000, allocationSize = 1)
	@GeneratedValue(generator = "myStaffSeq")
	private int sId;
	
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String staffid;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String staffname;
	
	@NotNull(message = "is required")
	private LocalDate dateofbirth;
	
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
	@Column(unique=true)
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
	private String IsActive="true";
	
	@OneToOne
	@JoinColumn(name = "uId")
	private User user;

	public StaffDeatils() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getStaffid() {
		return staffid;
	}

	public void setStaffid(String staffid) {
		this.staffid = staffid;
	}

	public String getStaffname() {
		return staffname;
	}

	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}

	public LocalDate getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(LocalDate dateofbirth) {
		this.dateofbirth = dateofbirth;
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

	public String getIsActive() {
		return IsActive;
	}

	public void setIsActive(String isActive) {
		IsActive = isActive;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "StaffDeatils [sId=" + sId + ", staffid=" + staffid + ", staffname=" + staffname + ", dateofbirth="
				+ dateofbirth + ", gender=" + gender + ", bloodGroup=" + bloodGroup + ", phoneno=" + phoneno
				+ ", address=" + address + ", adharNo=" + adharNo + ", qualification=" + qualification + ", email="
				+ email + ", IsActive=" + IsActive + ", user=" + user + "]";
	}

	
	

}
