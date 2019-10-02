
package com.crud.crudofheroes.controller.form;

import java.util.List;

import com.crud.crudofheroes.model.Hero;
import com.crud.crudofheroes.model.Parceiro;
import com.crud.crudofheroes.model.Poderes;
import com.crud.crudofheroes.repository.CrudRepository;

//Atualiza dos dados do Heroi no repositorio
public class AtualizarHero {

	private String nome;
	private List<Poderes> poderHeroi;
	private Parceiro parceiro;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Poderes> getPoderHeroi() {
		return poderHeroi;
	}

	public void setPoderHeroi(List<Poderes> poderHeroi) {
		this.poderHeroi = poderHeroi;
	}

	public Parceiro getParceiro() {
		return parceiro;
	}

	public void setParceiro(Parceiro parceiro) {
		this.parceiro = parceiro;
	}

	public Hero atualizarHero(Long id, CrudRepository crudRepository) {
		Hero hero = crudRepository.getOne(id);
		hero.setNome(nome);
		hero.setPoderHeroi(poderHeroi);
		hero.setParceiro(parceiro);
		return hero;
	}
}
