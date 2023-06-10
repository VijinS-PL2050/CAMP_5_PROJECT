/*package com.global.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.RequestMapping;

import com.global.entity.BillMedicine;

import com.global.pharma.service.IBillService;

@Controller
@RequestMapping("/BillMedicine")
public class BillController {
	@Autowired
	private IBillService billService;

	// add form
	

	@GetMapping("/listBill")
	public String listmedicine(Model theModel) {

		List<BillMedicine> theCustomers = billService.getbill();

		theModel.addAttribute("BillMedicines", theCustomers);
		System.out.println("im here");
		for (BillMedicine a : theCustomers) {
			System.out.println(a);
		}

		return "list-BillMedicines";

	}


}
*/