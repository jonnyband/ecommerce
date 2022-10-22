package com.grupo2.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo2.ecommerce.model.ItemPedido;
import com.grupo2.ecommerce.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {
	
	@Autowired
	private ItemPedidoRepository repositorio;
	
	public List<ItemPedido> obterTodos(){
		return repositorio.findAll();
	}
	
	public Optional<ItemPedido> obterPorId(Long id){
		Optional<ItemPedido> optItemPedido = repositorio.findById(id);
		
		return optItemPedido;
	}
	
	public ItemPedido cadastrar(ItemPedido itemPedido) {
		itemPedido.setIdItemPedido(null);
		return repositorio.save(itemPedido);
	}
	
	public ItemPedido atualizar(Long id, ItemPedido itemPedido) {
		obterPorId(id);
		itemPedido.setIdItemPedido(id);
		return repositorio.save(itemPedido);
	}
	
	public void deletar(Long id) {
		obterPorId(id);
		repositorio.deleteById(id);
	}
}
