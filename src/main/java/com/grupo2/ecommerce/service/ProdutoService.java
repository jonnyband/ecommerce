package com.grupo2.ecommerce.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.grupo2.ecommerce.exception.ResourceNotFoundException;
import com.grupo2.ecommerce.model.Produto;
import com.grupo2.ecommerce.repository.ProdutoRepository;


@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository repositorio;
	
	public List<Produto> obterTodos(){
		return repositorio.findAll();
	}
	
	public Optional<Produto> obterPorId(Long id){
		
		Optional<Produto> optProduto = repositorio.findById(id);
		
		if(optProduto.isEmpty()) {
			throw new ResourceNotFoundException("Não foi possível encontrar o produto com id " + id);
		}
		return optProduto;
	}
	
	public Produto cadastrar (Produto produto, MultipartFile imagem) throws IOException {
		validarModelo(produto);
		
		produto.setId(null);
		produto.setImagem(imagem.getBytes());
		return repositorio.save(produto);
	}
	
	public Produto atualizar (Long id, Produto produto) {
		obterPorId(id); // Verificando se existe usuário com o ID informado
		validarModelo(produto);
		
		produto.setId(id);
		return repositorio.save(produto);
	}
	
	public void deletar(Long id) {
		obterPorId(id);
		repositorio.deleteById(id);
	}
	
	private void validarModelo(Produto produto) {
		
	}

}
