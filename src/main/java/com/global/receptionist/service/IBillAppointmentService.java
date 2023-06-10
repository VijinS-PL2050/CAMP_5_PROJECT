package com.global.receptionist.service;

import java.util.List;

import com.global.entity.BillAppoinment;

public interface IBillAppointmentService {
	
	public void insertUpdateBillAppoinment(BillAppoinment billAppoinment);
	public List<BillAppoinment> allBillAppoinment();
	public List<BillAppoinment> searchByAppoinment(int aId);
	public List<BillAppoinment> searchByBillAppoinment(String billNo);
	public void deleteBillAppoinment(BillAppoinment billAppoinment);
	public BillAppoinment searchByaId(int id);
	public BillAppoinment getLastBillAppoinment();

}
