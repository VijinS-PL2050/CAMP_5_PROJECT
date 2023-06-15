package com.global.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.global.entity.Appointment;
import com.global.entity.BillAppoinment;
import com.global.entity.DoctorDepartment;
import com.global.entity.DoctorDetails;
import com.global.entity.PatientRecords;
import com.global.entity.TokenGenarator;
import com.global.receptionist.service.IAppointmentService;
import com.global.receptionist.service.IBillAppointmentService;
import com.global.receptionist.service.IDoctorAndDepartmentService;
import com.global.receptionist.service.IPatientService;
import com.global.receptionist.service.ITokenGeneratorService;

@Controller
@RequestMapping("/billReceptionist")
public class BillReceptionistController {
	
	@Autowired
	private TokenGenarator tokenGenarator;

	@Autowired
	private ITokenGeneratorService tokenGeneratorService;
	
	@Autowired
	private IBillAppointmentService billAppointmentService;
	
	@Autowired
	private IPatientService patientService;
	
	@Autowired
	private IAppointmentService appointmentService;
	
	@Autowired
	private IDoctorAndDepartmentService doctorAndDepartmentService;
	
	@Autowired
	private BillAppoinment billAppoinment;
	
	@GetMapping("/showBillForReceptionist")
	public ModelAndView showBillForReceptionist() {
		System.out.println("i m in");
		billAppoinment=billAppointmentService.getLastBillAppoinment();
		System.out.println("hjgfd "+billAppoinment.getBillAppoinmentNo());
		Map<String, Object> modelMap = new HashMap<String, Object>();
		PatientRecords patientRecords = patientService.searchById(billAppoinment.getPatientRecords().getpId());
		System.out.println("lkjhgf"+patientRecords.getMrNo());
		modelMap.put("billAppoint", billAppoinment);
		modelMap.put("patientRecord", patientRecords);	
		return new ModelAndView("bill-form",modelMap);
		
	}
	
	@GetMapping("/showBillForReceptionistAppoint")
	public ModelAndView showBillForReceptionistAppoint(HttpSession session) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		System.out.println("i m in app");
		billAppoinment=billAppointmentService.getLastBillAppoinment();
		int tempTok=(int) session.getAttribute("token");
		tokenGenarator=new TokenGenarator();
		if(tempTok>0) {
			tokenGenarator=tokenGeneratorService.searchById(tempTok);
			modelMap.put("token", tokenGenarator);
		}else {
			modelMap.put("token", tokenGenarator);
		}
		
		System.out.println("hjgfd "+billAppoinment.getBillAppoinmentNo());
		
		Appointment appoint=appointmentService.searchByaId(billAppoinment.getAppointment().getaId());
		PatientRecords patientRecords = patientService.searchById(appoint.getPatientRecords().getpId());
		DoctorDetails doctor=doctorAndDepartmentService.getDoctorDetails(appoint.getDoctorDetails().getDoId());
		DoctorDepartment department=doctorAndDepartmentService.getDoctorDepartment(appoint.getDoctorDepartment().getdId());
		modelMap.put("billAppoint", billAppoinment);
		modelMap.put("patientRecord", patientRecords);
		modelMap.put("appointmentRecord", appoint);
		modelMap.put("doctor", doctor);
		modelMap.put("department", department);
		
		return new ModelAndView("bill-Appoint-form",modelMap);
		
	}

}
