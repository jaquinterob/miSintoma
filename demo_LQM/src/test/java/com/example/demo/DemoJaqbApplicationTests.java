package com.example.demo;


import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = DemoJaqbApplication.class, 
webEnvironment = WebEnvironment.RANDOM_PORT)

class DemoJaqbApplicationTests {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	
	@Test
	public void testAllEmployees() 
	{
	//  (Escenario)	
	//  (Given) some context
	//	(When) some action is carried out
	//	(Then) a particular set of observable consequences should obtain
	
	/***	Un ejemplo:
	        Retiro de un Cajero
			Dado que mi cuenta bancaria tiene crédito y no hice retiros recientemente,
			Cuando intento retirar una cantidad menor que el límite de mi tarjeta,
			Entonces el retiro debe completarse sin errores ni advertencias.			
			// JBehave, RSpec o Cucumber	https://openwebinars.net/blog/que-es-gherkin/		 
	***/	
		
	//Escenario 1: Realizo el llamado a la URL
	 //GIVEN: Dado que el servicio puede ser llamado desde una URL enviando mi  nombre
	 String URL = "http://localhost:" + port + "/greeting?name=LuisQuimbayo";
	 //WHEN: Cuando invoco la URL 	
	 String restRequest = this.restTemplate.getForObject(URL, Greeting.class).getContent();
	 //THEN: El servicio responde el Saludo con mi nombre: Hello, Juan! 
     assertTrue(restRequest.equals("Hello, LuisQuimbayo!"));
   
     
	}

}
