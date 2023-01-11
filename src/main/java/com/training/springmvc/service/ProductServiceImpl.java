package com.training.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.training.springmvc.dao.ProductDao;
import com.training.springmvc.model.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	ProductDao productDao;
	
	@Override
	public Product getProduct() {
		Product p1 = productDao.getProductById(103);
		return p1;
	}

}
