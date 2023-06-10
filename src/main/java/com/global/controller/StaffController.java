package com.global.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.global.admin.service.IHospitalService;
import com.global.admin.service.IUserService;
import com.global.entity.StaffDeatils;

@Controller
@RequestMapping("/staffDetails")
public class StaffController {

	@Autowired
	private IHospitalService staffService;

	@Autowired
	private IUserService userService;

	// add form
	@GetMapping("/showFormAdd")
	public String showFormAdd(Model theModel) {
		StaffDeatils sta = new StaffDeatils();
		sta.setUser(userService.getLastUser());
		theModel.addAttribute("StaffDetails", sta);
		return "staffDetails-form";

	}

	@PostMapping("/saveStaffDetails")
	public String addStaffDeatils(@ModelAttribute("StaffDetails") StaffDeatils sta) {

		LocalDate newDate = sta.getDateofbirth().plusDays(1);
		sta.setDateofbirth(newDate);
		staffService.addStaffDeatils(sta);
		return "redirect:/staffDetails/list";

	}

	@GetMapping("/list")
	public String listStaffDeatils(Model theModel) {
		List<StaffDeatils> sta = staffService.getStaff();
		theModel.addAttribute("StaffDetails", sta);
		return "list-staffDetails";

	}

	@GetMapping("/showFormUpdate")
	public String showFormUpdate(@RequestParam("sId") int theId, Model theModel) {
		StaffDeatils sta = staffService.getStaffupdate(theId);
		LocalDate newDate = sta.getDateofbirth();
		sta.setDateofbirth(newDate);
		System.out.println(sta.getsId());
		theModel.addAttribute("StaffDetails", sta);

		return "staffDetails-form";

	}

	@GetMapping("/showFormDelete")
	public String showFormDelete(@RequestParam("staffid") int theId) {

		StaffDeatils sta = staffService.searchByIds(theId);
		staffService.deleteStaff(sta);

		return "redirect:/staffDetails/list";

	}

	@GetMapping("/searchByName")
	public String listBySearch(@RequestParam("staffName") String theName, Model theModel) {

		List<StaffDeatils> sta = staffService.searchByNames(theName);

		theModel.addAttribute("StaffDetails", sta);

		return "list-staffDetails";

	}

	@GetMapping("/search")
	public String searchByIds(@RequestParam("sId") int sId, Model theModel) {
		StaffDeatils thedet = staffService.searchByIds(sId);
		theModel.addAttribute("StaffDetails", thedet);

		return "redirect:/staffDetails/list";
	}

	@GetMapping("/disablestaff")
	public String disablesta(@RequestParam("sId") int sId) {
		staffService.disableSta(staffService.searchByIds(sId));

		return "redirect:/staffDetails/list";

	}

}
