package com.global.receptionist.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.entity.Appointment;
import com.global.entity.TokenGenarator;
import com.global.receptionist.repository.IAppointmentRepo;
import com.global.receptionist.repository.IDoctorAndDepartmentRepo;
import com.global.receptionist.repository.IPatientRepo;
import com.global.receptionist.repository.ITokenGeneratorRepo;

@Service
public class AppointmentService implements IAppointmentService {
	
	private IAppointmentRepo repo;
	
	@Autowired
	public AppointmentService(IAppointmentRepo repo) {
		super();
		this.repo = repo;
	}
	
	@Autowired
	private IPatientRepo repoP;
	
	@Autowired
	private ITokenGeneratorRepo repoT;
	
	@Autowired
	private IDoctorAndDepartmentRepo repoDoDe;
	
	
		
	
	@Override
	public void insertUpdateAppointment(Appointment appointment) {
		

		
		appointment.setAppointmentValidity(appointment.getAppointmentDateTime().plusDays(7));
		repo.insertUpdateAppointment(appointment);

	}

	

	@Override
	public List<Appointment> allAppointments() {
		
		return repo.allAppointments();
	}

	@Override
	public List<Appointment> searchByMRNo(int pId) {
		return repo.searchByMRNo(pId);
	}

	@Override
	public List<Appointment> searchByAppointmentId(String sAid) {
		
		return repo.searchByAppointmentId(sAid);
	}

	@Override
	public void deleteAppointment(Appointment appointment) {

		appointment.setIsActive("false");
		repo.deleteAppointment(appointment);
		

	}

	@Override
	public Appointment searchByaId(int id) {
		
		return repo.searchByaId(id);
	}



	@Override
	public Appointment getAppointment(String bookNo) {
		
		return repo.getAppointment(bookNo);
	}

}
