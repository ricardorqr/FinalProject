package com.example.SpringSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.SpringSecurity.service.UserService;

@Controller
public class PreferencesController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/listUsers")
	public ModelAndView listar(){
		ModelAndView modelAndView = new ModelAndView("preferences");
		modelAndView.addObject("listUsers", userService.findAll());
		return modelAndView;
	}

}