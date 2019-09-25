package com.crud.crudofheroes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.crudofheroes.model.Hero;

public interface HeroRepository extends JpaRepository<Hero, Long> {

	List<Hero> findByNomeHeroi(String nomeHeroi);

}
