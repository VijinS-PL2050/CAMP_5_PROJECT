package com.global.admin.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.global.entity.Role;

@Repository
public class RoleDaoImple implements IRoleDao {

	// @Autowired //--felid injection
	private SessionFactory sessionFactory;

	@Autowired
	public RoleDaoImple(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void saveRole(Role ro) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(ro);
		ro.setRoleId("RL"+ro.getrId());
		currentSession.saveOrUpdate(ro);
		
	}
	
	@Override
	@Transactional
	public Role getRole(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Role> query=currentSession.createQuery("FROM Role WHERE rId=:id AND isActive=:act", Role.class);
		query.setParameter("id", id);
		query.setParameter("act", "true");
		return query.getSingleResult();
	}

	@Override
	@Transactional
	public List<Role> getRole() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		Query<Role> theQuery = currentSession.createQuery("FROM Role WHERE isActive=:act order by roleName", Role.class);

		// execute query and get result set
		theQuery.setParameter("act", "true");

		List<Role> doc = theQuery.getResultList();

		return theQuery.getResultList();
	}

	@Override
	@Transactional
	public void disableRole(Role ro) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(ro);		
	}

	@Override
	@Transactional
	public Role searchById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();

		Role therole = currentSession.get(Role.class, id);

		return therole;
	}

	

}
