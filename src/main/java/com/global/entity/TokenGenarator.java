package com.global.entity;

import java.time.LocalDateTime;

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
public class TokenGenarator {

	
	//instance variable
	@Id
	@SequenceGenerator(name = "myTokSeq", sequenceName = "myTokSeq", initialValue = 500, allocationSize = 1)
	@GeneratedValue(generator = "myTokSeq")
	private int tId;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String tokenNo;

	@NotNull(message = "is required")
	private LocalDateTime tokenTime;

	@NotNull(message = "is required")
	private String isActive="true";
	
	@OneToOne
	@JoinColumn(name = "aId")
	private Appointment appointment;
	
	
	@OneToOne(mappedBy = "tokenGenarator")
	private Diagnosis diagnosis;


	public TokenGenarator() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int gettId() {
		return tId;
	}


	public void settId(int tId) {
		this.tId = tId;
	}


	public String getTokenNo() {
		return tokenNo;
	}


	public void setTokenNo(String tokenNo) {
		this.tokenNo = tokenNo;
	}


	public LocalDateTime getTokenTime() {
		return tokenTime;
	}


	public void setTokenTime(LocalDateTime tokenTime) {
		this.tokenTime = tokenTime;
	}


	public String getIsActive() {
		return isActive;
	}


	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}


	public Appointment getAppointment() {
		return appointment;
	}


	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}


	public Diagnosis getDiagnosis() {
		return diagnosis;
	}


	public void setDiagnosis(Diagnosis diagnosis) {
		this.diagnosis = diagnosis;
	}


	@Override
	public String toString() {
		return "TokenGenarator [tId=" + tId + ", tokenNo=" + tokenNo + ", tokenTime=" + tokenTime + ", isActive="
				+ isActive + ", appointment=" + appointment + ", diagnosis=" + diagnosis + "]";
	}


	
	
	

}
