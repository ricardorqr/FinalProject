package com.example.SpringSecurity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.SpringSecurity.model.User;
import com.example.SpringSecurity.service.UserService;

@Controller
public class PreferencesController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "/admin/preferences" }, method = RequestMethod.GET)
	public ModelAndView preferences() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("user", new User());
		modelAndView.addObject("users", userService.findAll());
		modelAndView.setViewName("admin/preferences");
		return modelAndView;
	}

//	@RequestMapping(value = { "/users" }, method = RequestMethod.GET)
//	public List<User> findAll() {
//		// ModelAndView modelAndView = new ModelAndView();
//		// modelAndView.addObject("user", new User());
//		// modelAndView.addObject("users", userService.findAll());
//		// return modelAndView;
//		return userService.findAll();
//	}

}