package com.global.receptionist.repository;

import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.global.entity.Appointment;

@Repository
public class AppointmentRepo implements IAppointmentRepo {

	private SessionFactory session;

	@Autowired
	public AppointmentRepo(SessionFactory session) {
		super();
		this.session = session;
	}

	@Override
	@Transactional
	public void insertUpdateAppointment(Appointment appointment) {
		Session currentSeesion = session.getCurrentSession();
		currentSeesion.saveOrUpdate(appointment);
		appointment.setBookingNo("AP" + appointment.getaId());
		currentSeesion.saveOrUpdate(appointment);

	}

	@Override
	@Transactional
	public List<Appointment> allAppointments() {
		Session currentSeesion = session.getCurrentSession();
		Query<Appointment> query = currentSeesion.createQuery("FROM Appointment WHERE isActive=:act order by bookingNo",
				Appointment.class);
		query.setParameter("act", "true");
		return query.getResultList();
	}

	@Override
	@Transactional
	public List<Appointment> searchByMRNo(int pId) {
		Session currentSeesion = session.getCurrentSession();
		Query<Appointment> query = currentSeesion.createQuery("FROM Appointment WHERE isActive=:act AND pId=:no",
				Appointment.class);
		query.setParameter("no", pId);
		query.setParameter("act", "true");
		return query.getResultList();
	}

	@Override
	@Transactional
	public List<Appointment> searchByAppointmentId(String sAid) {
		Session currentSeesion = session.getCurrentSession();
		Query<Appointment> query = currentSeesion.createQuery("FROM Appointment WHERE isActive=:act AND bookingNo=:no",
				Appointment.class);
		query.setParameter("no", sAid);
		query.setParameter("act", "true");
		return query.getResultList();
	}

	@Override
	@Transactional
	public void deleteAppointment(Appointment appointment) {
		Session currentSeesion = session.getCurrentSession();
		currentSeesion.saveOrUpdate(appointment);

	}

	@Override
	@Transactional
	public Appointment searchByaId(int id) {
		Session currentSeesion = session.getCurrentSession();
		Query<Appointment> query = currentSeesion.createQuery("FROM Appointment WHERE isActive=:act AND aId=:no",
				Appointment.class);
		query.setParameter("no", id);
		query.setParameter("act", "true");
		return query.getSingleResult();
	}

	@Override
	@Transactional
	public Appointment getAppointment(String bookNo) {
		Session currentSeesion = session.getCurrentSession();
		Query<Appointment> query = currentSeesion.createQuery("FROM Appointment WHERE isActive=:act AND bookingNo=:no",
				Appointment.class);
		query.setParameter("no", bookNo);
		query.setParameter("act", "true");
		Appointment appointment = null;
		try {
			appointment = query.getSingleResult();
		} catch (NoResultException nre) {
			System.out.println(nre);
			appointment = new Appointment();
		}
		return appointment;
	}

}
