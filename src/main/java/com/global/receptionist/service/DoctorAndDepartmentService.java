package com.global.receptionist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.entity.DoctorDepartment;
import com.global.entity.DoctorDetails;
import com.global.receptionist.repository.IDoctorAndDepartmentRepo;

@Service
public class DoctorAndDepartmentService implements IDoctorAndDepartmentService {
	
	
	private IDoctorAndDepartmentRepo doctorAndDepartmentRepo;
	
	@Autowired
	public DoctorAndDepartmentService(IDoctorAndDepartmentRepo doctorAndDepartmentRepo) {
		super();
		this.doctorAndDepartmentRepo = doctorAndDepartmentRepo;
	}

	@Override
	public List<DoctorDetails> getAllDoctorDetailss(int deptId) {
		
		return doctorAndDepartmentRepo.getAllDoctorDetailss(deptId);
	}

	@Override
	public List<DoctorDepartment> getAllDepartment() {
		return doctorAndDepartmentRepo.getAllDepartment();
	}

	@Override
	public DoctorDetails getDoctorDetails(int doId) {
		// TODO Auto-generated method stub
		return doctorAndDepartmentRepo.getDoctorDetails(doId);
	}

	@Override
	public void updateForToken(DoctorDetails doctorDetails) {
		doctorAndDepartmentRepo.updateForToken(doctorDetails);
		
	}

	@Override
	public List<DoctorDetails> allDoctorDetailss() {
		// TODO Auto-generated method stub
		return doctorAndDepartmentRepo.allDoctorDetailss();
	}

}
