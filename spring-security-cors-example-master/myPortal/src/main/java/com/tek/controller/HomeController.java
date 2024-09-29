package com.tek.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@GetMapping("/welcome")
	//@CrossOrigin(origins = "http://localhost:9090")
	public String getWelcomeNote() {
		return "Hi Welcome to Java World";
	}

}
