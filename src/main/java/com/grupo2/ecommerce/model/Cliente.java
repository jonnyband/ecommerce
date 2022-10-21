package com.grupo2.ecommerce.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id_cliente")
	private Long id;
	
	@Column(name="email",length=30,nullable=false)
	private String email;
	
	@Column(name="nome_usuario",length=20,nullable=false)
	private String nomeUsuario;
	
	@Column(name="nome_completo",length=60,nullable=false)
	private String nomeCompleto;
	
	@Column(name="cpf",length=14,nullable=false)
	private String cpf;
	
	@Column(name="telefone",length=11,nullable=true)
	private String telefone;
	
	@Column(name="data_nasc",nullable=true)
	private Date dataNascimento;
	
	@Column(name="id_endereco",nullable=true)
	private Long idEndereco;
	
	public Cliente() {
	}
	

	public Cliente(String email, String nomeUsuario, String nomeCompleto, String cpf, String telefone,
			Date dataNascimento, Long idEndereco) {
		super();
		this.email = email;
		this.nomeUsuario = nomeUsuario;
		this.nomeCompleto = nomeCompleto;
		this.cpf = cpf;
		this.telefone = telefone;
		this.dataNascimento = dataNascimento;
		this.idEndereco = idEndereco;
	}

	
	//Getters e Setters
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNomeUsuario() {
		return nomeUsuario;
	}


	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}


	public String getNomeCompleto() {
		return nomeCompleto;
	}


	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public Date getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public Long getIdEndereco() {
		return idEndereco;
	}


	public void setIdEndereco(Long idEndereco) {
		this.idEndereco = idEndereco;
	}

}
