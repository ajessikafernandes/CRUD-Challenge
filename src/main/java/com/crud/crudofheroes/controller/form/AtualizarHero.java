
package com.crud.crudofheroes.controller.form;

import java.util.List;

import com.crud.crudofheroes.model.Hero;
import com.crud.crudofheroes.model.Parceiro;
import com.crud.crudofheroes.model.Poderes;
import com.crud.crudofheroes.repository.HeroRepository;

public class AtualizarHero {

	private String nomeHeroi;
	private List<Poderes> nomePoderes;
	private List<Parceiro> nomeParceiro;

	public String getNomeHeroi() {
		return nomeHeroi;
	}

	public void setNomeHeroi(String nomeHeroi) {
		this.nomeHeroi = nomeHeroi;
	}

	public List<Poderes> getNomePoderes() {
		return nomePoderes;
	}

	public void setNomePoderes(List<Poderes> nomePoderes) {
		this.nomePoderes = nomePoderes;
	}

	public List<Parceiro> getNomeParceiro() {
		return nomeParceiro;
	}

	public void setNomeParceiro(List<Parceiro> nomeParceiro) {
		this.nomeParceiro = nomeParceiro;
	}

	public Hero atualizarHero(Long id, HeroRepository heroRepository) {
		Hero hero = heroRepository.getOne(id);
		hero.setNomeHeroi(nomeHeroi);
		hero.setNomePoderes(nomePoderes);
		hero.setNomeParceiro(nomeParceiro);
		return hero;
	}
}
