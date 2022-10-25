package com.grupo2.ecommerce.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.Date;
import java.util.List;

@Entity
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_pedido")
	private Long id;
	
	@Column(name = "data_pedido", nullable = false)
	private Date dataPedido;
	
	@Column(name = "data_entrega")
	private Date dataEntrega;
	
	@Column(name = "data_envio")
	private Date dataEnvio;
	
	@Column(nullable = false)
	private String status;

	@ManyToOne
	@JoinColumn(name = "id_cliente")
	private Cliente cliente;


	@OneToMany( cascade = {CascadeType.ALL}, mappedBy = "pedido")
	private List<ItemPedido> listaItemPedido;


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


	public void setDataEnvio(Date dataEnvio) {
		this.dataEnvio = dataEnvio;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public List<ItemPedido> getListaItemPedido() {
		return listaItemPedido;
	}


	public void setListaItemPedido(List<ItemPedido> listaItemPedido) {
		this.listaItemPedido = listaItemPedido;
	}

}
