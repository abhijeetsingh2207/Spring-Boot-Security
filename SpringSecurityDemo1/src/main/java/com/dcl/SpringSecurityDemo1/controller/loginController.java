package com.dcl.SpringSecurityDemo1.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dcl.SpringSecurityDemo1.model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class loginController {
	
	private List<Student> list= new ArrayList<Student>(List.of(
			new Student(1,"ram",100),
			new Student(2,"shyam",80)
			));

	@GetMapping("/")
	public String login(HttpServletRequest request) {
		return " hi abhijeet" + request.getSession().getId();
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return list;
	}
	
	@PostMapping("/addStudent")
	public Student addStudent(@RequestBody Student s){
		 list.add(s);
		 return s; 
	}
	
	@GetMapping("/csrf_token")
	public CsrfToken gettoken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
	}
}
