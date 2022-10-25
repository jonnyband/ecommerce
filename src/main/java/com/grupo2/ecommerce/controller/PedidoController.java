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

import com.grupo2.ecommerce.dto.PedidoRequestDTO;
import com.grupo2.ecommerce.dto.PedidoResponseDTO;
import com.grupo2.ecommerce.model.MensagemEmail;
import com.grupo2.ecommerce.model.Pedido;
import com.grupo2.ecommerce.service.EmailService;
import com.grupo2.ecommerce.service.PedidoService;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService servico;

	@Autowired
	private EmailService emailService;
	
	@GetMapping
	public ResponseEntity<List<PedidoResponseDTO>> obterTodos(){
		List<PedidoResponseDTO> lista = servico.obterTodos();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> obterPorId(@PathVariable Long id){
		Optional<Pedido> optPedido = servico.obterPorId(id);
		return ResponseEntity.ok(optPedido.get());
	}
	
	@PostMapping()
	public ResponseEntity<PedidoResponseDTO> cadastrar(@RequestBody PedidoRequestDTO pedidoDTO) {
		PedidoResponseDTO pedidoResponseDTO = servico.cadastrar(pedidoDTO);
		// 		emailService.enviar(
		// new MensagemEmail("Pedido de "+ pedidoResponseDTO.getCliente().getNomeCompleto(),
		//                   "Pedido, "+pedidoResponseDTO.getId()+" realizado com sucesso!",
		// 				  pedidoResponseDTO.getCliente().getEmail()));
		return new ResponseEntity<>(pedidoResponseDTO, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pedido> atualizar(@PathVariable Long id, @RequestBody Pedido pedido){
		return ResponseEntity.ok(servico.atualizar(id, pedido));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		servico.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
