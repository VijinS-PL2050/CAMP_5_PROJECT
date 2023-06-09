package com.global.receptionist.repository;

import java.util.List;

import com.global.entity.DoctorDepartment;
import com.global.entity.DoctorDetails;

public interface IDoctorAndDepartmentRepo {
	
	
	public List<DoctorDetails> getAllDoctorDetailss(int deptId);
	public List<DoctorDepartment> getAllDepartment();
	public DoctorDetails getDoctorDetails(int doId);
	public void updateForToken(DoctorDetails doctorDetails);
	
	

}
