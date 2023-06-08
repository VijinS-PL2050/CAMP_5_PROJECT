package com.global.login.service;

import com.global.entity.User;

public interface ILoginSevice {

	public User getRoleFromLogin(String username, String password);
}
