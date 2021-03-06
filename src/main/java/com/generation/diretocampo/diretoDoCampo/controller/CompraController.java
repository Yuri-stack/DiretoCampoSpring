package com.generation.diretocampo.diretoDoCampo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.diretocampo.diretoDoCampo.model.Compra;
import com.generation.diretocampo.diretoDoCampo.repository.CompraRepository;

@RestController
@RequestMapping("/compras")
@CrossOrigin(value = "*", allowedHeaders = "*")
public class CompraController {

	@Autowired
	private CompraRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Compra>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/minhasCompras/{id}")
	public ResponseEntity<List<Compra>> getByEmail(@PathVariable long id){
		return ResponseEntity.ok(repository.findAllByUsuarioId(id));
	
	}
		
	/*
	@GetMapping("/{id}")
	public ResponseEntity<Compra> getById(@PathVariable long id){
		return repository.findById(id).map(compra -> ResponseEntity.ok(compra))
				.orElse(ResponseEntity.notFound().build());
				*/
	
	
	@PostMapping
	public ResponseEntity<Compra> post(@Valid @RequestBody Compra compra){
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(repository.save(compra));
	}
	
	// Implementação Futura
	@PutMapping
	public ResponseEntity<Compra> put(@Valid @RequestBody Compra compra){
		return ResponseEntity.status(HttpStatus.OK)
				.body(repository.save(compra));
	}
}
