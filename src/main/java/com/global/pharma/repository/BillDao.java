/*package com.global.pharma.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.global.entity.BillMedicine;


public class BillDao  implements IBillDao{
	private SessionFactory sessionFactory;

	@Autowired
	public BillDao(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transactional
	@Override
	public List<BillMedicine> getbill() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<BillMedicine> theQuery = currentSession.createQuery("from BillMedicine WHERE  isActive='true'", BillMedicine.class);
		// execute query and get result set
		List<BillMedicine> BillMedicines = theQuery.getResultList();

		return BillMedicines;
	}

}
*/