package com.example.SpringSecurity.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
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
		modelAndView.addObject("users", userService.findAll());
		modelAndView.setViewName("admin/preferences");
		return modelAndView;
	}
	
	@RequestMapping(value = { "/admin/edit/{id}" }, method = RequestMethod.GET)
	public ModelAndView editUser(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView();
		User user = userService.findUserById(id);
		modelAndView.addObject("user", user);
		modelAndView.setViewName("admin/edit");
		return modelAndView;
	}
	
	@RequestMapping(value = { "/admin/edit" }, method = RequestMethod.POST)
	public ModelAndView saveUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("redirect:/admin/edit/" + user.getId());
			return modelAndView;
		} else {
			userService.saveUser(user);
			modelAndView.addObject("users", userService.findAll());
			modelAndView.setViewName("admin/preferences");
			return modelAndView;
		}
	}


}