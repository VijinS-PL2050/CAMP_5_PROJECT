package com.global.admin.service;
	import java.util.List;

import com.global.entity.Role;
import com.global.entity.User;
	
	
	public interface IUserService {
		
		//insert user
			public void saveuser(User use);
			public List<Role> getAllRole();
			public User getLastUser();

			
	}


