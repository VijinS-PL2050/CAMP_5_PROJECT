package com.global.pharma.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.entity.BillMedicine;
import com.global.entity.Diagnosis;
import com.global.entity.MedicinePrescription;
import com.global.entity.MedicinesStock;
import com.global.pharma.repository.IMedicineStockDao;
@Service
public class MedicineStockService  implements IMedicineStockService{
	@Autowired 
	private IMedicineStockDao medicineDemo;

	@Override
	public List<MedicinesStock> getmedicine() {
		// TODO Auto-generated method stub
		return medicineDemo.getmedicine() ;
	}

	@Override
	public void savemedicine(MedicinesStock theCustomer) {
		// TODO Auto-generated method stub
		medicineDemo.savemedicine(theCustomer);
	}

	@Override
	public MedicinesStock getmedicine(int theId) {
		// TODO Auto-generated method stub
		return medicineDemo.getmedicine(theId);
	}

	@Override
	public MedicinesStock getdelete(int theId) {
		// TODO Auto-generated method stub
		return medicineDemo.getdelete(theId) ;
	}

	@Override
	public List<MedicinesStock> searchmedicine(String theName) {
		// TODO Auto-generated method stub
		return medicineDemo.searchmedicine(theName);
	}

	@Override
	public List<MedicinePrescription> getMedicinePrescription() {
		// TODO Auto-generated method stub
		return medicineDemo.getMedicinePrescription();
	}

	@Override
	public List<MedicinePrescription> getMedicineveiw() {
		// TODO Auto-generated method stub
		return medicineDemo.getMedicineveiw();
	}

	@Override
	public List<MedicinePrescription> searchmedicineprescription(String theName) {
		// TODO Auto-generated method stub
		return medicineDemo.searchmedicineprescription(theName);
	}

	@Override
	public List<MedicinePrescription> searchmedicineVeiw(String theName) {
		// TODO Auto-generated method stub
		return medicineDemo.searchmedicineVeiw(theName) ;
	}

	@Override
	public void getmedicineDisable(int theId) {
		// TODO Auto-generated method stub
		medicineDemo.getmedicineDisable(theId);
	}

	

	@Override
	public List<MedicinePrescription> getveiwprisccription(int theId) {
		// TODO Auto-generated method stub
		return medicineDemo.getveiwprisccription(theId);
	}

	@Override
	public List<BillMedicine> getveiwprisccrip(int theId) {
		// TODO Auto-generated method stub
		return medicineDemo.getveiwprisccrip(theId) ;
	}

	@Override
	public List<MedicinePrescription> getbill() {
		// TODO Auto-generated method stub
		return medicineDemo.getbill() ;
	}

	@Override
	public List<MedicinePrescription> getbill(int theId) {
		// TODO Auto-generated method stub
		return  medicineDemo.getbill(theId);
	}

	

}
