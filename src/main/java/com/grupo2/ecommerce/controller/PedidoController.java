package com.grupo2.ecommerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo2.ecommerce.service.PedidoService;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService servico;
	
	public ResponseEntity
}
