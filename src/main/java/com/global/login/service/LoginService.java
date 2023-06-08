package com.global.login.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.entity.User;
import com.global.login.repository.ILoginRepo;

@Service
public class LoginService implements ILoginSevice {
	
	@Autowired
	private ILoginRepo repo;


	@Override
	public User getRoleFromLogin(String username, String password) {
		
		return repo.getRoleFromLogin(username, password);
	}

}
