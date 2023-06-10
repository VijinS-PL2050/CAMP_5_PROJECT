package com.global.admin.repository;

import java.util.List;

import com.global.entity.Role;

public interface IRoleDao {

	// insert role
	public void saveRole(Role ro);

	public Role getRole(int id);

	// List role
	public List<Role> getRole();

	//disable roleDetails
	public void disableRole(Role ro);
	
	//Search by RoleId
	public Role searchById(int id);
	
	
}
