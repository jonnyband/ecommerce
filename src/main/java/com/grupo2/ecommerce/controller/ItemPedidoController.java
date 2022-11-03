package com.grupo2.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo2.ecommerce.dto.ItemPedidoResponseDTO;
import com.grupo2.ecommerce.model.ItemPedido;
import com.grupo2.ecommerce.service.ItemPedidoService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/itempedido")
public class ItemPedidoController {
	
	@Autowired
	private ItemPedidoService servico;
	
	@GetMapping
	public ResponseEntity<List<ItemPedido>> obterTodos(){
		List<ItemPedido> lista = servico.obterTodos();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ItemPedido> obterPorId(@PathVariable Long id){
		Optional<ItemPedido> optItemPedido = servico.obterPorId(id);
		return ResponseEntity.ok(optItemPedido.get());
	}
	
	@PostMapping
	public ResponseEntity<ItemPedidoResponseDTO> cadastrar(@RequestBody ItemPedido itemPedido) {
		ItemPedidoResponseDTO itemPedidoResponseDTO = servico.cadastrar(itemPedido);
		return new ResponseEntity<>(itemPedidoResponseDTO, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ItemPedido> atualizar(@PathVariable Long id, @RequestBody ItemPedido itemPedido){
		return ResponseEntity.ok(servico.atualizar(id, itemPedido));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		servico.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
