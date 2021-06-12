package com.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import com.app.entity.CovidVaccine;
import com.app.entity.Vaccine;


@SpringBootTest(classes = MiSintomaBackApplication.class, 
		webEnvironment = WebEnvironment.RANDOM_PORT)
public class VaccineControllerIntegrationTests 
{
	/***
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Sql({ "classpath:schema.sql", "classpath:data.sql" })
	@Test
	public void testAllVaccine() 
	{
				
		assertTrue(
				this.restTemplate
					.getForObject("http://localhost:" + port + "/api/vaccineCustomAPI/vaccine", Vaccine.class)
					.getVaccineList().size() == 1);
	}

	@Test
	public void testAddVaccine() 
	{
		CovidVaccine vaccine = new CovidVaccine("covid", "covid", "020322", "jassen", "clinical(2)", "lote");
		
		ResponseEntity<String> responseEntity = this.restTemplate
			.postForEntity("http://localhost:" + port + "/api/vaccineCustomAPI/vaccine", vaccine, String.class);

		assertEquals(201, responseEntity.getStatusCodeValue());
	}
***/
}