package com.grupo2.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
		
		/*if(optPedido.isEmpty()) {
			throw new ResourceNotFoundException("Não");
		}*/
		
		return optPedido;
	}
	
	public Pedido cadastrar(Pedido pedido) {
		
		pedido.setId(null);
		
		return repositorio.save(pedido);
	}
	
	public Pedido atualizar(Long id, Pedido pedido) {
		obterPorId(id);
		
		pedido.setId(id);
		return repositorio.save(pedido);
	}
	
	public void deletar(Long id) {
		obterPorId(id);
		repositorio.deleteById(id);
	}
	
}
