package com.crud.crudofheroes.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author jessikafernandess 
 */

//A classe Poderes representa uma entidade e seus objetos devem ser persistidos no banco de dados.
@Entity
@Table(name = "PODERES")
public class Poderes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPoder;

	@NotNull
	@Column(name = "NOME_PODER", nullable = false)
	private String nomePoderes;

	@JsonIgnore
	@ManyToMany(mappedBy = "poderHeroi", cascade = CascadeType.ALL)
	private List<Hero> poderHeroi;

	public Poderes() {

	}

	public Poderes(Long idPoder, @NotNull String nomePoderes, List<Hero> poderHeroi) {
		this.idPoder = idPoder;
		this.nomePoderes = nomePoderes;
		this.poderHeroi = poderHeroi;
	}

	public Long getIdPoder() {
		return idPoder;
	}

	public void setIdPoder(Long idPoder) {
		this.idPoder = idPoder;
	}

	public String getNomePoderes() {
		return nomePoderes;
	}

	public void setNomePoderes(String nomePoderes) {
		this.nomePoderes = nomePoderes;
	}



	public List<Hero> getPoderHeroi() {
		return poderHeroi;
	}

	public void setPoderHeroi(List<Hero> poderHeroi) {
		this.poderHeroi = poderHeroi;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPoder == null) ? 0 : idPoder.hashCode());
		result = prime * result + ((nomePoderes == null) ? 0 : nomePoderes.hashCode());
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
		Poderes other = (Poderes) obj;
		if (idPoder == null) {
			if (other.idPoder != null)
				return false;
		} else if (!idPoder.equals(other.idPoder))
			return false;
		if (nomePoderes == null) {
			if (other.nomePoderes != null)
				return false;
		} else if (!nomePoderes.equals(other.nomePoderes))
			return false;
		if (poderHeroi == null) {
			if (other.poderHeroi != null)
				return false;
		} else if (!poderHeroi.equals(other.poderHeroi))
			return false;
		return true;
	}

}
