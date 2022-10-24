package com.grupo2.ecommerce.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import net.bytebuddy.asm.Advice.Local;

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

	public static boolean verificarData( Date data){
		
		return  true;
	
}
}
