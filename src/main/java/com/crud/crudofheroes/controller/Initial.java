package com.crud.crudofheroes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jessikafernandess 
 */

@Controller //@Controller é responsável tanto por receber requisições como por enviar a resposta ao usuário
public class Initial {

	@RequestMapping("/") // Mapear solicitações da Web para os métodos do Spring Controller.
	@ResponseBody //@ResponseBody informa a um controlador que o objeto retornado é serializado automaticamente no JSON e passado de volta ao objeto HttpResponse .
	public String body() {
		return "CRUD of heroes using Spring Boot with JPA";
	}
}
