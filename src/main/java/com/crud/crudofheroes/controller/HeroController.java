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

/**
 * @author jessikafernandess 
 */

// @RestController é uma anotação de conveniência que combina @Controller e @ResponseBody 
@RestController
@RequestMapping(value = "/heroes")
public class HeroController {

	//fornece controle sobre onde e como a ligação entre os beans deve ser realizada
	//Um bean pode ser definido como uma classe Java que expõe propriedades, 
	//seguindo uma convenção de nomenclatura simples para os métodos getter e setter
	@Autowired
	public CrudRepository crudRepository;

	//Retorna uma lista de herois
	@GetMapping
	public List<HeroDto> lista(String nomeHeroi) {
		if (nomeHeroi == null) {
			List<Hero> heroes = crudRepository.findAll();
			return HeroDto.converte(heroes);
		} else {
			List<Hero> heroes = crudRepository.findAll();
			return HeroDto.converte(heroes);
		}
	}

	// Metodo responsavel por criar um novo heroi
	@PostMapping
	@Transactional // @Transactional trabalha dentro do escopo de uma transação no banco de dados
	public ResponseEntity<HeroDto> cadastrar(UriComponentsBuilder uriBuilder, @RequestBody Hero hero) { // ResponseEntity representa toda a resposta HTTP: código de status, cabeçalhos e corpo 
		Hero heroes = crudRepository.save(hero);
		URI uri = uriBuilder.path("/heroes/{idHeroi}").buildAndExpand(hero.getIdHeroi()).toUri();
		return ResponseEntity.created(uri).body(new HeroDto(heroes));
	}

	// Retorna os detalhes do heroi por Id
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesHeroDto> detalhar(@PathVariable Long id) {
		Optional<Hero> optional = crudRepository.findById(id);
		if (optional.isPresent()) {
			return ResponseEntity.ok(new DetalhesHeroDto(optional.get()));
		}
		return ResponseEntity.notFound().build();
	}

	// Atualiza os dados do heroi identificado pelo Id
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

	// Deleta um heroi identificado atraves do Id
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
