package com.grupo2.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grupo2.ecommerce.dto.PedidoRequestDTO;
import com.grupo2.ecommerce.dto.PedidoResponseDTO;
import com.grupo2.ecommerce.model.MensagemEmail;
import com.grupo2.ecommerce.model.Pedido;
import com.grupo2.ecommerce.service.EmailService;
import com.grupo2.ecommerce.service.PedidoService;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService servico;

	@Autowired
	private EmailService emailService;
	
	@GetMapping
	public ResponseEntity<List<PedidoResponseDTO>> obterTodos(){
		List<PedidoResponseDTO> lista = servico.obterTodos();
		return ResponseEntity.ok(lista);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> obterPorId(@PathVariable Long id){
		Optional<Pedido> optPedido = servico.obterPorId(id);
		return ResponseEntity.ok(optPedido.get());
	}
	
	// 		emailService.enviar(
	// new MensagemEmail("Pedido de "+ pedidoResponseDTO.getCliente().getNomeCompleto(),
	//                   "Pedido, "+pedidoResponseDTO.getId()+" realizado com sucesso!",
	// 				  pedidoResponseDTO.getCliente().getEmail()));
	@PostMapping()
	public ResponseEntity<PedidoResponseDTO> cadastrar(@RequestBody PedidoRequestDTO pedidoDTO) {
		PedidoResponseDTO pedidoResponseDTO = servico.cadastrar(pedidoDTO);
		
		double soma = 0;
		
		for(int i = 0; i < pedidoResponseDTO.getListaItemPedido().size(); i++) {
			soma += pedidoResponseDTO.getListaItemPedido().get(i).getValorLiquido();
		}
		
		
		String mensagem = "<body style=\"max-width: 768px; margin: auto; padding: 0rem 3rem; font-family: Arial, Helvetica, sans-serif\">\r\n"
				+ "    <h1 style=\"margin-top:4rem; font-size: 1.85rem;\">Olá, <span style=\"background-color: rgb(255, 228, 139); padding: 4px 4px; border-radius: 6px\">" + pedidoResponseDTO.getCliente().getNomeUsuario() +  "</span>!</h1>\r\n"
				+ "    <p style=\"font-size: 0.875rem;\">Agradecemos por comprar na <a href=\"#\" style=\"color: blue;\">g2ecommerce.com</a>. Seu pedido foi recebido e será processado após a confirmação do pagamento. Caso o pagamento não seja confirmado dentro do período de três dias, seu pedido será automaticamente cancelado.</p>\r\n"
				+ "    <div style=\"margin-top: 3rem; border: 1px solid rgb(230, 230, 230); border-radius: 6px; padding: 1rem; box-shadow: 0px 0px 9px 5px rgba(0,0,0,0.1);\">\r\n"
				+ "        <h2 style=\"font-size: 1.5rem; color: brown;\">Resumo do pedido</h2>\r\n"
				+ "        <p style=\"font-size: 0.875rem;\"><strong>Comprador: </strong>" + pedidoResponseDTO.getCliente().getNomeCompleto() + "</p>\r\n"
				+ "        <p style=\"font-size: 0.875rem;\"><strong>Pedido n°: </strong>" + pedidoResponseDTO.getId() + "</p>\r\n"
				+ "        <p style=\"font-size: 0.875rem;\"><strong>Realizado em: </strong>" + pedidoResponseDTO.getDataPedido() + " - Horário de Brasília.</p>\r\n"
				+ "        <p style=\"font-size: 0.875rem;\"> <strong style=\"font-size: 1.25rem;\">Total do pedido:</strong> R$ "+ soma +"</p>\r\n"
				+ "        \r\n"
				+ "        <div style=\"border-top: 1px solid rgb(223, 220, 220)\">\r\n"
				+ "            <h3 style=\"font-size: 1.25rem; margin-bottom: 0px; padding: 0px;\">Será enviado para:</h3>\r\n"
				+ "            <p style=\"font-size: 0.875rem;\">"
								+ pedidoResponseDTO.getCliente().getEndereco().getCep() + ", "
								+ pedidoResponseDTO.getCliente().getEndereco().getCidade() + " - "
								+ pedidoResponseDTO.getCliente().getEndereco().getUf() +". "
								+ pedidoResponseDTO.getCliente().getEndereco().getBairro() +", "
								+ pedidoResponseDTO.getCliente().getEndereco().getNumero() +". "
								+ pedidoResponseDTO.getCliente().getEndereco().getComplemento() +".</p>\r\n"
				+ "        </div>\r\n"
				+ "\r\n"
				+ "    </div>\r\n"
				+ "</body>";
		
		emailService.enviar(
				new MensagemEmail("Confirmação do pedido n°" +  pedidoResponseDTO.getId(),
										mensagem,
										pedidoResponseDTO.getCliente().getEmail())
				);
		
		return new ResponseEntity<>(pedidoResponseDTO, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Pedido> atualizar(@PathVariable Long id, @RequestBody Pedido pedido){
		return ResponseEntity.ok(servico.atualizar(id, pedido));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		servico.deletar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
