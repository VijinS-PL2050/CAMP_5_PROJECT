package com.global.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.global.entity.User;
import com.global.login.service.ILoginSevice;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private ILoginSevice loginSevice;

	private User user;

	@Autowired
	public LoginController(User user) {
		super();
		this.user = user;
	}

	@GetMapping("/user")
	public String loginPage(Model _model) {
		System.out.println("i m in");
		_model.addAttribute("user", user);
		return "login";
	}

	@PostMapping("/login/mapUser")
	public String mapUser(@RequestParam("userName") String username, @RequestParam("password") String password,
			HttpSession session, Model _model) {

		User user = loginSevice.getRoleFromLogin(username, password);
		System.out.println("sfdsfdfdsf");
		if (user == null) {

			return "redirect:/login/user";
		} else if (user.getRole().getrId()== 2) {
			System.out.println("ROle is 2");
			session.setAttribute("username", username);
			session.setAttribute("roleId", user.getRole().getRoleId());
			return "receptoinist-dash";
		}
		return "page-not-found";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("username");
		session.removeAttribute("roleId");
		return "redirect:/login";
	}

}
