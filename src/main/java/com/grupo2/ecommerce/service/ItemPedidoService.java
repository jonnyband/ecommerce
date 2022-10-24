package com.grupo2.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo2.ecommerce.exception.ResourceBadRequestException;
import com.grupo2.ecommerce.exception.ResourceNotFoundException;
import com.grupo2.ecommerce.model.ItemPedido;
import com.grupo2.ecommerce.model.Produto;
import com.grupo2.ecommerce.repository.ItemPedidoRepository;

@Service
public class ItemPedidoService {
	
	@Autowired
	private ItemPedidoRepository repositorio;

	@Autowired
	private ProdutoService produtoService;
	

	public List<ItemPedido> obterTodos(){
		return repositorio.findAll();
	}
	
	public Optional<ItemPedido> obterPorId(Long id){
		Optional<ItemPedido> optItemPedido = repositorio.findById(id);
		
		if(optItemPedido.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possível encontrar o item com o id "+id);
		}
		
		return optItemPedido;
	}
	
	public ItemPedido cadastrar(ItemPedido itemPedido) {
		validarModelo(itemPedido);

		itemPedido = calcularValores(itemPedido);

		itemPedido.setId(null);
		return repositorio.save(itemPedido);
	}
	
	public ItemPedido atualizar(Long id, ItemPedido itemPedido) {
		obterPorId(id);
		validarModelo(itemPedido);
		itemPedido.setId(id);
		return repositorio.save(itemPedido);
	}
	
	public void deletar(Long id) {
		obterPorId(id);
		repositorio.deleteById(id);
	}

	
private ItemPedido calcularValores(ItemPedido itemPedido) {

	Optional <Produto> produto = produtoService.obterPorId(itemPedido.getProduto().getId());
	itemPedido.setValorBruto(produto.get().getValorUnitario()*itemPedido.getQuantidade());
	if(itemPedido.getPercentualDesconto()== null){
		itemPedido.setPercentualDesconto(0.0);
	}
	itemPedido.setValorLiquido(itemPedido.getValorBruto()-(itemPedido.getValorBruto()*itemPedido.getPercentualDesconto()/100));
	
	return itemPedido;
	
}
	
	private void validarModelo(ItemPedido itemPedido) {
		
		if(itemPedido.getQuantidade() == null) {
			throw new ResourceBadRequestException("A quantidade de itens deve ser informada.");
		}else if (itemPedido.getQuantidade() < 1) {
			throw new ResourceBadRequestException("A quantidade de itens deve ser maior do que 0.");
		}
		
		// if(itemPedido.getPrecoVenda() == null) {
		// 	throw new ResourceBadRequestException("O preço deve ser informado.");
		// }else if (itemPedido.getPrecoVenda() < 1) {
		// 	throw new ResourceBadRequestException("O preço deve ser maior do que 0.");
		// }
		
		// if(itemPedido.getValorBruto() == null) {
		// 	throw new ResourceBadRequestException("O valor bruto deve ser informado.");
		// }else if (itemPedido.getValorBruto() < 1) {
		// 	throw new ResourceBadRequestException("O valor bruto deve ser maior do que 0.");
		// }
		
		// if(itemPedido.getValorLiquido() == null) {
		// 	throw new ResourceBadRequestException("O valor líquido deve ser informada.");
		// }else if (itemPedido.getValorLiquido() < 1) {
		// 	throw new ResourceBadRequestException("O valor líquido deve ser maior do que 0.");
		// }
		
	}


}
