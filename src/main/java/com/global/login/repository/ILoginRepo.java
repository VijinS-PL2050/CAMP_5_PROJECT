package com.global.login.repository;

import com.global.entity.User;

public interface ILoginRepo {

	public User getRoleFromLogin(String username, String password);
}
