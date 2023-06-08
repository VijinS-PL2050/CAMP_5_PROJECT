package com.global.login.repository;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.global.entity.User;

@Repository
public class LoginRepo implements ILoginRepo {

	private SessionFactory session;

	@Autowired
	public LoginRepo(SessionFactory session) {
		super();
		this.session = session;
	}

	@Override
	@Transactional
	public User getRoleFromLogin(String username, String password) {

		User user = null;
		Session currentSession = session.getCurrentSession();
		try {
			Query<User> query = currentSession.createQuery("FROM User WHERE userName =:user AND password =:pass AND isActive=:act", User.class);
			query.setParameter("user", username);
			query.setParameter("pass", password);
			query.setParameter("act", "true");
			user = query.getSingleResult();
		} catch (NoResultException e) {
			System.out.println("wrong username and password");
		}
		return user;

	}

}
