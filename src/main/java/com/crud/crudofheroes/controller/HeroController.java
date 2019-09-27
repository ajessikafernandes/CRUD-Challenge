package com.crud.crudofheroes.controller;

import java.net.URI;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.crud.crudofheroes.controller.dto.DetalhesHeroDto;
import com.crud.crudofheroes.controller.dto.HeroDto;
import com.crud.crudofheroes.controller.form.AtualizarHero;
import com.crud.crudofheroes.model.Hero;
import com.crud.crudofheroes.repository.CrudRepository;

@RestController
@RequestMapping(value = "/heroes")
public class HeroController {

	@Autowired
	public CrudRepository crudRepository;

	@GetMapping
	public List<HeroDto> lista(String nomeHeroi) {
		if (nomeHeroi == null) {
			List<Hero> heroes = crudRepository.findAll();
			return HeroDto.converte(heroes);
		} else {
			List<Hero> heroes = crudRepository.findByNome(nomeHeroi);
			return HeroDto.converte(heroes);
		}
	}

	@PostMapping
	@Transactional
	public ResponseEntity<HeroDto> cadastrar(UriComponentsBuilder uriBuilder, @RequestBody Hero hero) {
		Hero heroes = crudRepository.save(hero);
		URI uri = uriBuilder.path("/heroes/{idHeroi}").buildAndExpand(hero.getIdHeroi()).toUri();
		return ResponseEntity.created(uri).body(new HeroDto(heroes));
	}

	@GetMapping("/{id}")
	public ResponseEntity<DetalhesHeroDto> detalhar(@PathVariable Long id) {
		Optional<Hero> optional = crudRepository.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(new DetalhesHeroDto(optional.get()));
		}
		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional

	public ResponseEntity<HeroDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarHero form) {
		Optional<Hero> optional = crudRepository.findById(id);
		if (optional.isPresent()) {
			Hero hero = form.atualizarHero(id, crudRepository);
			return ResponseEntity.ok(new HeroDto(hero));
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Hero> optional = crudRepository.findById(id);
		if (optional.isPresent()) {
			crudRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}

}
