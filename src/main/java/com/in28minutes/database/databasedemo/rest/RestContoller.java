package com.in28minutes.database.databasedemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestContoller {

	@Autowired
	welcomeService service;

	@Value("${welcome.message}")
	String welcomeMessage;

	@RequestMapping("/welcome")
	public String message(){
		return service.welcomeMessage();
	}

	@Service
	class welcomeService{
		public String welcomeMessage(){
			return welcomeMessage;
		}
	}
}
