package com.global.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.global.entity.PatientRecords;
import com.global.receptionist.service.IPatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {

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

		patientService.insertUpdatePatientRecords(forPatientRecords);
		return "redirect:/patient/listPatientRecords";

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
