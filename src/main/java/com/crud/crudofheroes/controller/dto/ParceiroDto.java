package com.crud.crudofheroes.controller.dto;

import com.crud.crudofheroes.model.Parceiro;

/**
 * @author jessikafernandess 
 */

public class ParceiroDto {

	private Long idParceiro;
	private String nomeParceiro;

	public ParceiroDto(Parceiro parceiro) {
		this.idParceiro = parceiro.getIdParceiro();
		this.nomeParceiro = parceiro.getNomeParceiro();
	}

	public Long getIdParceiro() {
		return idParceiro;
	}

	public String getNomeParceiro() {
		return nomeParceiro;
	}

}
