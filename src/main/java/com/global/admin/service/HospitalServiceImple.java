package com.global.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.admin.repository.IHospitalDao;
import com.global.entity.DoctorDetails;
import com.global.entity.StaffDeatils;

@Service
public class HospitalServiceImple implements IHospitalService {
	
	@Autowired
	private IHospitalDao hospitalDao;


	@Override
	public List<DoctorDetails> getDoctor() {
		return hospitalDao.getDoctor();
	}

	@Override
	public List<StaffDeatils> getStaff() {
		return hospitalDao.getStaff();
	}

	@Override
	public void saveDoctorDetails(DoctorDetails theDoctor) {
		// call dao
		hospitalDao.saveDoctorDetails(theDoctor);

	}

	

	@Override
	public DoctorDetails searchById(int id) {
		return hospitalDao.searchById(id);

	}

	@Override
	public StaffDeatils searchByIds(int id) {
		return hospitalDao.searchByIds(id);

	}

	@Override
	public void deleteDoctor(DoctorDetails theDoctor) {
		// call dao
		hospitalDao.deleteDoctor(theDoctor);
	}

	@Override
	public void deleteStaff(StaffDeatils theStaff) {
		// call dao
				hospitalDao.deleteStaff(theStaff);
	}

	@Override
	public List<DoctorDetails> searchByName(String Name) {
		return hospitalDao.searchByName(Name);
	}

	@Override
	public List<StaffDeatils> searchByNames(String Name) {
		return hospitalDao.searchByNames(Name);
	}

	@Override
	public void addStaffDeatils(StaffDeatils theStaff) {
		hospitalDao.saveStaffDeatils(theStaff);		
	}

	@Override
	public DoctorDetails getDoctorupdate(int theId) {
		return hospitalDao.getDoctorupdate(theId);
	}

	@Override
	public StaffDeatils getStaffupdate(int theId) {
		return hospitalDao.getStaffupdate(theId);

	}

	
	public void disableDoc(DoctorDetails thedoc) {
		thedoc.setIsActive("false");
		hospitalDao.disableDoc(thedoc);
		
	}

	@Override
	public void disableSta(StaffDeatils thesta) {
		thesta.setIsActive("false");
		hospitalDao.disableSta(thesta);		
	}

	/*
	 * @Override public DoctorDetails searchDoctorDetails(int doId) {
	 * 
	 * return hospitalDao.getDoctorupdate(doId); }
	 * 
	 * @Override public void disabledoctorDetails(DoctorDetails theid) {
	 * hospitalDao.disabledoctorDetails(theid);
	 * 
	 * }
	 * 
	 * @Override public StaffDeatils searchStaffDetails(int sId) { return
	 * hospitalDao.getStaffupdate(sId); }
	 * 
	 * @Override public void disableStaffDetails(StaffDeatils theid) {
	 * theid.setIsActive("false");
	 * 
	 * }
	 */

}
