package com.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.app.controller.EmployeeController;
import com.app.entity.Employee;
import com.app.entity.Employees;
import com.app.repository.EmployeeCRUDRepository;

@ExtendWith(MockitoExtension.class)
public class EmployeeControllerUnitTests 
{ 
	@InjectMocks
	EmployeeController employeeController;
	
	@Mock
	EmployeeCRUDRepository employeeRepository;
	
	@Test
	public void testAddEmployee() 
	{

		// Given Algun Contexto de Variables
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		Employee employee = new Employee();
		employee.setId((long) 1);

		// When alguna Accion Requerida Entonces.... 
		when(  //Insertando un empleado
				employeeRepository.save(any(Employee.class))).thenReturn(employee
						
						);
		
		// Entonces Realizo la prueba si es verdadera
		Employee employeeToAdd = new Employee("Lokesh", "Gupta", "howtodoinjava@gmail.com");
		ResponseEntity<Object> responseEntity = employeeController.addEmployee(employeeToAdd);
		
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
		assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
	
	
	}
	
	@Test
	public void testFindAll() 
	{
		// given
		Employee employee1 = new Employee("Lokesh", "Gupta", "howtodoinjava@gmail.com");
		Employee employee2 = new Employee("Alex", "Gussin", "example@gmail.com");
		List<Employee> list = new ArrayList<Employee>();
		list.addAll(Arrays.asList(employee1, employee2));

		when(employeeRepository.findAll()).thenReturn(list);

		// when
		Employees result = employeeController.getEmployees();

		// then
		assertThat(result.getEmployeeList().size()).isEqualTo(2);
		
		assertThat(result.getEmployeeList().get(0).getFirstName())
						.isEqualTo(employee1.getFirstName());
		
		assertThat(result.getEmployeeList().get(1).getFirstName())
						.isEqualTo(employee2.getFirstName());
	}
}
