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

import com.grupo2.ecommerce.model.Cliente;
import com.grupo2.ecommerce.service.ClienteService;



@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
	ClienteService service;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> obterTodos(){
		
		List<Cliente> lista = service.obterTodos();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> obterPorId(@PathVariable Long id){
		
		Optional<Cliente> optCliente = service.obterPorId(id);
		return ResponseEntity.ok(optCliente.get()); // 200
	}
	
	@PostMapping
	public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente) {
		cliente = service.cadastrar(cliente);
		return new ResponseEntity<>(cliente, HttpStatus.CREATED); // 201
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
		return ResponseEntity.ok(service.atualizar(id, cliente)); // 200
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		service.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
	}
	
}