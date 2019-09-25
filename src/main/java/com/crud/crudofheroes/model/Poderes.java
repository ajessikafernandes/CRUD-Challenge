package com.crud.crudofheroes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "PODERES")
public class Poderes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPoderes;

	@NotNull
	@Column(name = "NOME_PODER", nullable = false)
	private String nomePoderes;

	public Poderes() {

	}

	public Poderes(Long idPoderes, String nomePoder, String nomePoderes) {
		this.idPoderes = idPoderes;
		this.nomePoderes = nomePoderes;
	}

	public Long getIdPoderes() {
		return idPoderes;
	}

	public void setIdPoderes(Long idPoder) {
		this.idPoderes = idPoder;
	}

	public String getNomePoderes() {
		return nomePoderes;
	}

	public void setNomePoderes(String nomePoderes) {
		this.nomePoderes = nomePoderes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPoderes == null) ? 0 : idPoderes.hashCode());
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
		Poderes other = (Poderes) obj;
		if (idPoderes == null) {
			if (other.idPoderes != null)
				return false;
		} else if (!idPoderes.equals(other.idPoderes))
			return false;
		if (nomePoderes == null) {
			if (other.nomePoderes != null)
				return false;
		} else if (!nomePoderes.equals(other.nomePoderes))
			return false;
		return true;
	}

}