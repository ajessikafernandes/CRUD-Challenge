package com.crud.crudofheroes.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//A classe Hero representa uma entidade e seus objetos devem ser persistidos no banco de dados.
@Entity
@Table(name = "HERO")
public class Hero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idHeroi;

	private String nome;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "PODER_HEROI", joinColumns = { 
	@JoinColumn(name = "HERO_ID_HEROI") }, inverseJoinColumns = {
	@JoinColumn(name = "PODERES_ID_PODER") })
	private List<Poderes> poderHeroi = new ArrayList<>();

	@OneToOne(mappedBy = "hero", cascade = CascadeType.ALL)
	private Parceiro parceiro;

	public Hero() {

	}

	public Hero(Long idHero, String nome, List<Poderes> poderHeroi, Parceiro parceiro) {
		this.idHeroi = idHero;
		this.nome = nome;
		this.poderHeroi = poderHeroi;
		this.parceiro = parceiro;
	}

	public Long getIdHeroi() {
		return idHeroi;
	}

	public void setIdHeroi(Long idHeroi) {
		this.idHeroi = idHeroi;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idHeroi == null) ? 0 : idHeroi.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((parceiro == null) ? 0 : parceiro.hashCode());
		result = prime * result + ((poderHeroi == null) ? 0 : poderHeroi.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hero other = (Hero) obj;
		if (idHeroi == null) {
			if (other.idHeroi != null)
				return false;
		} else if (!idHeroi.equals(other.idHeroi))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (parceiro == null) {
			if (other.parceiro != null)
				return false;
		} else if (!parceiro.equals(other.parceiro))
			return false;
		if (poderHeroi == null) {
			if (other.poderHeroi != null)
				return false;
		} else if (!poderHeroi.equals(other.poderHeroi))
			return false;
		return true;
	}

}
