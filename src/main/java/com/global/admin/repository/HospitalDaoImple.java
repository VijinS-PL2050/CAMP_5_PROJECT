package com.global.admin.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.global.entity.DoctorDetails;
import com.global.entity.StaffDeatils;


@Repository
public class HospitalDaoImple implements IHospitalDao {
	
	// @Autowired //--felid injection
		private SessionFactory sessionFactory;

		@Autowired
		public HospitalDaoImple(SessionFactory sessionFactory) {
			super();
			this.sessionFactory = sessionFactory;
		}


	@Override
	@Transactional
	public List<DoctorDetails> getDoctor() {
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				Query<DoctorDetails> theQuery = currentSession.createQuery("FROM DoctorDetails WHERE isActive=:act order by doctorName", DoctorDetails.class);

				// execute query and get result set
				theQuery.setParameter("act", "true");

				List<DoctorDetails> doc = theQuery.getResultList();

				return theQuery.getResultList();
			}

	

	@Override
	@Transactional
	public List<StaffDeatils> getStaff() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		Query<StaffDeatils> theQuery = currentSession.createQuery("FROM StaffDeatils WHERE isActive=:act order by staffname", StaffDeatils.class);

		// execute query and get result set
		theQuery.setParameter("act", "true");

		List<StaffDeatils> sta = theQuery.getResultList();

		return theQuery.getResultList();
	}

	
	@Override
	@Transactional
	public void saveDoctorDetails(DoctorDetails theDoctor) {
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				
				currentSession.saveOrUpdate(theDoctor);
				theDoctor.setDoctorId("DR"+theDoctor.getDoId());
				currentSession.saveOrUpdate(theDoctor);
		
	}

	
	@Override
	@Transactional
	public void saveStaffDeatils(StaffDeatils theStaff) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theStaff);
		theStaff.setStaffid("SI"+theStaff.getsId());
		currentSession.saveOrUpdate(theStaff);


	}

	
	@Override
	@Transactional
	public DoctorDetails searchById(int id) {
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				DoctorDetails theDoctor = currentSession.get(DoctorDetails.class, id);

				return theDoctor;
			}
	

	
	@Override
	@Transactional
	public StaffDeatils searchByIds(int id) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		StaffDeatils theStaff = currentSession.get(StaffDeatils.class, id);

		return theStaff;
	}

	

	
	@Override
	@Transactional
	public void deleteDoctor(DoctorDetails theDoctor) {
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				// delete the customer
				currentSession.remove(theDoctor);
	}

	
	@Override
	@Transactional
	public void deleteStaff(StaffDeatils theStaff) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// delete the customer
		currentSession.remove(theStaff);
	}

	
	@Override
	@Transactional
	public List<DoctorDetails> searchByName(String Name) {
		// get the current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();

				Query<DoctorDetails> theQuery = currentSession.createQuery("FROM DoctorDetails WHERE doctorName=:name", DoctorDetails.class);
				theQuery.setParameter("name", Name);

				// execute query and get result set

				List<DoctorDetails> doctorSearch = theQuery.getResultList();

				return doctorSearch;
	}

	
	@Override
	@Transactional
	public List<StaffDeatils> searchByNames(String Name) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		Query<StaffDeatils> theQuery = currentSession.createQuery("FROM StaffDeatils WHERE staffname=:name", StaffDeatils.class);
		theQuery.setParameter("name", Name);

		// execute query and get result set

		List<StaffDeatils> staffSearch = theQuery.getResultList();

		return staffSearch;
	}


	@Override
	@Transactional
	public DoctorDetails getDoctorupdate(int heId) {
		Session currentSession = sessionFactory.getCurrentSession();
		DoctorDetails doc=currentSession.get(DoctorDetails.class,heId);
		return doc;
	}


	@Override
	@Transactional
	public StaffDeatils getStaffupdate(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		StaffDeatils sta=currentSession.get(StaffDeatils.class,theId);

		return sta;
	}


	@Override
	@Transactional
	public void disableDoc(DoctorDetails thedoc) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(thedoc);
		
	}


	@Override
	@Transactional
	public void disableSta(StaffDeatils thesta) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(thesta);		
	}


	
}
