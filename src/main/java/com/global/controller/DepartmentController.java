package com.global.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.global.admin.service.IDepartmentService;
import com.global.entity.DoctorDepartment;
import com.global.entity.Role;

@Controller
@RequestMapping("/Department")
public class DepartmentController {
	@Autowired
	private IDepartmentService deptService;

	// add form
	@GetMapping("/showFormdept")
	public String deptAdd(Model theModel) {
		DoctorDepartment dept = new DoctorDepartment();
		theModel.addAttribute("deptDetails", dept);

		return "Department";

	}
	
	@GetMapping("/list")
	public String listRoleDetails(Model theModel) {
		List<DoctorDepartment> dep = deptService.getDoctorDepartment();
		theModel.addAttribute("departmentDetails", dep);
		return "departmentlist";
	}

	@PostMapping("/dept")
	public String saveDepartment(@ModelAttribute("deptDetails") DoctorDepartment dept) {

		// save the user
		deptService.saveDepartment(dept);

		return "redirect:/Department/list";

	}
	
	@GetMapping("/search")
	public String searchById(@RequestParam("dId") int roleId, Model theModel) {
		DoctorDepartment thedet = deptService.searchById(roleId);
		theModel.addAttribute("departmentDetails", thedet);

		return "redirect:/Department/list";
		}
	
	@GetMapping("/disable")
	public String disabledept(@RequestParam("dId") int depId) {		
		DoctorDepartment dep=deptService.searchById(depId);
		deptService.disableDoctorDepartment(dep);
		return "redirect:/Department/list";

	}
}
