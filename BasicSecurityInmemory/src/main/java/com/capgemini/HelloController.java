package com.capgemini;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public String hi() {
		return "Welcome to spring security...";
	}
	
	@GetMapping("/admin/hello")
	public String hello() {
		return "Admin, Hello from spring security ...";
	}
	
	@GetMapping("/user")
	public String hello1() {
		return "User, Hello from spring security ...";
	}
}
