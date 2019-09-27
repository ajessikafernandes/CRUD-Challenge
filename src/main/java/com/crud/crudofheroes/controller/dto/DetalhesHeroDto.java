package com.crud.crudofheroes.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.crud.crudofheroes.model.Hero;
import com.crud.crudofheroes.model.Parceiro;

public class DetalhesHeroDto {

	private Long idHeroi;
	private String nome;
	private List<PoderesDto> nomePoderes;
	private Parceiro parceiro;

	public DetalhesHeroDto(Hero hero) {
		this.idHeroi = hero.getIdHeroi();
		this.nome = hero.getNome();
		this.nomePoderes = new ArrayList<>();
		this.nomePoderes.addAll(hero.getPoderHeroi().stream().map(PoderesDto::new).collect(Collectors.toList()));
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
