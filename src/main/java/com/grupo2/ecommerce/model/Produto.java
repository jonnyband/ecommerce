package com.grupo2.ecommerce.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produto")
	private Long id;

	@Column(name = "nome", length = 30, nullable = false)
	private String nome;

	@Column(name = "descricao", length = 100, nullable = true)
	private String descricao;

	@Column(name = "qtd_estoque", nullable = false)
	private int quantidadeEstoque;

	@Column(name = "data_cadastro", nullable = true)
	private Date dataCadastro;

	@Column(name = "valor_unitario", nullable = false)
	private Double valorUnitario;

	// imagem?? @Column(name="imagem",nullable=true)

	@Column(name = "id_categoria", nullable = true)
	private Long idCategoria;

	public Produto() {
	}
	
	

	public Produto(String nome, String descricao, int quantidadeEstoque, Date dataCadastro, Double valorUnitario,
			Long idCategoria) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.quantidadeEstoque = quantidadeEstoque;
		this.dataCadastro = dataCadastro;
		this.valorUnitario = valorUnitario;
		this.idCategoria = idCategoria;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(int quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}
}	
	