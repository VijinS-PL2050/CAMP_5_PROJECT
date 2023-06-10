package com.global.admin.service;

import java.util.List;

import com.global.entity.DoctorDepartment;

public interface IDepartmentService {

	//insert department
	public void saveDepartment(DoctorDepartment dec);
	public List<DoctorDepartment> getAllDepartment();

	// List departmentDetails
	public List<DoctorDepartment> getDoctorDepartment();
	
	//disable DoctorDepartmentDetails
	public void disableDoctorDepartment(DoctorDepartment dep);
	
	//Search by DoctorDepartmentId
	public DoctorDepartment searchById(int id);
	
}
