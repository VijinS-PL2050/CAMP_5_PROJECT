package com.global.receptionist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.entity.BillAppoinment;
import com.global.receptionist.repository.IBillAppointmentRepo;

@Service
public class BillAppointmentService implements IBillAppointmentService {

	private IBillAppointmentRepo repo;
	
	@Autowired
	public BillAppointmentService(IBillAppointmentRepo rep) {
		super();
		this.repo = rep;
	}

	@Override
	public void insertUpdateBillAppoinment(BillAppoinment billAppoinment) {


		repo.insertUpdateBillAppoinment(billAppoinment);

	}

	@Override
	public List<BillAppoinment> allBillAppoinment() {
		
		return repo.allBillAppoinment();
	}

	@Override
	public List<BillAppoinment> searchByAppoinment(int aId) {
		
		return repo.searchByAppoinment(aId);
	}

	@Override
	public List<BillAppoinment> searchByBillAppoinment(String billNo) {
		
		return repo.searchByBillAppoinment(billNo);
	}

	@Override
	public void deleteBillAppoinment(BillAppoinment billAppoinment) {


		billAppoinment.setIsActive("false");
		repo.deleteBillAppoinment(billAppoinment);
	}

	@Override
	public BillAppoinment searchByaId(int id) {
		
		return repo.searchByaId(id);
	}

	@Override
	public BillAppoinment getLastBillAppoinment() {
		
		return repo.getLastBillAppoinment();
	}

}
