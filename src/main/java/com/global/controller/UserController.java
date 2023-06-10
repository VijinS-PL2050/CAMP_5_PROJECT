package com.global.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.global.admin.service.IRoleService;
import com.global.admin.service.IUserService;
import com.global.entity.Role;
import com.global.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService useService;
	
	@Autowired
	private IRoleService roleService;

	// add form
	@GetMapping("/showFormuser")
	public ModelAndView userAdd() {
		Map<String, Object> modelMap = new HashMap<String, Object>();	
		List<Role> listRole = useService.getAllRole();
		User use = new User();
		modelMap.put("UserDetails", use);
		modelMap.put("listRole", listRole);
		return new ModelAndView("user", modelMap);

	}

	@PostMapping("/saveuser")
	public String saveuser(@ModelAttribute("UserDetails") User use) {

		// save the user
		useService.saveuser(use);
		System.out.println("i m here");
		System.out.println(use.getuId());
		System.out.println(use.getUserName());
		//System.out.println(use.getRole().getrId());
		int a=use.getRole().getrId();
		System.out.println(roleService.getRole(a).getRoleName());
		if(roleService.getRole(a).getRoleName().equalsIgnoreCase("doctor")) {
			System.out.println("i m in if");
			System.out.println(use.getRole().getRoleName());
			return "redirect:/doctordetails/showFormAdd";
		}else {
			System.out.println(" i m in else");
			System.out.println(use.getRole().getRoleName());
			return "redirect:/staffDetails/showFormAdd";
		}	
	}
}