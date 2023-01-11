package com.training.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.training.springmvc.model.Product;
import com.training.springmvc.model.User;
import com.training.springmvc.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@RequestMapping( method = RequestMethod.GET)
	public String getProduct(ModelMap map) {
		
		Product p1 = service.getProduct();
		
		System.out.println(p1.getProdName());
		
		return "login";
		
	}
	
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public String getAllProducts(ModelMap map) {
		
		List<Product> prdList = service.getAllProducts();
		
		map.addAttribute("productList", prdList);
		
		return "product";
		
	}
	@RequestMapping(value="/addProduct", method = RequestMethod.POST)
	public String addProduct(ModelMap map, @ModelAttribute("product") Product product) {
		
		boolean flag = service.addProduct(product);
		
		if(flag) {
			map.addAttribute("msg", "Product Added Successfully!!");
			return "addProduct";
		}
		else {
			map.addAttribute("msg", "Error in Adding new Product!!");
			return "addProduct";
		}
		
		
	}
	
	@RequestMapping(value="/addProduct", method = RequestMethod.GET)
	public String addProductPage() {
		
			return "addProduct";
	
		
		
	}

}
