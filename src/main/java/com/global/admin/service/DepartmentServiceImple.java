package com.global.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.admin.repository.IDepartmentDao;
import com.global.entity.DoctorDepartment;
import com.global.entity.User;

@Service
public class DepartmentServiceImple implements IDepartmentService {

	@Autowired
	private IDepartmentDao deptDao;

	@Override
	public void saveDepartment(DoctorDepartment dec) {

		// call dao
		deptDao.saveDepartment(dec);
	}

	@Override
	public List<DoctorDepartment> getAllDepartment() {
		return deptDao.getAllDepartment();
	}

	@Override
	public List<DoctorDepartment> getDoctorDepartment() {
		return deptDao.getDoctorDepartment();

	}

	@Override
	public void disableDoctorDepartment(DoctorDepartment dep) {
		dep.setIsActive("false");
		deptDao.disableDoctorDepartment(dep);
						
	}

	@Override
	public DoctorDepartment searchById(int id) {
		return deptDao.searchById(id);

	}

}
