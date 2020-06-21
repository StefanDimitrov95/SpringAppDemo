package com.example.demo.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import com.example.demo.dto.UserDto;
import com.example.demo.exceptions.UserAlreadyExistsException;
import com.example.demo.services.LoginService;
import com.example.demo.services.UserService;

@Controller
public class RegistrationController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	LoginService loginService;
	
	@GetMapping("/register")
	public String showForm(WebRequest request, Model model) {
		model.addAttribute("user", new UserDto());
		
		return "register";
	}
	
	@PostMapping("/register")
	public String registerUser(@ModelAttribute("user") @Valid UserDto userDto, 
			BindingResult bindingResult) {
		
		if (bindingResult.hasErrors()) {
			return "register";
		}
		try {
			userService.register(userDto);
		} catch (UserAlreadyExistsException uaee) {
			return "redirect:/login";
		}
		
		// auto login on successful registration and redirect to /products
		loginService.autoLogin(userDto.getUsername(), userDto.getPassword());
		
		return "redirect:/products";
	}

}
