package com.grupo2.ecommerce.dto;

import java.util.Date;

public class PedidoDTO {
	
	private Long id;
	private Date dataPedido;
	private Date dataEntrega;
	private Date datEnvio;
	private String status;
	
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
	
	public Date getDatEnvio() {
		return datEnvio;
	}
	
	public void setDatEnvio(Date datEnvio) {
		this.datEnvio = datEnvio;
	}
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
}
