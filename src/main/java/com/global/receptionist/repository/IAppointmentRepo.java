package com.global.receptionist.repository;

import java.util.List;

import com.global.entity.Appointment;

public interface IAppointmentRepo {

	
	public void insertUpdateAppointment(Appointment appointment);
	public List<Appointment> allAppointments();
	public List<Appointment> searchByMRNo(int pId);
	public List<Appointment> searchByAppointmentId(String sAid);
	public void deleteAppointment(Appointment appointment);
	public Appointment searchByaId(int id);
	public Appointment getAppointment(String bookNo);
}
