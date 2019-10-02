package com.crud.crudofheroes.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.crud.crudofheroes.model.Hero;
import com.crud.crudofheroes.model.Parceiro;
import com.crud.crudofheroes.model.Poderes;

//Trasporte de dados entre diferentes componentes do sistema via serialização
public class HeroDto {

	private Long idHeroi;
	private String nome;
	private List<Poderes> poderHeroi;
	private Parceiro parceiro;

	public HeroDto(Hero hero) {
		this.idHeroi = hero.getIdHeroi();
		this.nome = hero.getNome();
		this.poderHeroi = hero.getPoderHeroi();
		this.parceiro = hero.getParceiro();
	}

	public Long getIdHeroi() {
		return idHeroi;
	}

	public String getNome() {
		return nome;
	}

	public List<Poderes> getPoderHeroi() {
		return poderHeroi;
	}

	public Parceiro getParceiro() {
		return parceiro;
	}

	public static List<HeroDto> converte(List<Hero> heroes) {
		return heroes.stream().map(HeroDto::new).collect(Collectors.toList());
	}

}
