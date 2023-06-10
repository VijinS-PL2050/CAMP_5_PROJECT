package com.global.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.global.admin.service.IDepartmentService;
import com.global.admin.service.IHospitalService;
import com.global.admin.service.IUserService;
import com.global.entity.DoctorDepartment;
import com.global.entity.DoctorDetails;

/*@Controller - indicates that a particular class serves the role of a controller in that way we get Servlet-specfic features*/
@Controller
@RequestMapping("/doctordetails")
public class DoctorController {
	@Autowired
	private IHospitalService hospitalService;

	@Autowired
	private IDepartmentService departmentService;
	
	@Autowired
	private IUserService userService;

	// add form
	@GetMapping("/showFormAdd")
	public ModelAndView showFormAdd() {

		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<DoctorDepartment> listDoctorDepartments = departmentService.getAllDepartment();
		DoctorDetails doc = new DoctorDetails();
		doc.setUser(userService.getLastUser());
		System.out.println("hghgft "+doc.getUser().getuId());
		modelMap.put("DoctorDetails", doc);
		modelMap.put("department", listDoctorDepartments);
		return new ModelAndView("doctorDetails-form", modelMap);

	}

	@PostMapping("/saveDoctorDetails")
	public String saveDoctorDetails(@ModelAttribute("DoctorDetails") DoctorDetails doc) {
		hospitalService.saveDoctorDetails(doc);

		return "redirect:/doctordetails/list";

	}

	@GetMapping("/list")
	public String listDoctorDetails(Model theModel) {
		List<DoctorDetails> doc = hospitalService.getDoctor();
		theModel.addAttribute("doctorDetails", doc);
		return "list-doctorDetails";

	}

	@GetMapping("/showFormUpdate")
	public ModelAndView showFormUpdate(@RequestParam("doId") int heId, Model theModel) {
		DoctorDetails doc = hospitalService.getDoctorupdate(heId);
		Map<String, Object> modelMap = new HashMap<String, Object>();
		List<DoctorDepartment> listDoctorDepartments = departmentService.getAllDepartment();
		modelMap.put("DoctorDetails", doc);
		modelMap.put("department", listDoctorDepartments);
		return new ModelAndView("doctorDetails-form", modelMap);
	}

	@GetMapping("/showFormDelete")
	public String showFormDelete(@RequestParam("doId") int theId) {
		DoctorDetails doc = hospitalService.searchById(theId);
		hospitalService.deleteDoctor(doc);

		return "redirect:/doctordetails/list";

	}

	@GetMapping("/searchByName")
	public String listBySearch(@RequestParam("doctorName") String theName, Model theModel) {

		List<DoctorDetails> doc = hospitalService.searchByName(theName);

		theModel.addAttribute("doctorDetails", doc);

		return "list-doctorDetails";

	}

	@GetMapping("/search")
	public String searchById(@RequestParam("doId") int docId, Model theModel) {
		DoctorDetails thedet = hospitalService.searchById(docId);
		theModel.addAttribute("doctorDetails", thedet);

		return "redirect:/doctordetails/list";
	}

	@GetMapping("/disable")
	public String disabledoc(@RequestParam("doId") int docId) {
		hospitalService.disableDoc(hospitalService.searchById(docId));

		return "redirect:/doctordetails/list";

	}

	
}
