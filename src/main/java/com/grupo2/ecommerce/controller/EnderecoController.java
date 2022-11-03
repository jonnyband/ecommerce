package com.grupo2.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo2.ecommerce.model.Endereco;
import com.grupo2.ecommerce.service.EnderecoService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/enderecos")
public class EnderecoController {
	
	@Autowired
	EnderecoService service;
	
	@GetMapping
	public ResponseEntity<List<Endereco>> obterTodos(){
		
		List<Endereco> lista = service.obterTodos();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Endereco> obterPorId(@PathVariable Long id){
		
		Optional<Endereco> optCliente = service.obterPorId(id);
		return ResponseEntity.ok(optCliente.get()); // 200
	}
	
	@PostMapping
	public ResponseEntity<Endereco> cadastrar(@RequestBody Endereco endereco) {
		endereco = service.cadastrar(endereco);
		return new ResponseEntity<>(endereco, HttpStatus.CREATED); // 201
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Endereco> atualizar(@PathVariable Long id, @RequestBody Endereco endereco) {
		return ResponseEntity.ok(service.atualizar(id, endereco)); // 200
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		service.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
	}
}
