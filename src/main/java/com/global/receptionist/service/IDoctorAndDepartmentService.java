package com.global.receptionist.service;

import java.util.List;

import com.global.entity.DoctorDepartment;
import com.global.entity.DoctorDetails;

public interface IDoctorAndDepartmentService {
	
	public List<DoctorDetails> getAllDoctorDetailss();
	public List<DoctorDepartment> getAllDepartment();
	public DoctorDetails getDoctorDetails(int doId);
	public void updateForToken(DoctorDetails doctorDetails);
}
