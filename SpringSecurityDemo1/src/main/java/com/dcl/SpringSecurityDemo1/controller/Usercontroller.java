package com.dcl.SpringSecurityDemo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dcl.SpringSecurityDemo1.model.Users;
import com.dcl.SpringSecurityDemo1.service.AddUserService;

@RestController
public class Usercontroller {

	@Autowired
	private AddUserService service;
	
	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);
	
	
	@PostMapping("/register")
	public Users register(@RequestBody Users user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return service.addUser(user);
	}
	
	@PostMapping("/login")
	public String login(@RequestBody Users user) {
		return service.verify(user);
	}
}
