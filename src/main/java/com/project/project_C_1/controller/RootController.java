package com.project.project_C_1.controller;

import com.google.gson.Gson;
import com.project.project_C_1.entity.Form;
import com.project.project_C_1.service.SmtpMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
public class RootController {
	
	@Autowired
	private SmtpMailSender smtpMailSender;

//	@Autowired
//	FormDao formDao;

//	@RequestMapping(value = "/send-mail", method = RequestMethod.POST)
	@PostMapping("/send-mail")
	public void sendMail (@RequestBody String prueba_aux) throws MessagingException {
		Gson gson = new Gson();
//		ArrayList<Form> yourArray = gson.fromJson(prueba_aux, new TypeToken<List<Form>>(){}.getType());
		Form formAux = new Form();
		formAux = gson.fromJson(prueba_aux,Form.class);

		String SendString = "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n" +
				"<html xmlns=\"http://www.w3.org/1999/xhtml\" \n" +
				" xmlns:v=\"urn:schemas-microsoft-com:vml\"\n" +
				" xmlns:o=\"urn:schemas-microsoft-com:office:office\">\n" +
				"<head>\n" +
				"  \n" +
				"  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n" +
				"  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> \n" +
				"  <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> \n" +
				"  <meta name=\"format-detection\" content=\"date=no\"> \n" +
				"  <meta name=\"format-detection\" content=\"telephone=no\"> \n" +
				"  <title>CALEBIA</title>\n" +
				"  <link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\">\n" +
				"  <link rel=\"stylesheet\" type=\"text/css\" href=\"responsive.css\">\n" +
				"</head>\n" +
				"<body style=\"margin:0; padding:0;\" bgcolor=\"#F0F0F0\" leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\n" +
				"\n" +
				"\n" +
				"<table border=\"0\" width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"#F0F0F0\">\n" +
				"  <tr>\n" +
				"    <td align=\"center\" valign=\"top\" bgcolor=\"#F0F0F0\" style=\"background-color: #F0F0F0;\">\n" +
				"\n" +
				"      <br>\n" +
				"\n" +
				"      \n" +
				"      <table border=\"0\" width=\"600\" cellpadding=\"0\" cellspacing=\"0\" class=\"container\">\n" +
				"        <tr>\n" +
				"          <td class=\"container-padding header\" align=\"left\">\n" +
				"            Gracias, tu pedido ha sido colocado EXITOSAMENTE!\n" +
				"          </td>\n" +
				"        </tr>\n" +
				"        <tr>\n" +
				"          <td class=\"container-padding content\" align=\"left\">\n" +
				"            <br>\n" +
				"\n" +
				"<div class=\"title\">Pedido con CALEBIA</div>\n" +
				"<br>\n" +
				"\n" +
				"<div class=\"body-text\">\n" +

					"Nombre : "+formAux.getFirstName()+" "+formAux.getLastName()+" <br>\n" +
					"Email : "+formAux.getEmail()+" <br>\n" +
					"Direccion 1: "+ formAux.getDirection1() +" <br>\n" +
					"Direccion 2: "+ formAux.getDirection2()+" <br>\n" +
					"País: "+ formAux.getCountry()+" <br>\n" +
					"Estado: "+ formAux.getState1()+" <br>\n" +
					"Codigo Postal: "+ formAux.getPostalCode()+" <br>\n" +
					"Día de entrega: "+ formAux.getShippingDay()+" <br>\n" +
					"Horario de entrega: "+ formAux.getShippingTime()+" <br>\n" +

				"  <br><br>\n" +
				"\n" +
				"  The media query change we make is to decrease the content margin from 24px to 12px for devices up to max width of 400px.\n" +
				"  <br><br>\n" +
				"</div>\n" +
				"<div>\n" +
				"	<img class=\"img-EmailSign\" src=\"https://firebasestorage.googleapis.com/v0/b/boomapp-84476.appspot.com/o/FirmaMail.jpg?alt=media&token=84cfdb4b-3d19-4809-8569-fbd9c8315252\"" +
                "    width=\"400\" height=\"200\">\n" +
				"</div>\n" +
				"\n" +
				"          </td>\n" +
				"        </tr>\n" +
				"        <tr>\n" +
				"          <td class=\"container-padding footer-text\" align=\"left\">\n" +
				"            <br><br>\n" +
				"            &copy; 2017 Calebia\n" +
				"            <br><br>\n" +
				"\n" +
				"            You are receiving this email because you opted in on our website. Update your <a href=\"#\">email preferences</a> or <a href=\"#\">unsubscribe</a>.\n" +
				"            <br><br>\n" +
				"\n" +
				"            <strong>CALEBIA</strong><br>\n" +
				"            <span class=\"ios-footer\">\n" +
				"              Calle San Javier<br>\n" +
				"              Guadalajara, JAL<br>\n" +
				"            </span>\n" +
				"            <a href=\"http://www.calebia.com\">www.calebia.com</a><br>\n" +
				"\n" +
				"            <br><br>\n" +
				"\n" +
				"          </td>\n" +
				"        </tr>\n" +
				"      </table>\n" +
				"\n" +
				"\n" +
				"    </td>\n" +
				"  </tr>\n" +
				"</table>\n" +
				"\n" +
				"</body>\n" +
				"</html>";


		smtpMailSender.send("mmf.apps@gmail.com", "Prueba Pedido NUEVO", SendString);


//		smtpMailSender.send(formAux.getEmail(), "Prueba Pedido NUEVO", SendString);

//		System.out.println(formAux.getFirstName());
//		System.out.println("Hola CALEBIA soy "+ formAux.getFirstName()+formAux.getLastName()+"\n"+
//				formAux.getEmail()+"\n"+"Direccion 1: "+formAux.getDirection1()+"\n Direccion 2: "+ formAux.getDirection2()+
//				"\n País: "+ formAux.getCountry()+"\n Estado: "+ formAux.getState1()+ "\n Codigo Postal: "+ formAux.getPostalCode()+
//				"\n Día de entrega: "+ formAux.getShippingDay()+"\n Horario de entrega: "+ formAux.getShippingTime());

		
	}
	

}
