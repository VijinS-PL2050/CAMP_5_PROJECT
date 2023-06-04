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
public class BillMedicine {
	
	@Id
	@SequenceGenerator(name = "myBillMedSeq", sequenceName = "myBillMedSeq", initialValue = 900800, allocationSize = 1)
	@GeneratedValue(generator = "myBillMedSeq")
	private int bmId;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String billMedicineNo;
	
	@NotNull(message = "is required")
	private LocalDateTime billDate;
	
	@NotNull(message = "is required")
	private Double billAmount;
	
	@NotNull(message = "is required")
	private String isActive="true";
	
	@OneToOne
	@JoinColumn(name = "mpId")
	private MedicinePrescription medicinePrescription;

	public BillMedicine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getBmId() {
		return bmId;
	}

	public void setBmId(int bmId) {
		this.bmId = bmId;
	}

	public String getBillMedicineNo() {
		return billMedicineNo;
	}

	public void setBillMedicineNo(String billMedicineNo) {
		this.billMedicineNo = billMedicineNo;
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

	public MedicinePrescription getMedicinePrescription() {
		return medicinePrescription;
	}

	public void setMedicinePrescription(MedicinePrescription medicinePrescription) {
		this.medicinePrescription = medicinePrescription;
	}

	@Override
	public String toString() {
		return "BillMedicine [bmId=" + bmId + ", billMedicineNo=" + billMedicineNo + ", billDate=" + billDate
				+ ", billAmount=" + billAmount + ", isActive=" + isActive + ", medicinePrescription="
				+ medicinePrescription + "]";
	}

	

}
