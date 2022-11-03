package com.grupo2.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo2.ecommerce.model.Cliente;
import com.grupo2.ecommerce.model.MensagemEmail;
import com.grupo2.ecommerce.service.ClienteService;
import com.grupo2.ecommerce.service.EmailService;



@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
	ClienteService service;
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping
	public ResponseEntity<List<Cliente>> obterTodos(){
		
		List<Cliente> lista = service.obterTodos();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cliente> obterPorId(@PathVariable Long id){
		
		Optional<Cliente> optCliente = service.obterPorId(id);
		return ResponseEntity.ok(optCliente.get()); // 200
	}
	
	@PostMapping
	public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente) {
		cliente = service.cadastrar(cliente);
		
		// String mensagem =  "<body style=\"max-width: 768px; margin: auto; padding: 0rem 3rem; font-family: Arial, Helvetica, sans-serif\">\r\n"
		// 		+ "    <h1 style=\"margin-top:4rem; color: black; font-size: 1.85rem;\">Bem vindo, <span style=\"background-color: rgb(255, 228, 139); padding: 4px 4px; border-radius: 6px\">" + cliente.getNomeUsuario() +  "</span>!</h1>\r\n"
		// 		+ "    <p style=\"font-size: 0.875rem;\">Sua conta foi criada com sucesso. A equipe da <a href=\"#\" style=\"color: blue;\">g2ecommerce.com</a>. buscará fornecer o melhor atendimento.</p>\r\n"
		// 		+ "    <div style=\"margin-top: 3rem; border: 1px solid rgb(230, 230, 230); border-radius: 6px; padding: 1rem; box-shadow: 0px 0px 9px 5px rgba(0,0,0,0.1);\">\r\n"
		// 		+ "        <h2 style=\"font-size: 1.5rem; color: brown;\">Resumo da conta</h2>\r\n"
		// 		+ "        <p style=\"font-size: 0.875rem;\"><strong>Nome Completo: </strong>" + cliente.getNomeCompleto() + "</p>\r\n"
		// 				+ "        <p style=\"font-size: 0.875rem;\"><strong>Usuário: </strong>" + cliente.getNomeUsuario() + "</p>\r\n"
		// 		+ "        <p style=\"font-size: 0.875rem;\"><strong>Email: </strong>" + cliente.getEmail() + "</p>\r\n"
		// 		+ "        <p style=\"font-size: 0.875rem;\"><strong>Contato: </strong> " + cliente.getTelefone() + "</p>\r\n"
		// 		+ "        <p style=\"font-size: 0.875rem;\"> <strong>CPF: </strong> "+ cliente.getCpf() +"</p>\r\n"
		// 		+ "        \r\n"
		// 		+ "    </div>\r\n"
		// 		+ "</body>";
		
		//  emailService.enviar(
		//  new MensagemEmail("Cadastro de cliente concluído",
		//                    mensagem,
		//  				   cliente.getEmail()));

		return new ResponseEntity<>(cliente, HttpStatus.CREATED); // 201
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
		return ResponseEntity.ok(service.atualizar(id, cliente)); // 200
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id) {
		service.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
	}
	
}