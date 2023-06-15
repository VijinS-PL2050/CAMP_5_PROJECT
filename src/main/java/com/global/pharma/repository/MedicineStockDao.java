package com.global.pharma.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.global.entity.BillMedicine;
import com.global.entity.Diagnosis;
import com.global.entity.MedicinePrescription;
import com.global.entity.MedicinesStock;

@Repository
public class MedicineStockDao implements IMedicineStockDao {
	private SessionFactory sessionFactory;

	@Autowired
	public MedicineStockDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public List<MedicinesStock> getmedicine() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<MedicinesStock> theQuery = currentSession.createQuery("from MedicinesStock WHERE  isActive='true'", MedicinesStock.class);
		// execute query and get result set
		List<MedicinesStock> MedicinesStocks = theQuery.getResultList();

		return MedicinesStocks;
	}

	@Transactional
	public void savemedicine(MedicinesStock theCustomer) {
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println(theCustomer);
		// save the customer
		currentSession.saveOrUpdate(theCustomer);
		theCustomer.setMedicineId("MED"+theCustomer.getMsId());
		currentSession.saveOrUpdate(theCustomer);

	}

	@Transactional
	public MedicinesStock getmedicine(int theId) {
		Session CurrentSession = sessionFactory.getCurrentSession();
		MedicinesStock theCustomer = CurrentSession.get(MedicinesStock.class, theId);

		return theCustomer;
	}

	@Override
	@Transactional
	public MedicinesStock getdelete(int theId) {
		Session CurrentSession = sessionFactory.getCurrentSession();
		MedicinesStock theCustomer = CurrentSession.get(MedicinesStock.class, theId);
		CurrentSession.delete(theCustomer);
		// TODO Auto-generated method stub
		return theCustomer;
	}

	@Override
	@Transactional
	public List<MedicinesStock> searchmedicine(String theName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<MedicinesStock> theQuery = currentSession
				.createQuery("from MedicinesStock where medicineName=:b", MedicinesStock.class)
				.setParameter("b", theName);
		List<MedicinesStock> theCustomer = theQuery.getResultList();
		return theCustomer;
	}

	@Override
	@Transactional
	public List<MedicinePrescription> getMedicinePrescription() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<MedicinePrescription> theQuery = currentSession
				.createQuery("from MedicinePrescription WHERE isActive='true'", MedicinePrescription.class);
		// execute query and get result set

		List<MedicinePrescription> Medicines = theQuery.getResultList();

		return Medicines;
	}

	@Override
	@Transactional
	public List<MedicinePrescription> searchmedicineprescription(String theName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<MedicinePrescription> theQuery = currentSession
				.createQuery("from MedicinePrescription where medicinePrescriptionId=:b", MedicinePrescription.class)
				.setParameter("b", theName);
		List<MedicinePrescription> theCustomer = theQuery.getResultList();
		return theCustomer;
	}

	@Override
	@Transactional
	public List<MedicinePrescription> getMedicineveiw() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<MedicinePrescription> theQuery = currentSession
				.createQuery("from MedicinePrescription WHERE isActive='true'", MedicinePrescription.class);
		// execute query and get result set

		List<MedicinePrescription> Medicines = theQuery.getResultList();

		return Medicines;
	}

	@Override
	@Transactional
	public List<MedicinePrescription> searchmedicineVeiw(String theName) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<MedicinePrescription> theQuery = currentSession.createQuery("from MedicinePrescription where medicinePrescriptionId=:b", MedicinePrescription.class);
		theQuery.setParameter("b", theName);
		List<MedicinePrescription> theCustomer = theQuery.getResultList();
		return theCustomer;
	}

	@Override
	@Transactional
	public void getmedicineDisable(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();

		// Update isActive status
		MedicinesStock medicine = currentSession.get(MedicinesStock.class, theId);
		medicine.setIsActive("false"); // Assuming isActive is a boolean property
		currentSession.saveOrUpdate(medicine);
	}

	

	@Override
	@Transactional
	public List<MedicinePrescription> getveiwprisccription(int theId) {
		// TODO Auto-generated method stub
		Session currentSession = sessionFactory.getCurrentSession();
		Query<MedicinePrescription> query=currentSession.createQuery("FROM MedicinePrescription WHERE isActive=:act AND diId=:dI", MedicinePrescription.class);
		query.setParameter("act", "true");
		query.setParameter("dI", theId);
		return query.getResultList();
	}

	
	

	@Override
	@Transactional
	public List<BillMedicine> getveiwprisccrip(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<BillMedicine> query=currentSession.createQuery("FROM  BillMedicine  WHERE isActive=:act AND diId=:dI", BillMedicine.class);
		query.setParameter("act", "true");
		query.setParameter("dI", theId);
		return query.getResultList();
	
	
}

	@Override
	@Transactional
	public List<MedicinePrescription> getbill() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<MedicinePrescription> theQuery = currentSession
				.createQuery("from MedicinePrescription WHERE isActive='true'", MedicinePrescription.class);
		// execute query and get result set
		

		List<MedicinePrescription> Medicines = theQuery.getResultList();

		return Medicines;
	}
	@Override
	@Transactional
	public List<MedicinePrescription> getbill(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<MedicinePrescription> query=currentSession.createQuery("FROM MedicinePrescription WHERE isActive=:act AND diId=:dI", MedicinePrescription.class);
		query.setParameter("act", "false");
		query.setParameter("dI", theId);
		
		return query.getResultList();
	}
	@Override
	@Transactional
	public void getbillDisable(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();

		// Update isActive status
		MedicinePrescription medicine = currentSession.get(MedicinePrescription.class, theId);
		medicine.setIsActive("false"); // Assuming isActive is a boolean property
		currentSession.saveOrUpdate(medicine);
	}
	}

	
	
