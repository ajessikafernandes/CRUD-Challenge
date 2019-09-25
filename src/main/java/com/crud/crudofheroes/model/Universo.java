package com.crud.crudofheroes.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "UNIVERSO")
public class Universo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUniverso;

	@NotNull
	@Column(name = "NOME_UNIVERSO", nullable = false)
	private String nomeUniverso;

	public Universo() {

	}

	public Universo(Long idUniverso, String nomeUniverso) {
		this.idUniverso = idUniverso;
		this.nomeUniverso = nomeUniverso;
	}

	public Long getIdUniverso() {
		return idUniverso;
	}

	public void setIdUniverso(Long idUniverso) {
		this.idUniverso = idUniverso;
	}

	public String getNomeUniverso() {
		return nomeUniverso;
	}

	public void setNomeUniverso(String nomeUniverso) {
		this.nomeUniverso = nomeUniverso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUniverso == null) ? 0 : idUniverso.hashCode());
		result = prime * result + ((nomeUniverso == null) ? 0 : nomeUniverso.hashCode());
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
		Universo other = (Universo) obj;
		if (idUniverso == null) {
			if (other.idUniverso != null)
				return false;
		} else if (!idUniverso.equals(other.idUniverso))
			return false;
		if (nomeUniverso == null) {
			if (other.nomeUniverso != null)
				return false;
		} else if (!nomeUniverso.equals(other.nomeUniverso))
			return false;
		return true;
	}

}
