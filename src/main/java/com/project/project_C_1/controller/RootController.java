package com.project.project_C_1.controller;

import com.google.gson.Gson;
import com.project.project_C_1.entity.Food;
import com.project.project_C_1.entity.Form;
import com.project.project_C_1.service.SmtpMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.naming.Name;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

@RestController
public class RootController {
	
	@Autowired
	private SmtpMailSender smtpMailSender;

//	@Autowired
//	FormDao formDao;

//	@RequestMapping(value = "/send-mail", method = RequestMethod.POST)
	@PostMapping("/send-mail")
	public void sendMail (@RequestBody String prueba_aux) throws MessagingException, GeneralSecurityException, IOException {
		Gson gson = new Gson();
//		ArrayList<Form> yourArray = gson.fromJson(prueba_aux, new TypeToken<List<Form>>(){}.getType());
		Form formAux = new Form();
		formAux = gson.fromJson(prueba_aux,Form.class);

		Food foodAux1 = new Food();
		foodAux1 = gson.fromJson(prueba_aux, Food.class);
		String SFood = " ";
//        SFood += foodAux1.getFood0().equals('0') ? " " : foodAux1.getFood0();
//        SFood += foodAux1.getFood1().equals('0') ? " " : foodAux1.getFood1();
//        SFood += foodAux1.getFood2().equals(0) ? " " : foodAux1.getFood2();

        System.out.println(SFood);
        //**Get the names of each food
        foodController foodaux = new foodController();
        List<List<Object>> data = foodaux.getData("Sheet1!A2:A");
//        int size_aux = data.size();
////        List[] NamesArr = new List[size_aux];
        if(foodAux1.getFood0().equals("0") == false){
            SFood += data.get(0).get(0) + ": " + foodAux1.getFood0()+" <br>\n" ;
        }
        if(foodAux1.getFood1().equals("0") == false){
            SFood += data.get(1).get(0) + ": " + foodAux1.getFood1()+" <br>\n" ;
        }
        if(foodAux1.getFood2().equals("0") == false){
            SFood += data.get(2).get(0) + ": " + foodAux1.getFood2()+" <br>\n" ;
        }
        if(foodAux1.getFood3().equals("0") == false | foodAux1.getFood3().equals(" ") == false){
            SFood += data.get(3).get(0) + ": " + foodAux1.getFood3()+" <br>\n" ;
        }
        if(foodAux1.getFood4().equals("0") == false){
            SFood += data.get(4).get(0) + ": " + foodAux1.getFood4()+" <br>\n" ;
        }
        if(foodAux1.getFood5().equals("0") == false){
            SFood += data.get(5).get(0) + ": " + foodAux1.getFood5()+" <br>\n" ;
        }
        if(foodAux1.getFood6().equals("0") == false){
            SFood += data.get(6).get(0) + ": " + foodAux1.getFood6()+" <br>\n" ;
        }
        if(foodAux1.getFood7().equals("0") == false){
            SFood += data.get(7).get(0) + ": " + foodAux1.getFood7()+" <br>\n" ;
        }
        if(foodAux1.getFood8().equals("0") == false){
            SFood += data.get(8).get(0) + ": " + foodAux1.getFood8()+" <br>\n" ;
        }
//        if(foodAux1.getFood9().equals("0") == false){
//            SFood += data.get(9).get(0) + ": " + foodAux1.getFood9()+" <br>\n" ;
//        }
//
////        System.out.println(SFood);
////        String[] Names = new String[size_aux];
////        for (int i=0; i<= size_aux-1; i++){
////            NamesArr[i] = Collections.singletonList(data.get(i));
//////            System.out.println(NamesArr[i]);
////        }
//
//        List<List<Object>> data1 = foodaux.getData("Sheet1!D2:D");
////        int size_aux1 = data1.size();
////        List[] NamesArr1 = new List[size_aux1];
////        String[] Names = new String[size_aux];
////        for (int i=0; i<= size_aux1-1; i++){
////            NamesArr1[i] = Collections.singletonList(data1.get(i) );
//////            System.out.println(NamesArr1[i]);
////        }
//        if(foodAux1.getFood10().equals("0") == false){
//            SFood += data1.get(0).get(0) + ": " + foodAux1.getFood10()+" <br>\n" ;
//        }
//        if(foodAux1.getFood11().equals("0") == false){
//            SFood += data1.get(1).get(0) + ": " + foodAux1.getFood11()+" <br>\n" ;
//        }
//        if(foodAux1.getFood12().equals("0") == false){
//            SFood += data1.get(2).get(0) + ": " + foodAux1.getFood12()+" <br>\n" ;
//        }
//        if(foodAux1.getFood13().equals("0") == false){
//            SFood += data1.get(3).get(0) + ": " + foodAux1.getFood13()+" <br>\n" ;
//        }
//        if(foodAux1.getFood14().equals("0") == false){
//            SFood += data1.get(4).get(0) + ": " + foodAux1.getFood14()+" <br>\n" ;
//        }
//        if(foodAux1.getFood15().equals("0") == false){
//            SFood += data1.get(5).get(0) + ": " + foodAux1.getFood15()+" <br>\n" ;
//        }
//        if(foodAux1.getFood16().equals("0") == false){
//            SFood += data1.get(6).get(0) + ": " + foodAux1.getFood16()+" <br>\n" ;
//        }
//        if(foodAux1.getFood17().equals("0") == false){
//            SFood += data1.get(7).get(0) + ": " + foodAux1.getFood17()+" <br>\n" ;
//        }

        System.out.println(foodAux1.getFood3());






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
				"<body style=\"margin:0; padding:0; -ms-text-size-adjust: 100%;\n" +
                "  -webkit-text-size-adjust: 100%;\" bgcolor=\"#F0F0F0\" leftmargin=\"0\" topmargin=\"0\" marginwidth=\"0\" marginheight=\"0\">\n" +
				"\n" +
				"\n" +
				"<table style=\"border-spacing: 0;\" border=\"0\" width=\"100%\" height=\"100%\" cellpadding=\"0\" cellspacing=\"0\" bgcolor=\"#F0F0F0\">\n" +
				"  <tr>\n" +
				"    <td align=\"center\" valign=\"top\" bgcolor=\"#F0F0F0\" style=\"background-color: #F0F0F0; border-collapse: collapse;\">\n" +
				"\n" +
				"      <br>\n" +
				"\n" +
				"      \n" +
				"      <table style=\"width: 600px;\n" +
                "  max-width: 600px;\" border=\"0\" width=\"600\" cellpadding=\"0\" cellspacing=\"0\" class=\"container\">\n" +
				"        <tr>\n" +
				"          <td class=\"container-padding header\" align=\"left\" style=\"font-size: 24px;\n" +
                "  font-weight: bold;\n" +
                "  padding-bottom: 12px;\n" +
                "  color: #38bd38; font-family: Helvetica, Arial, sans-serif;\">\n" +
				"            Gracias, tu pedido ha sido colocado EXITOSAMENTE!\n" +
				"          </td>\n" +
				"        </tr>\n" +
				"        <tr>\n" +
				"          <td style=\"padding-top: 12px;\n" +
                "\n" +
                "padding-bottom: 12px; padding-left: 20px; padding-left: 20px;\n" +
                "\n" +
                "background-color: #ffffff;\" class=\"container-padding content\" align=\"left\">\n" +
				"            <br>\n" +
				"\n" +
				"<div style=\"font-family: Helvetica, Arial, sans-serif;\" class=\"title\">Pedido con CALEBIA</div>\n" +
				"<br>\n" +
				"\n" +
				"<div class=\"body-text\">\n" +

					"Nombre : "+formAux.getFirstName()+" "+formAux.getLastName()+" <br>\n" +
					"Email : "+formAux.getEmail()+" <br>\n" +
                    "Teléfono : "+formAux.getPhone1()+" <br>\n"+
					"Direccion 1: "+ formAux.getDirection1() +" <br>\n" +
					"Direccion 2: "+ formAux.getDirection2()+" <br>\n" +
					"País: "+ formAux.getCountry()+" <br>\n" +
					"Estado: "+ formAux.getState1()+" <br>\n" +
					"Codigo Postal: "+ formAux.getPostalCode()+" <br>\n" +
					"Día de entrega: "+ formAux.getShippingDay()+" <br>\n" +
					"Horario de entrega: "+ formAux.getShippingTime()+" <br>\n" +

				"  <br><br>\n" +
				"\n" +
				SFood +
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
				"          <td style=\"font-family: Helvetica, Arial, sans-serif; font-size: 12px;\n" +
                "  line-height: 16px;\n" +
                "  color: #aaaaaa; \"" +
                "class=\"container-padding footer-text\" align=\"left\">\n" +
				"            <br><br>\n" +
				"            &copy; 2017 Calebia\n" +
				"            <br><br>\n" +
				"\n" +
				"            You are receiving this email because you opted in on our website. Update your <a href=\"contacto@calebia.com\">email preferences</a> or <a href=\"#\">unsubscribe</a>.\n" +
				"            <br><br>\n" +
				"\n" +
				"            <strong style=\"font-size: 15px; color: #DC3545;\">CALEBIA</strong><br>\n" +
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


		smtpMailSender.send(formAux.getEmail(), "Prueba Pedido NUEVO", SendString);

		//System.out.println(data.size());


		
	}
	

}
