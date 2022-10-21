package com.grupo2.ecommerce.service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.grupo2.ecommerce.model.MensagemEmail;

@Service
public class EmailService {

	@Autowired
	private JavaMailSender javaMailSender;
	
	public void enviar(MensagemEmail MensagemEmail)  {
		
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
		
		try {
			helper.setFrom(MensagemEmail.getRemetente());
			helper.setSubject(MensagemEmail.getAssunto());
			helper.setText(MensagemEmail.getMensagem(), true);
			helper.setTo(MensagemEmail.getDestinatarios()
			.toArray(new String[MensagemEmail.getDestinatarios().size()]));
			
			javaMailSender.send(mimeMessage);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		
	}
}
