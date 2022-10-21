package com.grupo2.ecommerce.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.grupo2.ecommerce.model.Produto;
import com.grupo2.ecommerce.service.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

	@Autowired
	ProdutoService service;

	@GetMapping
	public List<Produto> list() {
		return service.obterTodos();
	}

	@PostMapping
	public Produto add(@RequestBody Produto produto) {

		return service.cadastrar(produto);
	}

	@GetMapping("/{id}")
	public Optional<Produto> read(@PathVariable Long id) {
		return service.obterPorId(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto produto) {

	
		return ResponseEntity.ok(service.atualizar(id, produto)); // 200
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		service.deletar(id);

	}

}