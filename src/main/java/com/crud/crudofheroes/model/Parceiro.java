package com.crud.crudofheroes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PARCEIRO")
public class Parceiro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idParceiro;

	@NotNull
	@Column(name = "NOME_PARCEIRO", nullable = false)
	private String nomeParceiro;

	public Parceiro() {

	}

	public Parceiro(Long idParceiro, String nomeParceiro) {
		this.idParceiro = idParceiro;
		this.nomeParceiro = nomeParceiro;
	}

	public Long getIdParceiro() {
		return idParceiro;
	}

	public void setIdParceiro(Long idParceiro) {
		this.idParceiro = idParceiro;
	}

	public String getNomeParceiro() {
		return nomeParceiro;
	}

	public void setNomeParceiro(String nomeParceiro) {
		this.nomeParceiro = nomeParceiro;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idParceiro == null) ? 0 : idParceiro.hashCode());
		result = prime * result + ((nomeParceiro == null) ? 0 : nomeParceiro.hashCode());
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
		Parceiro other = (Parceiro) obj;
		if (idParceiro == null) {
			if (other.idParceiro != null)
				return false;
		} else if (!idParceiro.equals(other.idParceiro))
			return false;
		if (nomeParceiro == null) {
			if (other.nomeParceiro != null)
				return false;
		} else if (!nomeParceiro.equals(other.nomeParceiro))
			return false;
		return true;
	}

}
