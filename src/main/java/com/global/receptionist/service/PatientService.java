package com.global.receptionist.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.entity.PatientRecords;
import com.global.receptionist.repository.IPatientRepo;

@Service
public class PatientService implements IPatientService {
	
	private IPatientRepo repo;
	
	@Autowired
	public PatientService(IPatientRepo repo) {
		super();
		this.repo = repo;
	}
	
	
	

	@Override
	public void insertUpdatePatientRecords(PatientRecords patientRecords) {
		if(patientRecords.getRegistrationDate()==null) {
			patientRecords.setRegistrationDate(LocalDate.now());
			patientRecords.setValidityDate(patientRecords.getRegistrationDate().plusMonths(6));
		}
	
		
		repo.insertUpdatePatientRecords(patientRecords);

	}

	

	@Override
	public List<PatientRecords> allPatientRecords() {
		
		return repo.allPatientRecords();
	}

	@Override
	public List<PatientRecords> searchByMRNo(String MRNo) {
		
		return repo.searchByMRNo(MRNo);
	}

	@Override
	public List<PatientRecords> searchByName(String sName) {
		
		return repo.searchByName(sName);
	}

	@Override
	public void deletePatientRecords(PatientRecords patientRecords) {
		patientRecords.setIsActive("false");
		repo.deletePatientRecords(patientRecords);

	}




	@Override
	public PatientRecords searchById(int id) {
		
		return repo.searchById(id);
	}




	@Override
	public PatientRecords getPatientRecords(String MRNo) {
		
		return repo.getPatientRecords(MRNo);
	}

}
