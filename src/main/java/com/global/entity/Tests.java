package com.global.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Tests {
	
	@Id
	@SequenceGenerator(name = "myTestSeq", sequenceName = "myTestSeq", initialValue = 89000, allocationSize = 1)
	@GeneratedValue(generator = "myTestSeq")
	private int ttId;
	
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String testId;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	@Column(unique=true)
	private String testName;
	
	@NotNull(message = "is required")
	private int testPrice;
	
	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String isActive="true";
	
	@OneToMany(mappedBy = "tests")
	private List<TestPrescription> testPrescription;

	public Tests() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTtId() {
		return ttId;
	}

	public void setTtId(int ttId) {
		this.ttId = ttId;
	}

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
	}

	public int getTestPrice() {
		return testPrice;
	}

	public void setTestPrice(int testPrice) {
		this.testPrice = testPrice;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public List<TestPrescription> getTestPrescription() {
		return testPrescription;
	}

	public void setTestPrescription(List<TestPrescription> testPrescription) {
		this.testPrescription = testPrescription;
	}

	@Override
	public String toString() {
		return "Tests [ttId=" + ttId + ", testId=" + testId + ", testName=" + testName + ", testPrice=" + testPrice
				+ ", isActive=" + isActive + ", testPrescription=" + testPrescription + "]";
	}
	
	


}
