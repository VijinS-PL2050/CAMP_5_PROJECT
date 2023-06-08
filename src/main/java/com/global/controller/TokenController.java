package com.global.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.global.entity.Appointment;
import com.global.entity.DoctorDetails;
import com.global.entity.TokenGenarator;
import com.global.receptionist.service.IAppointmentService;
import com.global.receptionist.service.IDoctorAndDepartmentService;
import com.global.receptionist.service.ITokenGeneratorService;

@Controller
@RequestMapping("/token")
public class TokenController {
	
	@Autowired
	private IAppointmentService appointmentService;
	
	private ITokenGeneratorService tokenGeneratorService;
	
	@Autowired
	public TokenController(ITokenGeneratorService tokenGeneratorService) {
		super();
		this.tokenGeneratorService = tokenGeneratorService;
	}
	
	@Autowired
	private IDoctorAndDepartmentService doctorAndDepartmentService;
	
	@Autowired
	private DoctorDetails doctorDetails;
	
	@GetMapping("/listTokenRecords")
	public String listToken(Model inModel) {
		inModel.addAttribute("tokenReports", tokenGeneratorService.allTokenGenarator());
		return "list-token";
		
	}
	
	@GetMapping("/showFormForTokenDelete")
	public String showFormForTokenDelete(@RequestParam("tokenId") int theId){
		System.out.println(theId);
		Appointment appo=tokenGeneratorService.searchById(theId).getAppointment();
		doctorDetails=appo.getDoctorDetails();
		//doctorDetails=doctorAndDepartmentService.getDoctorDetails(tokenGeneratorService.searchById(theId).getAppointment().getDoctorDetails().getDoId());
		doctorDetails.setNoOfToken(doctorDetails.getNoOfToken()+1);
		System.out.println(doctorDetails.getNoOfToken());
		doctorAndDepartmentService.updateForToken(doctorDetails);
		tokenGeneratorService.deleteTokenGenarator(tokenGeneratorService.searchById(theId));
		return "redirect:/token/listTokenRecords";
		
	}
	
	@PostMapping("/searchByBookingT")
	public String searchByBooking(@RequestParam("bookingNo") String bookNo, Model inModel) {
		if (bookNo.isEmpty()) {

			return "redirect:/token/listTokenRecords";
		} else {

			int id=appointmentService.getAppointment(bookNo).getaId();
			inModel.addAttribute("tokenReports", tokenGeneratorService.searchByBooking(id));

			return "list-token";
		}

	}
	
	@PostMapping("/searchByToken")
	public String searchByToken(@RequestParam("tokenNo") String tokNo, Model inModel) {
		if (tokNo.isEmpty()) {
			return "redirect:/token/listTokenRecords";
		} else {
			for(TokenGenarator gen:tokenGeneratorService.searchByToken(tokNo)) {
				System.out.println(gen.getTokenNo());
			}
			inModel.addAttribute("tokenReports", tokenGeneratorService.searchByToken(tokNo));

			return "list-token";
		}

	}

	

}
