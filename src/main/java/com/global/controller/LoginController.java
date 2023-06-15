package com.global.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
			HttpSession session, Model _model,RedirectAttributes redirectAttributes) {

		User user = loginSevice.getRoleFromLogin(username, password);
		if (user == null) {
			String errorMessage = "Invalid username or password"; // Customize the error message as needed
			System.out.println(errorMessage);
			redirectAttributes.addFlashAttribute("errorMessage", errorMessage);

			return "redirect:/login/user";
		} else if (user.getRole().getrId() == 1000) {
			System.out.println("ROle is 0");
			session.setAttribute("username", username);
			session.setAttribute("roleId", user.getRole().getRoleId());
			session.setAttribute("isLoggedIn", true);
			return "redirect:/login/restricted-page";
		} else if (user.getRole().getrId() == 1001) {
			System.out.println("ROle is 1");
			session.setAttribute("username", username);
			session.setAttribute("roleId", user.getRole().getRoleId());
			session.setAttribute("isLoggedIn", true);
			return "redirect:/login/restricted-page1";
		} else if (user.getRole().getrId() == 1003) {
			System.out.println("ROle is 3");
			session.setAttribute("username", username);
			session.setAttribute("roleId", user.getRole().getRoleId());
			session.setAttribute("isLoggedIn", true);
			return "redirect:/login/restricted-page2";
		}
		return "page-not-found";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session, HttpServletResponse response) {
		session.removeAttribute("username");
		session.removeAttribute("roleId");
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
		response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
		response.setDateHeader("Expires", 0); // Proxies.

		return "redirect:/login/logged-out";
	}

	@GetMapping("/restricted-page")
	public String restrictedPage(HttpSession session) {
		Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");
		if (isLoggedIn != null && isLoggedIn) {
			return "admin-dash";
		} else {
			return "redirect:/login/user";
		}
	}

	@GetMapping("/restricted-page1")
	public String restrictedPage1(HttpSession session) {
		Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");
		if (isLoggedIn != null && isLoggedIn) {
			return "receptoinist-dash";
		} else {
			return "redirect:/login/user";
		}
	}

	@GetMapping("/restricted-page2")
	public String restrictedPage2(HttpSession session) {
		Boolean isLoggedIn = (Boolean) session.getAttribute("isLoggedIn");
		if (isLoggedIn != null && isLoggedIn) {
			return "pharmacist-dash";
		} else {
			return "redirect:/login/user";
		}
	}

	@GetMapping("/logged-out")
	public String loggedOutPage() {
		return "logged-out";
	}

}
