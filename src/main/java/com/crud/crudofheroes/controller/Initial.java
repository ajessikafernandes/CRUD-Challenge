package com.crud.crudofheroes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Initial {

	@RequestMapping("/")
	@ResponseBody
	public String body() {
		return "CRUD of heroes using Spring Boot with JPA";
	}
}
