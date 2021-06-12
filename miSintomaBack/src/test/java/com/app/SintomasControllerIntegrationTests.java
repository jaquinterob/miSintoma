package com.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import com.app.MiSintomaBackApplication;
import com.app.entity.Sintoma;
import com.app.entity.Sintomas;

@SpringBootTest(classes = MiSintomaBackApplication.class, 
		webEnvironment = WebEnvironment.RANDOM_PORT)
public class SintomasControllerIntegrationTests 
{
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Sql({ "classpath:schema.sql", "classpath:data.sql" })
	@Test
	public void testAllSintomas() 
	{
		
		assertTrue(
			this.restTemplate
				.getForObject("http://localhost:" + port + "/api/sintomaCustomAPI/sintomas", Sintomas.class)
				.getSintomasList().size() == 1);
	}

	@Test
	public void testAddSintoma() 
	{
		Sintoma sintoma = new Sintoma("Lokesh", "Gupta");
		
		ResponseEntity<String> responseEntity = this.restTemplate
			.postForEntity("http://localhost:" + port + "/sintomaAPI/sintomas", sintoma, String.class);

		assertEquals(201, responseEntity.getStatusCodeValue());
	}

}
