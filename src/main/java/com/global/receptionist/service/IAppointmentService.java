package com.global.receptionist.service;

import java.util.List;

import com.global.entity.Appointment;

public interface IAppointmentService {
	
	public void insertUpdateAppointment(Appointment appointment);
	public List<Appointment> allAppointments();
	public List<Appointment> searchByMRNo(int pId);
	public List<Appointment> searchByAppointmentId(String sAid);
	public void deleteAppointment(Appointment appointment);
	public Appointment searchByaId(int id);
	public Appointment getAppointment(String bookNo);

}
