package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(classes = DemoAemApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
class DemoAemApplicationTests {
	
	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
		
		String URL = "http://localhost:" + port + "/greeting?name=Antonia";
		
		String restRequest = this.restTemplate.getForObject(URL, Greeting.class).getContent();
		
		assertTrue(restRequest.equals("Hello, Antonia!"));
	}

}
