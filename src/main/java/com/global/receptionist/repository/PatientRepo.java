package com.global.receptionist.repository;

import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.global.entity.PatientRecords;

@Repository
public class PatientRepo implements IPatientRepo {
	
	private SessionFactory session;

	@Autowired
	public PatientRepo(SessionFactory session) {
		super();
		this.session = session;
	}

	@Override
	@Transactional
	public void insertUpdatePatientRecords(PatientRecords patientRecords) {
		Session currentSeesion = session.getCurrentSession();
		currentSeesion.saveOrUpdate(patientRecords);
		patientRecords.setMrNo("GL"+patientRecords.getpId());
		currentSeesion.saveOrUpdate(patientRecords);
	}

	@Override
	@Transactional
	public List<PatientRecords> allPatientRecords() {
		Session currentSeesion = session.getCurrentSession();
		
		Query<PatientRecords> query = currentSeesion.createQuery("FROM PatientRecords WHERE isActive=:act order by mrNo", PatientRecords.class);
		query.setParameter("act", "true");
		return query.getResultList();
	}

	@Override
	@Transactional
	public List<PatientRecords> searchByMRNo(String MRNo) {
		Session currentSeesion = session.getCurrentSession();
		Query<PatientRecords> query = currentSeesion.createQuery("FROM PatientRecords WHERE isActive=:act AND mrNo=:no", PatientRecords.class);
		query.setParameter("no", MRNo);
		query.setParameter("act", "true");
		
		return query.getResultList();
	}

	@Override
	@Transactional
	public List<PatientRecords> searchByName(String sName) {
		Session currentSeesion = session.getCurrentSession();
		Query<PatientRecords> query = currentSeesion.createQuery("FROM PatientRecords WHERE isActive=:act AND patientName=:name", PatientRecords.class);
		query.setParameter("act", "true");
		query.setParameter("name", sName);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void deletePatientRecords(PatientRecords patientRecords) {
		Session currentSeesion = session.getCurrentSession();

		currentSeesion.saveOrUpdate(patientRecords);

	}

	@Override
	@Transactional
	public PatientRecords searchById(int id) {
		Session currentSeesion = session.getCurrentSession();
		
		return currentSeesion.get(PatientRecords.class, id);
	}

	@Override
	@Transactional
	public PatientRecords getPatientRecords(String MRNo) {
		
		Session currentSeesion = session.getCurrentSession();
		Query<PatientRecords> query = currentSeesion.createQuery("FROM PatientRecords WHERE isActive=:act AND mrNo=:no", PatientRecords.class);
		query.setParameter("no", MRNo);
		query.setParameter("act", "true");
		PatientRecords patientRecord=null;
		try {
			patientRecord=query.getSingleResult();
		}catch(NoResultException nre) {
			System.out.println(nre);
			patientRecord=new PatientRecords();
		}
		return patientRecord;
	}

}
