package com.project.project_C_1.controller;

import com.project.project_C_1.service.SmtpMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import java.io.IOException;

@RestController
public class RootController {
	
	@Autowired
	private SmtpMailSender smtpMailSender;

	@RequestMapping("/send-mail/{prueba_aux}")
	public void sendMail (@PathVariable String prueba_aux) throws MessagingException {

		smtpMailSender.send("contacto.calebia@gmail.com", "Prueba mail alv 1",
				"Hola CALEBIA soy "+prueba_aux);

		System.out.print(prueba_aux);
		
	}
	

}
