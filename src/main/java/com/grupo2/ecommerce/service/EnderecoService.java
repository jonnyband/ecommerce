package com.grupo2.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grupo2.ecommerce.dto.ViaCepResponseDTO;
import com.grupo2.ecommerce.exception.ResourceBadRequestException;
import com.grupo2.ecommerce.exception.ResourceNotFoundException;
import com.grupo2.ecommerce.model.Endereco;
import com.grupo2.ecommerce.repository.EnderecoRepository;
import com.grupo2.ecommerce.utils.ViaCepUtil;

@Service
public class EnderecoService {
	
	@Autowired
	private EnderecoRepository repositorio;
	
	public List<Endereco> obterTodos(){
		return repositorio.findAll();
	}
	
	public Optional<Endereco> obterPorId(Long id){
		
		Optional<Endereco> optEndereco = repositorio.findById(id);
		
		if(optEndereco.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possível encontrar o endereço com id " + id);
		}
		return optEndereco;
	}
	
	public Endereco cadastrar (Endereco endereco) {
		// validarModelo(endereco);
		ViaCepResponseDTO objetoDTO;
		objetoDTO = ViaCepUtil.getCepResponse(endereco);
		System.out.println(objetoDTO.getLogadouro());
		return repositorio.save(endereco);
	}
	
	public Endereco atualizar (Long id, Endereco endereco) {
		obterPorId(id); // Verificando se existe endereço com o ID informado
		validarModelo(endereco);
		
		endereco.setId(id);
		return repositorio.save(endereco);
	}
	
	public void deletar(Long id) {
		obterPorId(id);
		repositorio.deleteById(id);
	}
	
	private void validarModelo(Endereco endereco) {
		
//		//TODO Falta fazer a verificação se o id do endereço já existe no banco de dados.	
		if(endereco.getCep().length() != 9) {
			throw new ResourceBadRequestException("O CEP deve conter 9 caracteres.");
		}
	}
}
