package com.app.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.app.entity.comorbidity;
import com.app.entity.comorbidities;
import com.app.repository.comorbidityCRUDRepository;
import com.app.repository.comorbidityQUERYRepository;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path="/api/comorbidityCustomAPI")
public class ComorbidityController {
	@Autowired
	private comorbidityCRUDRepository comorbidityRepository;
	private comorbidityQUERYRepository comorbidityRepositoryQuery;
	
	//
	/*Bajo jUnit Testing*/
	@GetMapping(path="/comorbidity", produces = "application/json")
	public comorbidities getVaccineList(){
		comorbidities response = new comorbidities();
		ArrayList<comorbidity> list  = new ArrayList<>();
		comorbidityRepository.findAll().forEach(e -> list.add(e));
		response.setComorbidityList(list);
		return response;
	}
	
	@PostMapping(path = "/comorbidity", consumes = "application/json", produces="application/json")
	public ResponseEntity<Object> addComorbidity(@RequestBody comorbidity comorbidity){
		//add resource
		comorbidity = comorbidityRepository.save(comorbidity);
		
		//location resource
		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(comorbidity.getId()).toUri();
		
		//send location 
		return ResponseEntity.created(location).build();
	}
	
	//sin jUnit Testing 
	
	@GetMapping(path= "/getallcomorbidities")
	public @ResponseBody Iterator<comorbidity> getAllComorbidities(){
		return comorbidityRepository.findAll().iterator();
	}
	
	@GetMapping(path="/addcomorbidity")
	public @ResponseBody String addNewCovidVaccine(@RequestParam String ls_name, 
			@RequestParam String ls_type ) {
		comorbidity comorbidity = new comorbidity(ls_name, ls_type);
		comorbidityRepository.save(comorbidity);
		return "Saved";
	}
	
	@PostMapping(path= "/updatecomorbidity")
	public @ResponseBody ResponseEntity<String> updateNewComorbidity(@RequestBody comorbidity comorbidity){
		comorbidityRepository.save(comorbidity);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PostMapping(path = "/removecomorbidity")
	public @ResponseBody ResponseEntity<String> removeVaccine(@RequestBody comorbidity comorbidity){
		comorbidityRepository.delete(comorbidity);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@GetMapping(path="/getcomorbiditybyname")
	public @ResponseBody Iterable<comorbidity> getByNameVaccine(@RequestParam String name){
		return comorbidityRepositoryQuery.findByName(name);
	}
	
	@GetMapping(path = "/findBycomorbiditynamecontaining")
	public @ResponseBody Iterable<comorbidity> findByNameContaining(@RequestParam String name){
		return comorbidityRepositoryQuery.findByName(name);
	}
	
	//Api Final Front 
	
	@PostMapping(path="/addvaccine", consumes = "application/json", produces="aplication/json")
	public comorbidity addNewcomorbidityineApi(@RequestBody comorbidity comorbidity) {
		//add resource
		comorbidity= comorbidityRepository.save(comorbidity);
		return comorbidity;
	}
	
	@GetMapping(path= "/comorbiditygetall", produces="application/json")
	public comorbidities getAllcomorbiditiesApi() {
		comorbidities response = new comorbidities();
		ArrayList<comorbidity> list =new ArrayList<>();
		comorbidityRepository.findAll().forEach(e -> list.add(e));
		response.setComorbidityList(list);
		return response;
	}
	
	@PostMapping(path= "/updatecomorbidity", consumes = "application/json", produces = "application/json")
	public comorbidity updateCovidVaccineApi(@RequestBody comorbidity comorbidity) {
	    //add resource
	 	comorbidityRepository.save(comorbidity);
		return comorbidity;
	}
	  
	@PostMapping(path = "/comorbidityremove", consumes = "application/json")
	public @ResponseBody ResponseEntity<String> deleteCovidVaccineApi(@RequestBody comorbidity comorbidity) {
		comorbidityRepository.deleteById(comorbidity.getId());
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
