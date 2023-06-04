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
public class BillAppoinment {
	
	@Id
	@SequenceGenerator(name = "myBillAppSeq", sequenceName = "myBillAppSeq", initialValue = 700800, allocationSize = 1)
	@GeneratedValue(generator = "myBillAppSeq")
	private int baId;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String billAppoinmentNo;
	
	@NotNull(message = "is required")
	private LocalDateTime billDate;
	
	@NotNull(message = "is required")
	private Double billAmount;
	
	@NotNull(message = "is required")
	private String isActive="true";

	@OneToOne
	@JoinColumn(name = "aId")
	private Appointment appointment;

	public BillAppoinment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBaId() {
		return baId;
	}

	public void setBaId(int baId) {
		this.baId = baId;
	}

	public String getBillAppoinmentNo() {
		return billAppoinmentNo;
	}

	public void setBillAppoinmentNo(String billAppoinmentNo) {
		this.billAppoinmentNo = billAppoinmentNo;
	}

	public LocalDateTime getBillDate() {
		return billDate;
	}

	public void setBillDate(LocalDateTime billDate) {
		this.billDate = billDate;
	}

	public Double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
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

	@Override
	public String toString() {
		return "BillAppoinment [baId=" + baId + ", billAppoinmentNo=" + billAppoinmentNo + ", billDate=" + billDate
				+ ", billAmount=" + billAmount + ", isActive=" + isActive + ", appointment=" + appointment + "]";
	}

	
	
	
	

}
