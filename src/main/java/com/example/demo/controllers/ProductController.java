package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.services.LoginService;
import com.example.demo.services.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private LoginService loginService;
	@Autowired
	private ProductService productService;
	
	@GetMapping("/products")
	public String allProducts(Model model) {
		
		model.addAttribute("products", productService.findAll());
		model.addAttribute("user", loginService.findLoggedInUsername());
		
		return "products";
	}
	
	@PostMapping("/products/{id}/subtract")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String subtractQuantity(@PathVariable("id") Long id){
		productService.subtractQuantity(id);
		
		return "redirect:/products";
		
	}

	@PostMapping("/products/{id}/add")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String addQuantity(@PathVariable("id") Long id){
		productService.addQuantity(id);
		
		return "redirect:/products";
	}
	
	@PostMapping("/products/{id}/delete")
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteProduct(@PathVariable("id") Long id){
		productService.deleteById(id);
		
		return "redirect:/products";
	}
}
