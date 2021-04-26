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

import com.app.controller.PacienteController;
import com.app.entity.Paciente;
import com.app.entity.Pacientes;
import com.app.repository.PacienteCRUDRepository;

@ExtendWith(MockitoExtension.class)
public class PacienteControllerUnitTests 
{ 
	@InjectMocks
	PacienteController pacienteController;
	
	@Mock
	PacienteCRUDRepository pacienteRepository;
	
	@Test
	public void testAddPaciente() 
	{

		// Given Algun Contexto de Variables
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		//Paciente paciente = new Paciente((long) 100 ,8058270, "John Alexander Quintero", "M", 35,"2335026","3155246522","Envigado");
		Paciente paciente = new Paciente();
		paciente.setId((long)10);
		paciente.setDocumento(8058270);
		paciente.setNombre("John Alexander Quintero");
		paciente.setSexo("M");
		paciente.setEdad(35);
		paciente.setTelefono("2335026");
		paciente.setCelular("3155246522");
		paciente.setDireccion("Envigado");

		// When alguna Accion Requerida Entonces.... 
		when(  //Insertando un empleado
				pacienteRepository.save(any(Paciente.class))).thenReturn(paciente
						
						);
		
		// Entonces Realizo la prueba si es verdadera
		Paciente pacienteToAdd = new Paciente((long) 10 ,8058270, "John Alexander Quintero", "M", 35,"2335026","3155246522","Envigado");
		Paciente responseEntity = pacienteController.addNewPacienteApi(pacienteToAdd);
		
		assertThat(responseEntity.getDocumento()).isEqualTo(8058270);
		assertThat(responseEntity.getId()).isEqualTo(10);
		assertThat(responseEntity.getNombre()).isEqualTo("John Alexander Quintero");
		assertThat(responseEntity.getSexo()).isEqualTo("M");
		assertThat(responseEntity.getEdad()).isEqualTo(35);
		assertThat(responseEntity.getTelefono()).isEqualTo("2335026");
		assertThat(responseEntity.getCelular()).isEqualTo("3155246522");
		assertThat(responseEntity.getDireccion()).isEqualTo("Envigado");
	
	
	}
	
	@Test
	public void testFindAll() 
	{
		
		// given
		Paciente paciente1 = new Paciente( (long) 11 ,234345, "Carlos Pérez", "M", 25,"4554454","45454545","Sabaneta");
		Paciente paciente2 = new Paciente( (long) 12 ,567678, "Pacho Castaño", "M", 55,"474747","47474747","La Estrella");
		

		paciente1 = pacienteController.addNewPacienteApi(paciente1);
		paciente2 = pacienteController.addNewPacienteApi(paciente2);
		
		System.out.println("++++++++++"+paciente1);
		System.out.println(paciente2);


		// when
		List<Paciente> result = (List<Paciente>) pacienteController.getAllPacientes();
		System.out.println(result.size());
		// then
		assertThat(result.size()).isEqualTo(0);
	}
	
	@Test
	public void testUpdatePaciente() 
	{
		
		
		// Entonces Realizo la prueba si es verdadera
		Paciente pacienteToAdd = new Paciente((long) 10 ,8058270, "John Alexander Quintero", "M", 35,"2335026","3155246522","Envigado");
		Paciente responseEntity = pacienteController.savePacienteApi(pacienteToAdd);
		System.out.println(responseEntity);
		assertThat(responseEntity.getDocumento()).isEqualTo(8058270);
		assertThat(responseEntity.getId()).isEqualTo(10);
		assertThat(responseEntity.getNombre()).isEqualTo("John Alexander Quintero");
		assertThat(responseEntity.getSexo()).isEqualTo("M");
		assertThat(responseEntity.getEdad()).isEqualTo(35);
		assertThat(responseEntity.getTelefono()).isEqualTo("2335026");
		assertThat(responseEntity.getCelular()).isEqualTo("3155246522");
		assertThat(responseEntity.getDireccion()).isEqualTo("Envigado");
	}
	
	@Test
	public void testRemovePaciente() 
	{
		
		
		// Entonces Realizo la prueba si es verdadera
		Paciente pacienteToAdd = new Paciente((long) 10 ,8058270, "John Alexander Quintero", "M", 35,"2335026","3155246522","Envigado");
		ResponseEntity<String> responseEntity = pacienteController.deletePacienteApi(pacienteToAdd);
		System.out.println(responseEntity.getHeaders());
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}
	
	
}
