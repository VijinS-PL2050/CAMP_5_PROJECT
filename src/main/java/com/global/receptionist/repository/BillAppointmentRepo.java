package com.global.receptionist.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.global.entity.Appointment;
import com.global.entity.BillAppoinment;

@Repository
public class BillAppointmentRepo implements IBillAppointmentRepo {
	
	private SessionFactory session;

	@Autowired
	public BillAppointmentRepo(SessionFactory session) {
		super();
		this.session = session;
	}

	@Override
	@Transactional
	public void insertUpdateBillAppoinment(BillAppoinment billAppoinment) {
		Session currentSeesion = session.getCurrentSession();
		currentSeesion.saveOrUpdate(billAppoinment);
		billAppoinment.setBillAppoinmentNo("BL"+billAppoinment.getBaId());
		currentSeesion.saveOrUpdate(billAppoinment);

	}

	@Override
	@Transactional
	public List<BillAppoinment> allBillAppoinment() {
		Session currentSeesion = session.getCurrentSession();
		Query<BillAppoinment> query = currentSeesion.createQuery("FROM BillAppoinment WHERE isActive=:act order by billAppoinmentNo", BillAppoinment.class);
		query.setParameter("act", "true");
		return query.getResultList();
	}

	@Override
	@Transactional
	public List<BillAppoinment> searchByAppoinment(int aId) {
		Session currentSeesion = session.getCurrentSession();
		Query<BillAppoinment> query = currentSeesion.createQuery("FROM BillAppoinment WHERE isActive=:act AND aId=:no", BillAppoinment.class);
		query.setParameter("act", "true");
		query.setParameter("no", aId);
		return query.getResultList();
	}

	@Override
	@Transactional
	public List<BillAppoinment> searchByBillAppoinment(String billNo) {
		Session currentSeesion = session.getCurrentSession();
		Query<BillAppoinment> query = currentSeesion.createQuery("FROM BillAppoinment WHERE isActive=:act AND billAppoinmentNo=:no", BillAppoinment.class);
		query.setParameter("act", "true");
		query.setParameter("no", billNo);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void deleteBillAppoinment(BillAppoinment billAppoinment) {
		Session currentSeesion = session.getCurrentSession();
		currentSeesion.saveOrUpdate(billAppoinment);

	}

	@Override
	@Transactional
	public BillAppoinment searchByaId(int id) {
		Session currentSeesion = session.getCurrentSession();
		Query<BillAppoinment> query = currentSeesion.createQuery("FROM BillAppoinment WHERE isActive=:act AND baId=:no", BillAppoinment.class);
		query.setParameter("act", "true");
		query.setParameter("no", id);

		return query.getSingleResult();
	}

	@Override
	@Transactional
	public BillAppoinment getLastBillAppoinment() {
		Session currentSeesion = session.getCurrentSession();
		Query<BillAppoinment> query = currentSeesion.createQuery("FROM BillAppoinment WHERE isActive=:act order by baId DESC", BillAppoinment.class);
		query.setParameter("act", "true");
		query.setMaxResults(1);
		return query.uniqueResult();
	}

}
