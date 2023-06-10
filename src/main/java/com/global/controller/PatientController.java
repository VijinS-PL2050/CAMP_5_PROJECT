package com.global.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.global.entity.BillAppoinment;
import com.global.entity.PatientRecords;
import com.global.receptionist.service.IBillAppointmentService;
import com.global.receptionist.service.IPatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {
	
	@Autowired
	private BillAppoinment billAppoinment;
	
	@Autowired
	private IBillAppointmentService billAppointmentService;

	@Autowired
	private IPatientService patientService;

	private PatientRecords forPatientRecords;

	@Autowired
	public PatientController(PatientRecords forPatientRecords) {
		super();
		this.forPatientRecords = forPatientRecords;
	}

	@GetMapping("/showFormForPatientRecord")
	public String showFormForPatientRecord(Model inModel) {

		inModel.addAttribute("patient", forPatientRecords);

		return "patient-form";

	}

	@PostMapping("/insertPatientRecord")
	public String insertPatientRecord(@ModelAttribute("patient") PatientRecords forPatientRecords) {
		
		
		if(forPatientRecords.getpId()==0) {
			System.out.println("I M IN IF");
			List<BillAppoinment> multiBill=genarateBillRegister(forPatientRecords);
			forPatientRecords.setBillAppoinment(multiBill);
			patientService.insertUpdatePatientRecords(forPatientRecords);
			return "redirect:/billReceptionist/showBillForReceptionist";
			
		}else {
			return "redirect:/patient/listPatientRecords";
		}

		/*patientService.insertUpdatePatientRecords(forPatientRecords);
		LocalDate todayDate = LocalDate.now();
		if(forPatientRecords.getBillAppoinment()==null) {
			System.out.println(" i m in insert patient");
			billAppoinment=genarateBillRegister(forPatientRecords);
			return "bill-form";
		}
		else {
			return "redirect:/patient/listPatientRecords";
		}*/
		
		

	}

	private List<BillAppoinment> genarateBillRegister(PatientRecords forPatientRecords2) {
		List<BillAppoinment> multiBill= new ArrayList<BillAppoinment>();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		LocalDateTime noww = LocalDateTime.parse(LocalDateTime.now().format(format), format);
		billAppoinment.setPatientRecords(forPatientRecords2);
		billAppoinment.setBillAmount(150.00);
		billAppoinment.setBillDate(noww);
		billAppoinment.setIsActive("true");
		multiBill.add(billAppoinment);		
		return multiBill;
		
	}

	@GetMapping("/listPatientRecords")
	public String listPatientRecords(Model inModel) {
		inModel.addAttribute("records", patientService.allPatientRecords());
		return "list-patients";
	}

	@PostMapping("/searchByName")
	public String searchByName(@RequestParam("patientName") String theName, Model inModel) {
		if (theName.isEmpty()) {
			return "redirect:/patient/listPatientRecords";
		} else {
			inModel.addAttribute("records", patientService.searchByName(theName));

			return "list-patients";
		}
	}

	@PostMapping("/searchByMRNo")
	public String searchByMRNo(@RequestParam("patientMRNo") String theMRNo, Model inModel) {
		if (theMRNo.isEmpty()) {
			return "redirect:/patient/listPatientRecords";
		} else {
			inModel.addAttribute("records", patientService.searchByMRNo(theMRNo));

			return "list-patients";
		}

	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("patientId") int theId, Model inModel) {

		inModel.addAttribute("patient", patientService.searchById(theId));
		return "patient-form";

	}

	@GetMapping("/showFormForDelete")
	public String showFormForDelete(@RequestParam("patientId") int theId) {
		patientService.deletePatientRecords(patientService.searchById(theId));
		return "redirect:/patient/listPatientRecords";
	}

}
