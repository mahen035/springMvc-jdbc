package com.training.springmvc.service;

import java.util.List;

import com.training.springmvc.model.Product;

public interface ProductService {
	
	public Product getProduct();
	
	public List<Product> getAllProducts();

}
