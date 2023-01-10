package com.training.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.training.springmvc.model.User;
import com.training.springmvc.service.HomeService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	HomeService service;
	
	@RequestMapping(value="/home", method = RequestMethod.POST)
	public String printGreet(ModelMap map, @ModelAttribute("user") User user) {
		
		if(service.validate(user.getUserName(), user.getPassword())) {
			map.addAttribute("msg", "This value is set using ModelMap..");
			return "home";
		}
		else {
			map.addAttribute("error", "Incorrect Credentials!!");
			return "login";
		}
		
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String login() {
		
		//map.addAttribute("msg", "This value is set using ModelMap..");
		return "login";
	}

}

// Create a login page with username and password and on submit button user should go to the home page
