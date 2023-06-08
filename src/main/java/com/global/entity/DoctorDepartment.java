package com.global.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

@Entity
@Component
public class DoctorDepartment {

	@Id
	@SequenceGenerator(name = "myDepSeq", sequenceName = "myDepSeq", initialValue = 200, allocationSize = 1)
	@GeneratedValue(generator = "myDepSeq")
	private int dId;

	@Size(min = 1, max = 25)
	@Column(unique = true)
	private String departmentId;

	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	@Column(unique = true)
	private String departmentName;

	@NotNull(message = "is required")
	@Size(min = 1, max = 25)
	private String isActive = "true";

	@OneToMany(mappedBy = "doctorDepartment", fetch = FetchType.EAGER)
	private List<DoctorDetails> doctorDetails;

	public DoctorDepartment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getdId() {
		return dId;
	}

	public void setdId(int dId) {
		this.dId = dId;
	}

	public String getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public List<DoctorDetails> getDoctorDetails() {
		return doctorDetails;
	}

	public void setDoctorDetails(List<DoctorDetails> doctorDetails) {
		this.doctorDetails = doctorDetails;
	}

	@Override
	public String toString() {
		return "DoctorDepartment [dId=" + dId + ", departmentId=" + departmentId + ", departmentName=" + departmentName
				+ ", isActive=" + isActive + ", doctorDetails=" + doctorDetails + "]";
	}

}
