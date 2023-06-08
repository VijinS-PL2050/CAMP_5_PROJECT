package com.global.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TestReport {
	
	@Id
	@SequenceGenerator(name = "myTestRepSeq", sequenceName = "myTestRepSeq", initialValue = 3001000, allocationSize = 1)
	@GeneratedValue(generator = "myTestRepSeq")
	private int rpId;
	
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private int reportId;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String Report;
	
	@NotNull(message = "is required")
	private LocalDate reportDate;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String highValue;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String lowValue;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String actualValue;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String unit;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String isActive="true";
	
	@OneToOne(mappedBy="testReport")
	private TestPrescription testPrescription;

	public TestReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRpId() {
		return rpId;
	}

	public void setRpId(int rpId) {
		this.rpId = rpId;
	}

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public String getReport() {
		return Report;
	}

	public void setReport(String report) {
		Report = report;
	}

	public LocalDate getReportDate() {
		return reportDate;
	}

	public void setReportDate(LocalDate reportDate) {
		this.reportDate = reportDate;
	}

	public String getHighValue() {
		return highValue;
	}

	public void setHighValue(String highValue) {
		this.highValue = highValue;
	}

	public String getLowValue() {
		return lowValue;
	}

	public void setLowValue(String lowValue) {
		this.lowValue = lowValue;
	}

	public String getActualValue() {
		return actualValue;
	}

	public void setActualValue(String actualValue) {
		this.actualValue = actualValue;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public TestPrescription getTestPrescription() {
		return testPrescription;
	}

	public void setTestPrescription(TestPrescription testPrescription) {
		this.testPrescription = testPrescription;
	}

	@Override
	public String toString() {
		return "TestReport [rpId=" + rpId + ", reportId=" + reportId + ", Report=" + Report + ", reportDate="
				+ reportDate + ", highValue=" + highValue + ", lowValue=" + lowValue + ", actualValue=" + actualValue
				+ ", unit=" + unit + ", isActive=" + isActive + ", testPrescription=" + testPrescription + "]";
	}
	

}
