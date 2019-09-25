package com.crud.crudofheroes.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.crud.crudofheroes.model.Hero;
import com.crud.crudofheroes.model.Parceiro;
import com.crud.crudofheroes.model.Poderes;

public class HeroDto {

	private Long idHeroi;
	private String nomeHeroi;
	private List<Poderes> nomePoderes;
	private List<Parceiro> nomeParceiro;

	public HeroDto(Hero hero) {
		this.idHeroi = hero.getIdHeroi();
		this.nomeHeroi = hero.getNomeHeroi();
		this.nomePoderes = hero.getNomePoderes();
		this.nomeParceiro = hero.getNomeParceiro();
	}

	public Long getIdHeroi() {
		return idHeroi;
	}

	public String getNomeHeroi() {
		return nomeHeroi;
	}

	public List<Poderes> getNomePoderes() {
		return nomePoderes;
	}

	public List<Parceiro> getNomeParceiro() {
		return nomeParceiro;
	}

	public static List<HeroDto> converte(List<Hero> heroes) {
		return heroes.stream().map(HeroDto::new).collect(Collectors.toList());
	}

}
