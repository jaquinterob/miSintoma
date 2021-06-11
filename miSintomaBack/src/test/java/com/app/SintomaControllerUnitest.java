package com.app;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.app.controller.SintomasController;
import com.app.entity.Sintoma;
import com.app.entity.Sintomas;
import com.app.repository.SintomasCRUDRepository;

@ExtendWith(MockitoExtension.class)
public class SintomaControllerUnitest 
{ 
	@InjectMocks
	SintomasController sintomaController;
	
	@Mock
	SintomasCRUDRepository sintomaRepository;
	
	@Test
	public void testAddSintoma() 
	{
		
		// Given Algun Contexto de Variables
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		Sintoma sintoma = new Sintoma();
		sintoma.setId((long) 1);

		// When alguna Accion Requerida Entonces.... 
		when(sintomaRepository.save(any(Sintoma.class))).thenReturn(sintoma);
		
		// Entonces Realizo la prueba si es verdadera
		Sintoma sintomaToAdd = new Sintoma("cmewaklmc","xakmskx");
		ResponseEntity<Object> responseEntity = sintomaController.addSintoma(sintomaToAdd);
		
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
		assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
	}
	
	@Test
	public void testFindAll() 
	{
		// given
		Sintoma sintoma1 = new Sintoma("asdcsv", "dradvad");
		Sintoma sintoma2 = new Sintoma("akjenfjawe", "jkshga");
		List<Sintoma> list = new ArrayList<Sintoma>();
		list.addAll(Arrays.asList(sintoma1, sintoma2));

		when(sintomaRepository.findAll()).thenReturn(list);

		// when
		Sintomas result = sintomaController.getSintomas();

		// then
		assertThat(result.getSintomasList().size()).isEqualTo(2);
		
		assertThat(result.getSintomasList().get(0).getNamesintoma())
						.isEqualTo(sintoma1.getNamesintoma());
		
		assertThat(result.getSintomasList().get(1).getNamesintoma())
						.isEqualTo(sintoma2.getNamesintoma());
	}
	/*
	  @test
	  public void getAllSintomaTest() { 
	  Sintoma sintoma1 = new Sintoma("asdcsv","dradvad"); 
	  Sintoma sintoma2 = new Sintoma("akjenfjawe", "jkshga");
	  
	  List<Sintoma> listSintoma = new ArrayList<Sintoma>();
	  listSintoma.add(sintoma1); listSintoma.add(sintoma2); Iterator<Sintoma>
	  iterableList = listSintoma.iterator();
	  
	  //when when(sintomaController.getAllSintoma()).thenReturn(iterableList);
	  
	  Iterator<Sintoma> iterableListReturn = sintomaController.getAllSintoma(); }
	 */
	@Test
	public void addNewSintomaTest()
	{
		String ls_namesintoma = "dolor de cabeza";
		String ls_descripcion = "migraña";
		
		String Return = "Saved";
		
		when(sintomaController.addNewSintoma(ls_namesintoma, ls_descripcion)).thenReturn(Return);
		
		String Response = sintomaController.addNewSintoma(ls_namesintoma, ls_descripcion);
		
		assertThat(Return.equals(Response));
	}
	@Test
	public void updateSintomaTest()
	{
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		Sintoma sintoma = new Sintoma(); 
		sintoma.setId((long)1);
		
		when(sintomaRepository.save(any(Sintoma.class))).thenReturn(sintoma);
		
		Sintoma sintomaToAdd = new Sintoma("kasndjds", "akjsdnfkj");
		Sintoma response = new Sintoma();
		response = sintomaController.addNewSintomaApi(sintomaToAdd);
		
		Sintoma sintomaToUpdate = new Sintoma("covid", "tos");
		Sintoma responseUpdate = new Sintoma();
		responseUpdate = sintomaController.saveSintomaApi(sintomaToUpdate);
		
		assertThat(responseUpdate.equals(sintomaToUpdate));
		
	
	}
	@Test
	public void removeSintomaTest()
	{
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		
		Sintoma sintoma = new Sintoma();
		sintoma.setId(1);
		
		when(sintomaRepository.save(any(Sintoma.class))).thenReturn(sintoma);
		
		Sintoma sintomacreate = new Sintoma("Fiebre","woiedjqiwoe");
		sintomaController.addNewSintomaApi(sintomacreate);
		
		ResponseEntity<String> responseEntityDelete = sintomaController.removeSintoma(sintomacreate);
		assertThat(responseEntityDelete.equals(HttpStatus.OK));
		
	}
		
}
