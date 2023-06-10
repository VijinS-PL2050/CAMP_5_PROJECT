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

@Repository
public class DepartmentDaoImple implements IDepartmentDao {
	// @Autowired //--felid injection
	private SessionFactory sessionFactory;

	@Autowired
	public DepartmentDaoImple(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void saveDepartment(DoctorDepartment dec) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(dec);
		dec.setDepartmentId("Dep" + dec.getdId());
		currentSession.saveOrUpdate(dec);

	}

	@Override
	@Transactional
	public List<DoctorDepartment> getAllDepartment() {

		Session currentSeesion = sessionFactory.getCurrentSession();

		Query<DoctorDepartment> query = currentSeesion.createQuery(
				"FROM DoctorDepartment WHERE isActive=:act order by departmentName", DoctorDepartment.class);

		query.setParameter("act", "true");

		return query.getResultList();

	}

	@Override
	@Transactional

	public List<DoctorDepartment> getDoctorDepartment() {
		Session currentSeesion = sessionFactory.getCurrentSession();

		Query<DoctorDepartment> query = currentSeesion.createQuery(
				"FROM DoctorDepartment WHERE isActive=:act order by departmentName", DoctorDepartment.class);

		query.setParameter("act", "true");

		return query.getResultList();

	}

	@Override
	@Transactional

	public void disableDoctorDepartment(DoctorDepartment dep) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(dep);			
	}

	@Override
	@Transactional
	public DoctorDepartment searchById(int id) {
		Session currentSession = sessionFactory.getCurrentSession();

		DoctorDepartment the = currentSession.get(DoctorDepartment.class, id);

		return the;
	}

}
