package com.crud.crudofheroes.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.crud.crudofheroes.model.Hero;
import com.crud.crudofheroes.model.Parceiro;

/**
 * @author jessikafernandess 
 */

public class DetalhesHeroDto {

	private Long idHeroi;
	private String nome;
	private List<PoderesDto> nomePoderes;
	private Parceiro parceiro;

	// Converte os dados para DetalhesHeroDto
	public DetalhesHeroDto(Hero hero) {
		//Retorna as variaveis de heroi
		this.idHeroi = hero.getIdHeroi();
		this.nome = hero.getNome();
		//Cria uma nova lista
		this.nomePoderes = new ArrayList<>();
		//Retorna todas as variaveis de PoderHeroi, cria uma coleção de PoderHeroi, e converte para lista de PoderesDto
		this.nomePoderes.addAll(hero.getPoderHeroi().stream().map(PoderesDto::new).collect(Collectors.toList()));
		//Retorna todas as variaveis de Parceiro
		this.parceiro = hero.getParceiro();
	}

	public Long getIdHeroi() {
		return idHeroi;
	}

	public String getNome() {
		return nome;
	}

	public List<PoderesDto> getNomePoderes() {
		return nomePoderes;
	}

	public Parceiro getParceiro() {
		return parceiro;
	}

}
