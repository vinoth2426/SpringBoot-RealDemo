package com.tek.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tek.model.Employee;

@RestController
@CrossOrigin(origins="http://localhost:9090")
public class AppController {

	
	@GetMapping("/access")
	public String greeting() {
		return "Welcome to java techie portal";
	}

	//@CrossOrigin(origins = "http://localhost:9090")
	@GetMapping("/empList")
	public String getEmployeeList() {
		return getEmpList();
	}

	
	public String getEmpList() {

		List<Employee> eList = new ArrayList<>();
		Employee e = new Employee("RAJA", "HCL");
		eList.add(e);

		System.out.println(e.toString());

		return eList.toString();
	}
	
	

}
