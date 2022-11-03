package com.grupo2.ecommerce.controller;


import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.grupo2.ecommerce.model.Produto;
import com.grupo2.ecommerce.service.ProdutoService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/produtos")
public class ProdutoController {

	@Autowired
	ProdutoService service;
	
	@GetMapping
	public List<Produto> list() {
		return service.obterTodos();
	}

	@GetMapping("/{id}")
	public Optional<Produto> read(@PathVariable Long id) {
		return service.obterPorId(id);
	}

	@GetMapping(path = "/imagem/{id}", produces = "image/png")
	public byte[] lerImagem(@PathVariable Long id) throws IOException {
		return service.obterImagemPorId(id);
	}


	@PostMapping(consumes = {"multipart/form-data "}, produces = { "application/json" })
	public Produto add(@RequestPart("produto") Produto produto , @RequestPart("imagem") MultipartFile imagem) throws IOException {
		return service.cadastrar(produto,imagem);
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
