package com.global.admin.service;

import java.util.List;

import com.global.entity.Role;

public interface IRoleService {

	// insert role
	public void saveRole(Role ro);

	public Role getRole(int id);

	// List staffDetails
	public List<Role> getRole();

	//disable roleDetails
	public void disableRole(Role ro);
		
	//Search by RoleId
		public Role searchById(int id);
		
}
