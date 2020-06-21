package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.repositories.ProductRepository;
import com.example.demo.services.LoginService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository productRepo;
	@Autowired
	private LoginService loginService;
	
	@GetMapping("/products")
	public String allProducts(Model model) {
		
		model.addAttribute("products", productRepo.findAll());
		model.addAttribute("user", loginService.findLoggedInUsername());
		
		return "products";
	}
}
