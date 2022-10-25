package com.grupo2.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo2.ecommerce.exception.ResourceBadRequestException;
import com.grupo2.ecommerce.exception.ResourceNotFoundException;
import com.grupo2.ecommerce.exception.ResourceUniqueValueException;
import com.grupo2.ecommerce.model.Cliente;
import com.grupo2.ecommerce.repository.ClienteRepository;


@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repositorio;

	
	public List<Cliente> obterTodos(){
		return repositorio.findAll();
	}
	
	public Optional<Cliente> obterPorId(Long id){
		
		Optional<Cliente> optCliente = repositorio.findById(id);
		
		if(optCliente.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possível encontrar o cliente com id " + id);
		}
		return optCliente;
	}
	
	public Cliente cadastrar (Cliente cliente) {
		validarModelo(cliente);
		return repositorio.save(cliente);
			
	}
	
	public Cliente atualizar (Long id, Cliente cliente) {
		obterPorId(id);
	//	validarModelo(cliente);
		
		cliente.setId(id);
		return repositorio.save(cliente);
	}
	
	public void deletar(Long id) {
		obterPorId(id);
		repositorio.deleteById(id);
	}
	
	private void validarModelo(Cliente cliente) {
		

		if(cliente.getEmail() == null) {
			throw new ResourceBadRequestException("O email não pode ser nulo.");
		}
		else if(cliente.getNomeUsuario() == null) {
			throw new ResourceBadRequestException("O nome de usuário não pode ser nulo.");
		}
		else if(cliente.getNomeCompleto() == null) {
			throw new ResourceBadRequestException("O nome de completo não pode ser nulo.");
		}
		else if(cliente.getCpf() == null) {
			throw new ResourceBadRequestException("O CPF não pode ser nulo.");
		}
	
		else if(repositorio.existsByCpf(cliente.getCpf())){
		 throw new ResourceUniqueValueException("CPF " + cliente.getCpf() + " já cadastrado.");}
		else if(repositorio.existsByEmail(cliente.getEmail())){
			throw new ResourceUniqueValueException("Email " + cliente.getEmail() + " já cadastrado.");
		}
	}
		
	
	
}
