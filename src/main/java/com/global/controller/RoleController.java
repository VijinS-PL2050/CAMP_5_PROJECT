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

import com.global.admin.service.IRoleService;
import com.global.entity.Role;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private IRoleService roleService;
	

	// add form
	@GetMapping("/showFormrole")
	public String roleAdd(Model theModel) {
		Role ro = new Role();
		theModel.addAttribute("RoleDetails", ro);

		return "role";

	}
	
	@GetMapping("/list")
	public String listRoleDetails(Model theModel) {
		List<Role> re = roleService.getRole();
		theModel.addAttribute("roleDetails", re);
		return "rolelist";
	}

	@PostMapping("/Roles")
	public String saveRole(@ModelAttribute("RoleDetails") Role ro) {
		// save the role
		roleService.saveRole(ro);
		return "redirect:/role/list";

	}
	
	@GetMapping("/search")
	public String searchById(@RequestParam("rId") int roleId, Model theModel) {
		Role thedet = roleService.searchById(roleId);
		theModel.addAttribute("roleDetails", thedet);

		return "redirect:/role/list";
	}
	
	@GetMapping("/disable")
	public String disablerole(@RequestParam("rId") int roleId) {		
		Role role=roleService.searchById(roleId);
		roleService.disableRole(role);
		return "redirect:/role/list";

	}
}
