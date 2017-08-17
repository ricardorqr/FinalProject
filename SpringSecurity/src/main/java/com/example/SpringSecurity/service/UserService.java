package com.example.SpringSecurity.service;

import java.util.List;

import com.example.SpringSecurity.model.User;

public interface UserService {
	
	public User findUserById(Integer id);

	public User findUserByEmail(String email);

	public void saveUser(User user);
	
	public List<User> findAll();

}
