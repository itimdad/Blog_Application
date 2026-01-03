package com.imdad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.imdad.binding.LoginForm;
import com.imdad.binding.SignUpForm;
import com.imdad.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;


	@GetMapping("/")
	public String loadIndexPage() {
		
		return "index";
	}
	
	@GetMapping("/register")
	public String loadRegisterPage(Model model) {
		
		model.addAttribute("signupForm", new SignUpForm());
		
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("signupForm") SignUpForm form, Model model) {
		
		boolean status = userService.signup(form);
		
		if(status) {
			model.addAttribute("successMsg", "Registered successfully");
		}
		else {
			model.addAttribute("errMsg", "Email Already Registered");
		}
		
		model.addAttribute("signupForm", new SignUpForm());
		System.out.println(form);
		return "register";
	}
	
	@GetMapping("/login")
	public String loginPage(Model model) {
		
		model.addAttribute("loginForm", new LoginForm());
		
		return "login";
	}
	
	@PostMapping("/login")
	public String loginUser(LoginForm form, Model model) {
		
		String msg = userService.login(form);
		
		if(msg.equals("success")) {
			return "redirect:/dashboard";	
		} 
		else {
			
			model.addAttribute("errMsg", msg);
		}
		
		
		System.out.println(form);
		
		return "login";
	}
	
	@GetMapping("/dashboard")
	public String loadDashboardPage() {
		return "dashboard";
	}
}
