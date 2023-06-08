package com.global.receptionist.repository;

import java.util.List;

import com.global.entity.PatientRecords;

public interface IPatientRepo {
	
	public void insertUpdatePatientRecords(PatientRecords patientRecords);
	public List<PatientRecords> allPatientRecords();
	public List<PatientRecords> searchByMRNo(String MRNo);
	public List<PatientRecords> searchByName(String sName);
	public void deletePatientRecords(PatientRecords patientRecords);
	public PatientRecords searchById(int id);
	public PatientRecords getPatientRecords(String MRNo);
	
	

}
