package com.global.admin.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.global.entity.DoctorDepartment;
import com.global.entity.Role;
import com.global.entity.User;

@Repository
public class UserDaoImple implements IUserDao {

	// @Autowired //--felid injection
	private SessionFactory sessionFactory;

	@Autowired
	public UserDaoImple(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void saveuser(User use) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(use);
		use.setUserId("UI"+use.getuId());
		currentSession.saveOrUpdate(use);

	}

	@Override
	@Transactional
	public List<Role> getAllRole() {

		Session currentSeesion = sessionFactory.getCurrentSession();

		Query<Role> query = currentSeesion.createQuery("FROM Role WHERE isActive=:act order by roleName", Role.class);

		query.setParameter("act", "true");

		return query.getResultList();

	}

	@Override
	@Transactional
	public User getLastUser() {
		Session currentSeesion = sessionFactory.getCurrentSession();
		Query<User> query = currentSeesion.createQuery("FROM User WHERE isActive=:act order by uId DESC", User.class);
		query.setParameter("act", "true");
		query.setMaxResults(1);
		System.out.println(query.uniqueResult().getUserId());
		System.out.println(query.uniqueResult().getRole().getRoleName());
		return query.uniqueResult();
	}

}
