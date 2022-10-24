package com.grupo2.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo2.ecommerce.exception.ResourceBadRequestException;
import com.grupo2.ecommerce.exception.ResourceNotFoundException;
import com.grupo2.ecommerce.model.Pedido;
import com.grupo2.ecommerce.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repositorio;
	
	public List<Pedido> obterTodos(){
		return repositorio.findAll();
	}
	
	public Optional<Pedido> obterPorId(Long id){
		
		Optional<Pedido> optPedido = repositorio.findById(id);
		
		if(optPedido.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possível encontrar o pedido com o id "+id);
		}
		
		return optPedido;
	}
	
	public Pedido cadastrar(Pedido pedido) {
		validarModelo(pedido);
		pedido.setId(null);
		return repositorio.save(pedido);
	}
	
	public Pedido atualizar(Long id, Pedido pedido) {
		obterPorId(id);
		validarModelo(pedido);
		pedido.setId(id);
		return repositorio.save(pedido);
	}
	
	public void deletar(Long id) {
		obterPorId(id);
		repositorio.deleteById(id);
	}
	
	private void validarModelo(Pedido pedido) {
		if(pedido.getDataPedido() == null) {
			throw new ResourceBadRequestException("A data do pedido deve ser informada.");
		}else if(pedido.getStatus() == null) {
			throw new ResourceBadRequestException("O status deve ser informado.");
		}
	}
	
}
