package com.global.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.global.entity.Appointment;
import com.global.entity.BillAppoinment;
import com.global.entity.DoctorDepartment;
import com.global.entity.DoctorDetails;
import com.global.entity.TokenGenarator;
import com.global.receptionist.service.IAppointmentService;
import com.global.receptionist.service.IBillAppointmentService;
import com.global.receptionist.service.IDoctorAndDepartmentService;
import com.global.receptionist.service.IPatientService;
import com.global.receptionist.service.ITokenGeneratorService;



@Controller
@RequestMapping("/appointment")
public class AppointmentController {

	@Autowired
	private BillAppoinment billAppoinment;
	
	@Autowired
	private IBillAppointmentService billAppointmentService;

	@Autowired
	private TokenGenarator tokenGenarator;

	@Autowired
	private ITokenGeneratorService tokenGeneratorService;

	@Autowired
	private IAppointmentService appointmentService;

	@Autowired
	private IDoctorAndDepartmentService doctorAndDepartmentService;

	@Autowired
	private IPatientService patientService;

	@Autowired
	private DoctorDetails doctorDetails;

	private Appointment forAppointment;

	@Autowired
	public AppointmentController(Appointment forAppointment) {
		super();
		this.forAppointment = forAppointment;
	}

	@GetMapping("/showFormForAppointment")
	public ModelAndView showFormForAppointment(@RequestParam("patientId") int pId,HttpSession session) {
		forAppointment.setPatientRecords(patientService.searchById(pId));
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<DoctorDepartment> listDoctorDepartments = doctorAndDepartmentService.getAllDepartment();
		List<DoctorDetails> listDoctorDetails = doctorAndDepartmentService.allDoctorDetailss();
		session.setAttribute("name", patientService.searchById(pId).getPatientName());
		session.setAttribute("mrno", patientService.searchById(pId).getMrNo());
		session.setAttribute("date", patientService.searchById(pId).getRegistrationDate());
		modelMap.put("appointment", forAppointment);
		modelMap.put("department", listDoctorDepartments);
		modelMap.put("doctor", listDoctorDetails);
        
		return new ModelAndView("appointment-form", modelMap);

	}
	
	@GetMapping("/getDoctors")
    @ResponseBody
    public List<DoctorDetails> getDoctors(@RequestParam("departmentId") int dId) {
        List<DoctorDetails> doctors = doctorAndDepartmentService.getAllDoctorDetailss(dId);
        for(DoctorDetails a : doctors) {
        	System.out.println(a.getDoctorName());
        }
        
        return doctors;
    }

	@PostMapping("/insertAppointment")
	public String insertAppointment(@ModelAttribute("appointment") Appointment forAppointment) {

		appointmentService.insertUpdateAppointment(forAppointment);
		if (forAppointment.getBillAppoinment() == null) {
			generateToken(forAppointment);
			generateBill(forAppointment);
			return "redirect:/appointment/KKKKK";
		} else {
			return "redirect:/appointment/listAppointmentRecords";
		}
	}

	@GetMapping("/listAppointmentRecords")
	public String listAppointmentRecords(Model inModel) {
		inModel.addAttribute("appointmentrecords", appointmentService.allAppointments());
		return "list-appointments";

	}

	@GetMapping("/showFormForAppointUpdate")
	public ModelAndView showFormForAppointUpdate(@RequestParam("appointId") int theId) {

		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<DoctorDepartment> listDoctorDepartments = doctorAndDepartmentService.getAllDepartment();
		List<DoctorDetails> listDoctorDetails = doctorAndDepartmentService.allDoctorDetailss();

		modelMap.put("appointment", appointmentService.searchByaId(theId));
		modelMap.put("department", listDoctorDepartments);
		modelMap.put("doctor", listDoctorDetails);

		return new ModelAndView("appointment-form", modelMap);

	}

	@GetMapping("/showFormForAppointDelete")
	public String showFormForAppointDelete(@RequestParam("appointId") int theId) {

		appointmentService.deleteAppointment(appointmentService.searchByaId(theId));

		return "redirect:/appointment/listAppointmentRecords";

	}

