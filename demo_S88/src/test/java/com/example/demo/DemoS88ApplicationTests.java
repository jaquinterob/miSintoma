package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(classes = DemoS88Application.class, 
webEnvironment = WebEnvironment.RANDOM_PORT)


class DemoS88ApplicationTests {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	public void testAllEmployees() 
	{
		//Escenario 1: Realizo el llamado a la URL
		 //GIVEN: Dado que el servicio puede ser llamado desde una URL enviando mi  nombre
		 String URL = "http://localhost:" + port + "/greeting?name=Susana";
		 //WHEN: Cuando invoco la URL 	
		 String restRequest = this.restTemplate.getForObject(URL, Greeting.class).getContent();
		 //THEN: El servicio responde el Saludo con mi nombre: Hello, Juan! 
	     assertTrue(restRequest.equals("Hello, Susana!"));		
	}

}
