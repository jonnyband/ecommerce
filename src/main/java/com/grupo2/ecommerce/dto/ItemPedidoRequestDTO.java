package com.grupo2.ecommerce.dto;

import com.grupo2.ecommerce.model.Produto;

public class ItemPedidoRequestDTO {
	
	private Long id;
	private Integer quantidade;
	private Integer precoVenda;
	private Double percentualDesconto;
	private Double valorBruto;
	private Double valorLiquido;
	private PedidoRequestDTO pedido;
	private Produto produto;
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public PedidoRequestDTO getPedido() {
		return pedido;
	}

	public void setPedido(PedidoRequestDTO pedido) {
		this.pedido = pedido;
	}

	private Produto idProduto;
	
	public Produto getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Produto idProduto) {
		this.idProduto = idProduto;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
	public Integer getPrecoVenda() {
		return precoVenda;
	}
	
	public void setPrecoVenda(Integer precoVenda) {
		this.precoVenda = precoVenda;
	}
	
	public Double getPercentualDesconto() {
		return percentualDesconto;
	}
	
	public void setPercentualDesconto(Double percentualDesconto) {
		this.percentualDesconto = percentualDesconto;
	}
	
	public Double getValorBruto() {
		return valorBruto;
	}
	
	public void setValorBruto(Double valorBruto) {
		this.valorBruto = valorBruto;
	}
	
	public Double getValorLiquido() {
		return valorLiquido;
	}
	
	public void setValorLiquido(Double valorLiquido) {
		this.valorLiquido = valorLiquido;
	}
	
}
