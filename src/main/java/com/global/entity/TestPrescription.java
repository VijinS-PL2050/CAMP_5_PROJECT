package com.global.entity;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

public class TestPrescription {
	
	@Id
	@SequenceGenerator(name = "myTestPreSeq", sequenceName = "myTestPreSeq", initialValue = 201000, allocationSize = 1)
	@GeneratedValue(generator = "myTestPreSeq")
	private int tpId;
	
	private String testPrescriptionId;
	
	private LocalDate testDay;
	
	
	@ManyToOne
	@JoinColumn(name = "ttId")
	private Tests tests;
	
	@ManyToOne
	@JoinColumn(name = "diId")
	private int diagnosisId;
	
	@OneToOne
	@JoinColumn(name = "trId")
	private TestReport testReport;

	public TestPrescription() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTpId() {
		return tpId;
	}

	public void setTpId(int tpId) {
		this.tpId = tpId;
	}

	public String getTestPrescriptionId() {
		return testPrescriptionId;
	}

	public void setTestPrescriptionId(String testPrescriptionId) {
		this.testPrescriptionId = testPrescriptionId;
	}

	public LocalDate getTestDay() {
		return testDay;
	}

	public void setTestDay(LocalDate testDay) {
		this.testDay = testDay;
	}

	public Tests getTests() {
		return tests;
	}

	public void setTests(Tests tests) {
		this.tests = tests;
	}

	public int getDiagnosisId() {
		return diagnosisId;
	}

	public void setDiagnosisId(int diagnosisId) {
		this.diagnosisId = diagnosisId;
	}

	public TestReport getTestReport() {
		return testReport;
	}

	public void setTestReport(TestReport testReport) {
		this.testReport = testReport;
	}

	@Override
	public String toString() {
		return "TestPrescription [tpId=" + tpId + ", testPrescriptionId=" + testPrescriptionId + ", testDay=" + testDay
				+ ", tests=" + tests + ", diagnosisId=" + diagnosisId + ", testReport=" + testReport + "]";
	}
	
	

}
