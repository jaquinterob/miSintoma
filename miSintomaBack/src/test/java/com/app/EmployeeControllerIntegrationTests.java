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

import com.app.entity.Employee;
import com.app.entity.Employees;


@SpringBootTest(classes = MiSintomaBackApplication.class, 
		webEnvironment = WebEnvironment.RANDOM_PORT)
public class EmployeeControllerIntegrationTests 
{
	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Sql({ "classpath:schema.sql", "classpath:data.sql" })
	@Test
	public void testAllEmployees() 
	{
				
		assertTrue(
				this.restTemplate
					.getForObject("http://localhost:" + port + "/api/employeeCustomAPI/employees", Employees.class)
					.getEmployeeList().size() == 1);
	}

	@Test
	public void testAddEmployee() 
	{
		Employee employee = new Employee("Lokesh", "Gupta", "abc@gmail.com");
		
		ResponseEntity<String> responseEntity = this.restTemplate
			.postForEntity("http://localhost:" + port + "/api/employeeCustomAPI/employees", employee, String.class);

		assertEquals(201, responseEntity.getStatusCodeValue());
	}

}
