package com.crud.crudofheroes.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.crud.crudofheroes.model.Hero;

public class DetalhesHeroDto {

	private Long idHeroi;
	private String nomeHeroi;
	private List<PoderesDto> nomePoderes;
	private List<ParceiroDto> nomeParceiro;

	public DetalhesHeroDto(Hero hero) {
		this.idHeroi = hero.getIdHeroi();
		this.nomeHeroi = hero.getNomeHeroi();
		this.nomePoderes = new ArrayList<>();
		this.nomePoderes.addAll(hero.getNomePoderes().stream().map(PoderesDto::new).collect(Collectors.toList()));
		this.nomeParceiro = new ArrayList<>();
		this.nomeParceiro.addAll(hero.getNomeParceiro().stream().map(ParceiroDto::new).collect(Collectors.toList()));
	}

	public Long getIdHeroi() {
		return idHeroi;
	}

	public String getNomeHeroi() {
		return nomeHeroi;
	}

	public List<PoderesDto> getNomePoderes() {
		return nomePoderes;
	}

	public List<ParceiroDto> getNomeParceiro() {
		return nomeParceiro;
	}

}
