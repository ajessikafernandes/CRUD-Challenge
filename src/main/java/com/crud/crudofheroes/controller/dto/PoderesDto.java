package com.crud.crudofheroes.controller.dto;

import com.crud.crudofheroes.model.Poderes;

/**
 * @author jessikafernandess 
 */

public class PoderesDto {

	private Long idPoder;
	private String nomePoderes;

	public PoderesDto(Poderes poderes) {
		this.idPoder = poderes.getIdPoder();
		this.nomePoderes = poderes.getNomePoderes();
	}

	public Long getIdPoder() {
		return idPoder;
	}

	public String nomePoderes() {
		return nomePoderes;
	}

}
