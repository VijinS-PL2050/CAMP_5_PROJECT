package com.global.receptionist.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.global.entity.DoctorDepartment;
import com.global.entity.DoctorDetails;

@Repository
public class DoctorAndDepartmentRepo implements IDoctorAndDepartmentRepo {
	
	
	private SessionFactory session;

	@Autowired
	public DoctorAndDepartmentRepo(SessionFactory session) {
		super();
		this.session = session;
	}
	
	
	

	public DoctorAndDepartmentRepo() {
		
	}




	@Override
	@Transactional
	public List<DoctorDetails> getAllDoctorDetailss(int deptId) {
		Session currentSeesion = session.getCurrentSession();
		Query<DoctorDetails> query = currentSeesion.createQuery("FROM DoctorDetails WHERE isActive=:act AND dId=:ddID order by doctorName", DoctorDetails.class);
		query.setParameter("act", "true");
		query.setParameter("ddID", deptId);
		return query.getResultList();
	}

	@Override
	@Transactional
	public List<DoctorDepartment> getAllDepartment() {
		Session currentSeesion = session.getCurrentSession();
		Query<DoctorDepartment> query = currentSeesion.createQuery("FROM DoctorDepartment WHERE isActive=:act order by departmentName", DoctorDepartment.class);
		query.setParameter("act", "true");
		return query.getResultList();
	}

	@Override
	@Transactional
	public DoctorDetails getDoctorDetails(int doId) {
		Session currentSeesion = session.getCurrentSession();
		return currentSeesion.get(DoctorDetails.class, doId);
	}

	@Override
	@Transactional
	public void updateForToken(DoctorDetails doctorDetails) {
		Session currentSeesion = session.getCurrentSession();
		currentSeesion.saveOrUpdate(doctorDetails);
		
	}

}
