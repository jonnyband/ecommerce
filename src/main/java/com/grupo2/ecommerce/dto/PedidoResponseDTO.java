package com.grupo2.ecommerce.dto;

import java.util.Date;
import java.util.List;

import com.grupo2.ecommerce.model.Cliente;

public class PedidoResponseDTO {
	
	private Long id;
	private Date dataPedido;
	private Date dataEntrega;
	private Date dataEnvio;
	private String status;
	private List<ItemPedidoResponseDTO> listaItemPedido;



	public List<ItemPedidoResponseDTO> getListaItemPedido() {
		return listaItemPedido;
	}

	public void setListaItemPedido(List<ItemPedidoResponseDTO> listaItemPedido) {
		this.listaItemPedido = listaItemPedido;
	}

	private Cliente cliente;
	


	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Date getDataPedido() {
		return dataPedido;
	}
	
	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}
	
	public Date getDataEntrega() {
		return dataEntrega;
	}
	
	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	
	public Date getDataEnvio() {
		return dataEnvio;
	}
	
	public void setDataEnvio(Date datEnvio) {
		this.dataEnvio = datEnvio;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
}
