package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepo;

	public Iterable<Product> findAll() {
		return productRepo.findAll();
	}
	
	@Override
	public void addQuantity(Long id) {
		Product product = productRepo.findById(id).get().addQuantity();
		
		productRepo.save(product);	
	}

	@Override
	public void subtractQuantity(Long id) {
		Product product = productRepo.findById(id).get().subtractQuantity();
		
		productRepo.save(product);			
	}

	
}
