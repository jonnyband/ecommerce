package com.grupo2.ecommerce.utils;

import org.springframework.web.client.RestTemplate;

import com.grupo2.ecommerce.dto.ViaCepResponseDTO;
import com.grupo2.ecommerce.model.Endereco;

public class ViaCepUtil {

	
	
	public static ViaCepResponseDTO getCepResponse(Endereco endereco) {

		try {
			if (validaCep(endereco) == false) {
				throw new RuntimeException("Formato de CEP inválido");
			}

			String url = "http://viacep.com.br/ws/"+endereco.getCep()+"/json/";
			RestTemplate restTemplate = new RestTemplate();
			ViaCepResponseDTO result = restTemplate.getForObject(url, ViaCepResponseDTO.class);
			return result;

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	// Verificando a quantidade de digitos do CEP
	public static boolean validaCep(Endereco endereco) {
		if (!endereco.getCep().matches("\\d{8}")) {
			return false;
		}
		return true;
	}
}
