package com.grupo2.ecommerce.dto;

public class ItemPedidoDTO {
	
	private Long id;
	private Integer quantidade;
	private Integer precoVenda;
	private Double percentualDesconto;
	private Double valorBruto;
	private Double valorLiquido;
	
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
