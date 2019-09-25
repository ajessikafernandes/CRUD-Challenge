package com.crud.crudofheroes.controller.dto;

import com.crud.crudofheroes.model.Poderes;

public class PoderesDto {

	private Long idPoderes;
	private String nomePoderes;

	public PoderesDto(Poderes poderes) {
		this.idPoderes = poderes.getIdPoderes();
		this.nomePoderes = poderes.getNomePoderes();
	}

	public Long getIdPoderes() {
		return idPoderes;
	}

	public String getNomePoderes() {
		return nomePoderes;
	}

}