	@PostMapping("/searchByBooking")
	public String searchByBooking(@RequestParam("bookingNo") String bookNo, Model inModel) {
		if (bookNo.isEmpty()) {

			return "redirect:/appointment/listAppointmentRecords";
		} else {

			inModel.addAttribute("appointmentrecords", appointmentService.searchByAppointmentId(bookNo));

			return "list-appointments";
		}

	}

	@PostMapping("/searchByMRNo")
	public String searchByMRNo(@RequestParam("patientMRNo") String MRNo, Model inModel) {
		if (MRNo.isEmpty()) {
			return "redirect:/appointment/listAppointmentRecords";
		} else {
			int pId = patientService.getPatientRecords(MRNo).getpId();
			inModel.addAttribute("appointmentrecords", appointmentService.searchByMRNo(pId));
			return "list-appointments";
		}

	}

	private void generateToken(Appointment appointment) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime noww = LocalDateTime.parse(LocalDateTime.now().format(format), format);
		LocalDateTime todayAt6 = LocalDate.now().atTime(20, 0);
		LocalDateTime appointDate = appointment.getAppointmentDateTime();
		doctorDetails = doctorAndDepartmentService.getDoctorDetails(appointment.getDoctorDetails().getDoId());
		int maxToken = doctorDetails.getNoOfToken();
		String doctorId = doctorDetails.getDoctorId();
		if (appointDate.isAfter(noww) && appointDate.isBefore(todayAt6)) {
			if (maxToken > 0) {
				tokenGenarator.setTokenTime(appointment.getAppointmentDateTime().plusMinutes(15));
				tokenGenarator.setTokenNo("T" + doctorId + (30-maxToken));
				tokenGenarator.setAppointment(appointment);
				tokenGeneratorService.insertUpdateTokenGenarator(tokenGenarator);
				doctorDetails.setNoOfToken(maxToken - 1);
				doctorAndDepartmentService.updateForToken(doctorDetails);
			}
		}
	}

	private void generateBill(Appointment forAppoint) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime noww = LocalDateTime.parse(LocalDateTime.now().format(format), format);
		LocalDate todayDate = LocalDate.now();
		System.out.println(todayDate);
		System.out.println(noww);
		LocalDateTime appoint = forAppoint.getAppointmentDateTime();
		System.out.println(appoint);
		LocalDateTime appointV = forAppoint.getAppointmentValidity();
		 System.out.println(appointV);
		LocalDate patReg = patientService.searchById(forAppoint.getPatientRecords().getpId()).getRegistrationDate();
		System.out.println(patReg);
		LocalDate patVal = patientService.searchById(forAppoint.getPatientRecords().getpId()).getValidityDate();
		// System.out.println(pVal);
		int pId = forAppoint.getPatientRecords().getpId();
		int doId = forAppoint.getDoctorDetails().getDoId();
		double fee=doctorAndDepartmentService.getDoctorDetails(doId).getConsultationFee();
		double sum = 0;
		System.out.println(pId);
		billAppoinment.setAppointment(forAppoint);
		System.out.println(billAppoinment.getAppointment().getaId());
		billAppoinment.setBillDate(noww);
		System.out.println("kjhgf"+billAppoinment.getBillDate());
		
		if (patReg.equals(todayDate)) {
			System.out.println(" i m in 1st if");
			System.out.println(forAppoint.getDoctorDetails().getDoId());
			System.out.println( "jhgfd"+doctorAndDepartmentService.getDoctorDetails(forAppoint.getDoctorDetails().getDoId()).getConsultationFee());
			sum = 150 + forAppoint.getDoctorDetails().getConsultationFee();

		} else if (patVal.isBefore(todayDate) && appointV.isBefore(noww)) {
			System.out.println(" i m in 2st if");
			System.out.println( forAppoint.getDoctorDetails().getConsultationFee());
			sum = 150 + forAppoint.getDoctorDetails().getConsultationFee();
		} else if (patVal.isAfter(todayDate) && appointV.isBefore(noww)) {
			System.out.println(" i m in 3st if");
			System.out.println( forAppoint.getDoctorDetails().getConsultationFee());
			sum = forAppoint.getDoctorDetails().getConsultationFee();
		} else {
			System.out.println(" i m in else");
			
			sum = 150;
		}
		billAppoinment.setBillAmount(sum);
		System.out.println(billAppoinment.getBillAmount());
		billAppointmentService.insertUpdateBillAppoinment(billAppoinment);

	}

}
