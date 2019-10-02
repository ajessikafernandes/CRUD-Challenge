package com.crud.crudofheroes;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAutoConfiguration: ativar o mecanismo de configuração automática do Spring Boot
//@ComponentScan: habilite a @Componentverificação no pacote em que o aplicativo está localizado (consulte as práticas recomendadas )
//@Configuration: permite registrar beans extras no contexto ou importar classes de configuração adicionais
@SpringBootApplication // Equivalente a @Configuration @EnableAutoConfiguration @ComponentScan 
public class CrudOfHeroesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudOfHeroesApplication.class, args);
	}

}
