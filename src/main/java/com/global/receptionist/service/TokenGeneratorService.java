package com.global.receptionist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.entity.TokenGenarator;
import com.global.receptionist.repository.ITokenGeneratorRepo;

@Service
public class TokenGeneratorService implements ITokenGeneratorService {
	
	private ITokenGeneratorRepo repo;
	
	@Autowired
	public TokenGeneratorService(ITokenGeneratorRepo repo) {
		super();
		this.repo = repo;
	}

	@Override
	public void insertUpdateTokenGenarator(TokenGenarator tokenGenarator) {
		repo.insertUpdateTokenGenarator(tokenGenarator);

	}

	@Override
	public List<TokenGenarator> allTokenGenarator() {
		
		return repo.allTokenGenarator();
	}

	@Override
	public List<TokenGenarator> searchByMRNo(int aId) {
		
		return repo.searchByMRNo(aId);
	}

	@Override
	public List<TokenGenarator> searchByToken(String tokenId) {
		// TODO Auto-generated method stub
		return repo.searchByToken(tokenId);
	}

	@Override
	public List<TokenGenarator> searchByBooking(int aId) {
		
		return repo.searchByBooking(aId);
	}

	@Override
	public void deleteTokenGenarator(TokenGenarator tokenGenarator) {
		tokenGenarator.setIsActive("false");
		repo.deleteTokenGenarator(tokenGenarator);

	}

	@Override
	public TokenGenarator searchById(int id) {
		
		return repo.searchById(id);
	}

	@Override
	public TokenGenarator getTokenGenarator(String MRNo) {
		
		return repo.getTokenGenarator(MRNo);
	}

}
