package com.example.demo.services;

import com.example.demo.entities.Product;

public interface ProductService {
	
	Iterable<Product> findAll();
	void addQuantity(Long id);
	void subtractQuantity(Long id);
	void deleteById(Long id);

}
