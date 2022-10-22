package com.grupo2.ecommerce.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	private Long id;

	@Column(name = "nome", length = 30, nullable = false)
	private String nome;

	@Column(name = "descricao", length = 100, nullable = true)
	private String descricao;

	public Categoria() {
	}
	
	

	public Categoria(Long idCategoria, String nome, String descricao) {
		super();
		this.id = idCategoria;
		this.nome = nome;
		this.descricao = descricao;
				
	}



	public Object getId() {
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
	
	
}