package com.grupo2.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import com.grupo2.ecommerce.dto.ItemPedidoRequestDTO;
import com.grupo2.ecommerce.dto.PedidoRequestDTO;
import com.grupo2.ecommerce.dto.PedidoResponseDTO;
import com.grupo2.ecommerce.exception.ResourceBadRequestException;
import com.grupo2.ecommerce.exception.ResourceNotFoundException;
import com.grupo2.ecommerce.model.ItemPedido;
import com.grupo2.ecommerce.model.Pedido;
import com.grupo2.ecommerce.repository.PedidoRepository;
import com.grupo2.ecommerce.utils.ConversorDeData;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repositorio;

	@Autowired
	private ItemPedidoService itemPedidoService;

	@Autowired
	private ClienteService clienteService;

	private ModelMapper mapper = new ModelMapper();
	
	public List<PedidoResponseDTO> obterTodos(){
		List<Pedido> list = repositorio.findAll();
		List<PedidoResponseDTO> pedidoResponseDTO = new ArrayList<>();
		for (int i = 0; i< list.size(); i++) {
			pedidoResponseDTO.add(mapper.map(list.get(i), PedidoResponseDTO.class));
		}
		return pedidoResponseDTO;
	}
	
	public Optional<Pedido> obterPorId(Long id){
		
		Optional<Pedido> optPedido = repositorio.findById(id);
		
		if(optPedido.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possível encontrar o pedido com o id "+id);
		}
		
		return optPedido;
	}
	
	public PedidoResponseDTO cadastrar(PedidoRequestDTO pedidoDTO) {

		Pedido pedido = mapper.map(pedidoDTO, Pedido.class);
		ConversorDeData.validarData(pedido);
		validarModelo(pedido);
		pedido = repositorio.save(pedido);
		pedido.setCliente(clienteService.obterPorId(pedido.getCliente().getId()).get());
		pedido.getListaItemPedido().clear();
		for (ItemPedidoRequestDTO itemPedidoDTO: pedidoDTO.getListaItemPedido()) {
			ItemPedido itemPedido = mapper.map(itemPedidoDTO, ItemPedido.class);
			itemPedido.setPedido(pedido);
			itemPedidoService.cadastrar(itemPedido);
			pedido.getListaItemPedido().add(itemPedido);
		}
		PedidoResponseDTO pedidoResponseDTO = mapper.map(pedido, PedidoResponseDTO.class);
		return pedidoResponseDTO;
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
