package com.dcl.SpringSecurityDemo1.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.dcl.SpringSecurityDemo1.model.Users;
import com.dcl.SpringSecurityDemo1.repository.UserRepo;

@Service
public class AddUserService {

	@Autowired
	private UserRepo userrepo;
	
	@Autowired
	private JWTService jwtToken;
	
	@Autowired
	private AuthenticationManager authmanager;
	public Users addUser(Users user) {
		
		return userrepo.save(user);
		
	}

	public String verify(Users user) {
		 Authentication authentication =
				 authmanager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
	    return jwtToken.generateToken(user.getUsername());
	
	}
}
