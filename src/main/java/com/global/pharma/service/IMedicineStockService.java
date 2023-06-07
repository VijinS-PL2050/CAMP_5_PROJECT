package com.global.pharma.service;

import java.util.List;

import com.global.entity.BillMedicine;
import com.global.entity.MedicinePrescription;
import com.global.entity.MedicinesStock;

public interface IMedicineStockService {
	public List<MedicinesStock>getmedicine();

	public void savemedicine(MedicinesStock theCustomer) ;
	public MedicinesStock getmedicine(int theId);
	public void getmedicineDisable(int theId);
	
	public MedicinesStock getdelete(int theId);
	
	public List<MedicinesStock> searchmedicine(String theName);
	public List<MedicinePrescription>getMedicinePrescription();
	public List<MedicinePrescription>getMedicineveiw();
	public List<MedicinePrescription> searchmedicineprescription(String theName);
	public List<MedicinePrescription> searchmedicineVeiw(String theName);
	public List<BillMedicine>getMedicinebill();
	public List<BillMedicine>searchMedicinebill(String theName);
}
