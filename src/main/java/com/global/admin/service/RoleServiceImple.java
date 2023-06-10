package com.global.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.admin.repository.IRoleDao;
import com.global.entity.DoctorDepartment;
import com.global.entity.Role;

@Service
public class RoleServiceImple implements IRoleService {
	
	@Autowired
	private IRoleDao roleDao;

	@Override
	public void saveRole(Role ro) {

		// call dao
		roleDao.saveRole(ro);

	}

	@Override
	public Role getRole(int id) {
		return roleDao.getRole(id);
	}

	@Override
	public List<Role> getRole() {
		return roleDao.getRole();		
	}

	@Override
	public void disableRole(Role ro) {
		ro.setIsActive("false");
		roleDao.disableRole(ro);
				
	}

	@Override
	public Role searchById(int id) {
		return roleDao.searchById(id);
		
	}

	

}
