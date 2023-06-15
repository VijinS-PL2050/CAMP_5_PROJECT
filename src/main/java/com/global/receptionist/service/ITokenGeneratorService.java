package com.global.receptionist.service;

import java.util.List;

import com.global.entity.TokenGenarator;

public interface ITokenGeneratorService {
	
	public void insertUpdateTokenGenarator(TokenGenarator tokenGenarator);
	public List<TokenGenarator> allTokenGenarator();
	public List<TokenGenarator> searchByMRNo(int aId);
	public List<TokenGenarator> searchByToken(String tokenId);
	public List<TokenGenarator> searchByBooking(int aId);
	public void deleteTokenGenarator(TokenGenarator tokenGenarator);
	public TokenGenarator searchById(int id);
	public TokenGenarator getTokenGenarator(String MRNo);
	public TokenGenarator getLastToken();

}
