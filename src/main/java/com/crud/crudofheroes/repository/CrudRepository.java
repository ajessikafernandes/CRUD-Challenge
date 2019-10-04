package com.crud.crudofheroes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.crudofheroes.model.Hero;

/**
 * @author jessikafernandess 
 */

public interface CrudRepository extends JpaRepository<Hero, Long> {

	List<Hero> findByNome(String nome);
	
}
