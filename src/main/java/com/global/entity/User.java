package com.global.entity;

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
public class User {

	//instance varaible
	@Id
	@SequenceGenerator(name = "myUserSeq", sequenceName = "myUserSeq", initialValue = 90000, allocationSize = 1)
	@GeneratedValue(generator = "myUserSeq")
	private int uId;
	
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String userId;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String userName;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String password;
	

	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String isActive="true";
	
	@ManyToOne
	@JoinColumn(name = "rId")
	private Role role;
	
	
	@OneToOne(mappedBy = "user")
	private DoctorDetails doctorDetails;
	
	
	@OneToOne(mappedBy = "user")
	private StaffDeatils staffDeatils;


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getuId() {
		return uId;
	}


	public void setuId(int uId) {
		this.uId = uId;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getIsActive() {
		return isActive;
	}


	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}


	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}


	public DoctorDetails getDoctorDetails() {
		return doctorDetails;
	}


	public void setDoctorDetails(DoctorDetails doctorDetails) {
		this.doctorDetails = doctorDetails;
	}


	public StaffDeatils getStaffDeatils() {
		return staffDeatils;
	}


	public void setStaffDeatils(StaffDeatils staffDeatils) {
		this.staffDeatils = staffDeatils;
	}


	@Override
	public String toString() {
		return "User [uId=" + uId + ", userId=" + userId + ", userName=" + userName + ", password=" + password
				+ ", isActive=" + isActive + ", role=" + role + ", doctorDetails=" + doctorDetails + ", staffDeatils="
				+ staffDeatils + "]";
	}


	
	
	
	
}
