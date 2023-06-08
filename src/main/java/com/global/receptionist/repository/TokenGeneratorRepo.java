package com.global.receptionist.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.global.entity.PatientRecords;
import com.global.entity.TokenGenarator;

@Repository
public class TokenGeneratorRepo implements ITokenGeneratorRepo {

	private SessionFactory session;

	@Autowired
	public TokenGeneratorRepo(SessionFactory session) {
		super();
		this.session = session;
	}

	@Override
	@Transactional
	public void insertUpdateTokenGenarator(TokenGenarator tokenGenarator) {
		Session currentSeesion = session.getCurrentSession();
		currentSeesion.saveOrUpdate(tokenGenarator);

	}

	@Override
	@Transactional
	public List<TokenGenarator> allTokenGenarator() {
		Session currentSeesion = session.getCurrentSession();

		Query<TokenGenarator> query = currentSeesion
				.createQuery("FROM TokenGenarator WHERE isActive=:act order by tokenNo", TokenGenarator.class);
		query.setParameter("act", "true");
		return query.getResultList();
	}

	@Override
	@Transactional
	public List<TokenGenarator> searchByMRNo(int aId) {
		return null;
	}

	@Override
	@Transactional
	public List<TokenGenarator> searchByToken(String tokenId) {
		Session currentSeesion = session.getCurrentSession();

		Query<TokenGenarator> query = currentSeesion
				.createQuery("FROM TokenGenarator WHERE isActive=:act AND tokenNo=:no", TokenGenarator.class);
		query.setParameter("act", "true");
		query.setParameter("no", tokenId);
		return query.getResultList();
	}

	@Override
	@Transactional
	public List<TokenGenarator> searchByBooking(int aId) {
		Session currentSeesion = session.getCurrentSession();

		Query<TokenGenarator> query = currentSeesion.createQuery("FROM TokenGenarator WHERE isActive=:act AND aId=:no",
				TokenGenarator.class);
		query.setParameter("act", "true");
		query.setParameter("no", aId);
		return query.getResultList();
	}

	@Override
	@Transactional
	public void deleteTokenGenarator(TokenGenarator tokenGenarator) {
		Session currentSeesion = session.getCurrentSession();
		currentSeesion.saveOrUpdate(tokenGenarator);
	}

	@Override
	@Transactional
	public TokenGenarator searchById(int id) {
		Session currentSeesion = session.getCurrentSession();

		Query<TokenGenarator> query = currentSeesion.createQuery("FROM TokenGenarator WHERE isActive=:act AND tId=:no",
				TokenGenarator.class);
		query.setParameter("act", "true");
		query.setParameter("no", id);
		return query.getSingleResult();
	}

	@Override
	@Transactional
	public TokenGenarator getTokenGenarator(String tokenNo) {

		return null;
	}

}
