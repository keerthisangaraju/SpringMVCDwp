package com.WelcomeJava;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeJava {
	
	@RequestMapping("/welcomejava")
	public String PrintWelcome()
	{
		return "Welcome to JAVA";
	}

}
