package com.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Iterator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.app.controller.VaccineController;
import com.app.entity.CovidVaccine;
import com.app.entity.Vaccine;
import com.app.repository.VaccineCRUDRepository;

@ExtendWith(MockitoExtension.class)
public class VaccineControllerUnitTest {

	//instancias que permite llamar nuestros controladores y hacer simulacion de la prueba 
	@InjectMocks
	VaccineController vaccineController;
	
	@Mock
	VaccineCRUDRepository vaccineRepository;
	
	@Test
	public void testAddCovidVaccine() 
	{
		// Given Algun Contexto de Variables
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		CovidVaccine vaccine = new CovidVaccine();
		vaccine.setId((long) 1);

		// When alguna Accion Requerida Entonces.... 
		// inserta una vacuna 
		when(vaccineRepository.save(any(CovidVaccine.class))).thenReturn(vaccine);
		
		// Entonces Realizo la prueba si es verdadera
		CovidVaccine vaccineToAdd = new CovidVaccine("covid(1)", "covid", "020322", "jassen", "clinical(1)", "lote");
		ResponseEntity<Object> responseEntity = vaccineController.addCovidVaccine(vaccineToAdd);
		
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
		assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
	}
	
	@Test
	public void testFindAll() 
	{
		// Given
		CovidVaccine vaccine1 = new CovidVaccine("covid(2)", "covid", "020322", "jassen", "clinical(2)", "lote");
		CovidVaccine vaccine2 = new CovidVaccine("covid(3)", "covid", "020322", "jassen", "clinical(3)", "lote");
		List<CovidVaccine> list = new ArrayList<CovidVaccine>();
		list.addAll(Arrays.asList(vaccine1, vaccine2));

		when(vaccineRepository.findAll()).thenReturn(list);

		// When
		Vaccine result = vaccineController.getVaccineList();

		// Then
		assertThat(result.getVaccineList().size()).isEqualTo(2);
		
		assertThat(result.getVaccineList().get(0).getNameVaccine())
						.isEqualTo(vaccine1.getNameVaccine());
		
		assertThat(result.getVaccineList().get(1).getNameVaccine())
						.isEqualTo(vaccine2.getNameVaccine());
	}
	
	@Test
	public void updateCovidVaccineApiTest() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		CovidVaccine vaccine = new CovidVaccine(); 
		vaccine.setId((long)0);
		
		when(vaccineRepository.save(any(CovidVaccine.class))).thenReturn(vaccine);
		
		CovidVaccine vaccineToAdd = new CovidVaccine("covid(2)", "covid", "020322", "jassen", "clinical(2)", "lote");
		CovidVaccine response = new CovidVaccine();
		response = vaccineController.addNewCovidVaccineApi(vaccineToAdd);
		
		CovidVaccine vaccineToUpdate = new CovidVaccine("covid(2)", "covid", "020322", "jassen", "clinical(2)", "lote");
		CovidVaccine responseUpdate = new CovidVaccine();
		responseUpdate = vaccineController.updateCovidVaccineApi(vaccineToUpdate);
		
		assertThat(responseUpdate.equals(vaccineToUpdate));
		
	}

	@Test
	public void deleteCovidVaccineApiTest() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		CovidVaccine vaccine = new CovidVaccine(); 
		vaccine.setId((long)0);
		
		when(vaccineRepository.save(any(CovidVaccine.class))).thenReturn(vaccine);
		
		CovidVaccine vaccineToAdd = new CovidVaccine("covid(2)", "covid", "020322", "jassen", "clinical(2)", "lote");
		CovidVaccine response = new CovidVaccine();
		response = vaccineController.addNewCovidVaccineApi(vaccineToAdd);
		
		ResponseEntity<String> responseRemove = vaccineController.deleteCovidVaccineApi(vaccineToAdd);
		
		assertThat(responseRemove.equals(HttpStatus.OK));
	}

}
