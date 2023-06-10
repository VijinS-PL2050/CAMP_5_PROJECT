package com.global.admin.service;

import java.util.List;

import com.global.entity.DoctorDetails;
import com.global.entity.StaffDeatils;

public interface IHospitalService {

	//list DoctorDetails
	public List<DoctorDetails> getDoctor();
	
	//List staffDetails
	public List<StaffDeatils > getStaff();
	
	//insert doctor
	public void saveDoctorDetails(DoctorDetails theDoctor);
	
	//update DoctorDetails
	public DoctorDetails getDoctorupdate(int theId);
	
	//insert staff details
	public void addStaffDeatils(StaffDeatils theStaff);
	
	//update StaffDetails
	public StaffDeatils getStaffupdate(int theId);
	
	
	//Search by doctorId
	public DoctorDetails searchById(int id);
	
	//disable doctor
	public void disableDoc(DoctorDetails thedoc);
	
	//Search by StaffId
	public StaffDeatils searchByIds(int id);
	
	//disable staffDetails
	public void disableSta(StaffDeatils thesta);
	
	
	//delete doctorDetails
	public void deleteDoctor (DoctorDetails theDoctor);
	
	//delete StaffDetails
	public void deleteStaff (StaffDeatils theStaff);
	
	//Search by DoctorName
	public List<DoctorDetails> searchByName(String Name);
	
	//Search by StaffName
	public List<StaffDeatils> searchByNames(String Name);
	
	
}
