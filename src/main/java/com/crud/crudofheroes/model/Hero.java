package com.crud.crudofheroes.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "HERO")
public class Hero {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idHeroi;

	@NotNull
	@NotEmpty
	@Length(max = 100)
	@Column(name = "NOME_HEROI", nullable = false)
	private String nomeHeroi;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "hero_idHeroi")
	@Column(name = "NOME_PODERES", nullable = false)
	private List<Poderes> nomePoderes = new ArrayList<>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "hero_idHeroi")
	@Column(name = "NOME_PARCEIRO", nullable = false)
	private List<Parceiro> nomeParceiro = new ArrayList<>();

	public Hero() {

	}

	public Hero(Long id, String nomeHeroi, List<Poderes> nomePoderes, List<Parceiro> nomeParceiro) {
		this.idHeroi = id;
		this.nomeHeroi = nomeHeroi;
		this.nomePoderes = nomePoderes;
		this.nomeParceiro = nomeParceiro;
	}

	public Long getIdHeroi() {
		return idHeroi;
	}

	public void setIdHeroi(Long idHeroi) {
		this.idHeroi = idHeroi;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idHeroi == null) ? 0 : idHeroi.hashCode());
		result = prime * result + ((nomeHeroi == null) ? 0 : nomeHeroi.hashCode());
		result = prime * result + ((nomeParceiro == null) ? 0 : nomeParceiro.hashCode());
		result = prime * result + ((nomePoderes == null) ? 0 : nomePoderes.hashCode());
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
		if (nomeHeroi == null) {
			if (other.nomeHeroi != null)
				return false;
		} else if (!nomeHeroi.equals(other.nomeHeroi))
			return false;
		if (nomeParceiro == null) {
			if (other.nomeParceiro != null)
				return false;
		} else if (!nomeParceiro.equals(other.nomeParceiro))
			return false;
		if (nomePoderes == null) {
			if (other.nomePoderes != null)
				return false;
		} else if (!nomePoderes.equals(other.nomePoderes))
			return false;
		return true;
	}

}
