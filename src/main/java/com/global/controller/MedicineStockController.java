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

import com.global.entity.BillMedicine;
import com.global.entity.MedicinePrescription;
import com.global.entity.MedicinesStock;
import com.global.pharma.service.IMedicineStockService;

@Controller
@RequestMapping("/MedicinesStock")
public class MedicineStockController {

	@Autowired
	private IMedicineStockService medicineService;

	// add form
	@GetMapping("/showFormAdd")
	public String showFormAdd(Model theModel) {
		MedicinesStock theCustomer = new MedicinesStock();
		// create model attribute to bindform data
		theModel.addAttribute("MedicinesStocks", theCustomer);

		return "MedicinesStock-form";

	}

	@PostMapping("/savemedicine")
	public String savemedicine(@ModelAttribute("MedicinesStocks") MedicinesStock theCustomers) {
		medicineService.savemedicine(theCustomers);
		return "redirect:/MedicinesStock/list";

	}

	@GetMapping("/list")
	public String listmedicine(Model theModel) {

		List<MedicinesStock> theCustomers = medicineService.getmedicine();

		theModel.addAttribute("MedicinesStocks", theCustomers);
		System.out.println("im here");
		for (MedicinesStock a : theCustomers) {
			System.out.println(a);
		}

		return "list-MedicinesStocks";

	}

	@GetMapping("/showFormUpdate")
	public String showFormUpdate(@RequestParam("msId") int theId, Model theModel) {
		System.out.println(theId);
		MedicinesStock theCustomer = medicineService.getmedicine(theId);
		theModel.addAttribute("MedicinesStocks", theCustomer);
		return "MedicinesStock-form";
	}
	@GetMapping("/showFormDisable")
	public String showFormDisable(@RequestParam("msId") int theId, Model theModel) {
		System.out.println(theId);
		medicineService.getmedicineDisable(theId);
		return "redirect:/MedicinesStock/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("msId") int theId, Model theModel) {
		System.out.println(theId);
		MedicinesStock theCustomer = medicineService.getdelete(theId);
		theModel.addAttribute("MedicinesStocks", theCustomer);
		return "redirect:/MedicinesStock/list";

	}

	@PostMapping("/search")
	public String search(@RequestParam("searchName") String searchName, Model theModel) {
		// create model attribute to bind form data
		List<MedicinesStock> theCustomer = medicineService.searchmedicine(searchName);
		theModel.addAttribute("MedicinesStocks", theCustomer); // search customers to the model
		return "list-MedicinesStocks";
	}

	@GetMapping("/listnew")
	public String listmedicinepriscription(Model theModel) {
		System.out.println("im here");
		List<MedicinePrescription> med = medicineService.getMedicinePrescription();
		System.out.println("im here");
		theModel.addAttribute("MedicinePrescriptions", med);
		System.out.println("im here");
		

		return "list-Medicines";

	}
	@PostMapping("/searches")
	public String searchmedicinepriscription(@RequestParam("searchName") String searchName, Model theModel) {
		// create model attribute to bind form data
		List<MedicinePrescription> theCustomer = medicineService.searchmedicineprescription(searchName);
		theModel.addAttribute("MedicinePrescriptions", theCustomer); // search customers to the model
		return "list-Medicines";
	}
	@GetMapping("/listveiw")
	public String listpatientview(Model theModel) {
		System.out.println("im here");
		List<MedicinePrescription> med = medicineService.getMedicinePrescription();
		System.out.println("im here");
		theModel.addAttribute("MedicinePrescriptions", med);
		System.out.println("im here");
		

		return "list-veiw";

	}
	@PostMapping("/searchss")
	public String searchmedicineview(@RequestParam("searchName") String searchName, Model theModel) {
		// create model attribute to bind form data
		List<MedicinePrescription> theCustomer = medicineService.searchmedicineVeiw(searchName);
		theModel.addAttribute("MedicinePrescriptions", theCustomer); // search customers to the model
		return "list-veiw";
}
	@GetMapping("/listbill")
	public String listMedicineBill(Model theModel) {
		System.out.println("im here");
		List<BillMedicine> med = medicineService.getMedicinebill();
		System.out.println("im here");
		theModel.addAttribute("BillMedicines", med);
		System.out.println("im here");
		

		return "list-bill";

	}
	@PostMapping("/searched")
	public String searchmedicinebill(@RequestParam("searchName") String searchName, Model theModel) {
		// create model attribute to bind form data
		List<BillMedicine> theCustomer = medicineService.searchMedicinebill(searchName);
		theModel.addAttribute("BillMedicines", theCustomer); // search customers to the model
		return "list-bill";
}
	
}