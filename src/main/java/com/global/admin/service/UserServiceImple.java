package com.global.admin.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.admin.repository.IUserDao;
import com.global.entity.Role;
import com.global.entity.User;

@Service
public class UserServiceImple implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	public void saveuser(User use) {
		// call dao
		userDao.saveuser(use);

	}

	@Override
	public List<Role> getAllRole() {
		return userDao.getAllRole();

	}

	@Override
	public User getLastUser() {
		
		return userDao.getLastUser();
	}

}
