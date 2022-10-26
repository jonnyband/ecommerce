package com.grupo2.ecommerce.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.grupo2.ecommerce.exception.ResourceBadRequestException;
import com.grupo2.ecommerce.model.Pedido;


public class ConversorDeData {

	
	public static String converterDateParaDataEHoraISO(Date data) {
		SimpleDateFormat formatador = new SimpleDateFormat("YYYY-MM-dd");
		return formatador.format(data) + "T" + converterDateParaHora(data);
	}
	
	public static String converterDateParaDataEHora(Date data) {
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
		return formatador.format(data);
	}
	
	public static String converterDateParaData(Date data) {
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/YYYY");
		return formatador.format(data);
	}
	
	public static String converterDateParaHora(Date data) {
		SimpleDateFormat formatador = new SimpleDateFormat("HH:mm:ss");
		return formatador.format(data);
	}

	public static void validarData(Pedido pedido) {
	
        if(!new Date().after(pedido.getDataPedido())) {
            throw new ResourceBadRequestException("Data inválida");
        }
    }
}

