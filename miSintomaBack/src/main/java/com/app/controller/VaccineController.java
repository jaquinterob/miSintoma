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

import com.app.entity.CovidVaccine;
import com.app.entity.Vaccine;
import com.app.repository.VaccineCRUDRepository;
import com.app.repository.VaccineQUERYRepository;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path="/api/vaccineCustomAPI")
public class VaccineController {
	@Autowired
	private VaccineCRUDRepository vaccineRepository;
	private VaccineQUERYRepository vaccineRepositoryQuery;
	
	//
	/*Bajo jUnit Testing*/
	@GetMapping(path="/vaccine", produces = "application/json")
	public Vaccine getVaccineList(){
		Vaccine response = new Vaccine();
		ArrayList<CovidVaccine> list  = new ArrayList<>();
		vaccineRepository.findAll().forEach(e -> list.add(e));
		response.setVaccineList(list);
		return response;
	}
	
	@PostMapping(path = "/vaccine", consumes = "application/jason", produces="application/jason")
	public ResponseEntity<Object> addCovidVaccine(@RequestBody CovidVaccine vaccine){
		//add resource
		vaccine = vaccineRepository.save(vaccine);
		
		//location resource
		URI location= ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(vaccine.getId()).toUri();
		
		//send location 
		return ResponseEntity.created(location).build();
	}
	
	//sin jUnit Testing 
	
	@GetMapping(path= "/getallvaccine")
	public @ResponseBody Iterator<CovidVaccine> getAllVaccine(){
		return vaccineRepository.findAll().iterator();
	}
	
	@GetMapping(path="/addvaccine")
	public @ResponseBody String addNewCovidVaccine(@RequestParam String ls_nameVaccine, 
			@RequestParam String ls_components, @RequestParam String ls_laboratory, @RequestParam String ls_expirationDate,
			@RequestParam String ls_clinicalData, @RequestParam String ls_vaccineBatch ) {
		CovidVaccine vaccine = new CovidVaccine(ls_nameVaccine,ls_components,ls_laboratory,ls_expirationDate,ls_clinicalData, ls_vaccineBatch);
		vaccineRepository.save(vaccine);
		return "Saved";
	}
	
	@PostMapping(path= "/updatevaccine")
	public @ResponseBody ResponseEntity<String> updateNewVAccine(@RequestBody CovidVaccine vaccine){
		vaccineRepository.save(vaccine);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@PostMapping(path = "/removevaccine")
	public @ResponseBody ResponseEntity<String> removeVaccine(@RequestBody CovidVaccine vaccine){
		vaccineRepository.delete(vaccine);
		return new ResponseEntity<String>(HttpStatus.OK);
	}
	
	@GetMapping(path="/getvaccinebyname")
	public @ResponseBody Iterable<CovidVaccine> getByNameVaccine(@RequestParam String nameVaccine){
		return vaccineRepositoryQuery.findByNameVaccine(nameVaccine);
	}
	
	@GetMapping(path = "/findByvaccinenamecontaining")
	public @ResponseBody Iterable<CovidVaccine> findByNameContaining(@RequestParam String nameVaccine){
		return vaccineRepositoryQuery.findByNameVaccine(nameVaccine);
	}
	
	//Api Final Front 
	
	@PostMapping(path="/addvaccine", consumes = "application/jason", produces="aplication/json")
	public CovidVaccine addNewCovidVaccineApi(@RequestBody CovidVaccine vaccine) {
		//add resource
		vaccine= vaccineRepository.save(vaccine);
		return vaccine;
	}
	
	@GetMapping(path= "/vaccinegetall", produces="application/json")
	public Vaccine getAllCovidVaccineApi() {
		Vaccine response = new Vaccine();
		ArrayList<CovidVaccine> list =new ArrayList<>();
		vaccineRepository.findAll().forEach(e -> list.add(e));
		response.setVaccineList(list);
		return response;
	}
	
	@PostMapping(path= "/updatevaccine", consumes = "application/json", produces = "application/json")
	public CovidVaccine updateCovidVaccineApi(@RequestBody CovidVaccine vaccine) {
	    //add resource
	 	vaccineRepository.save(vaccine);
		return vaccine;
	}
	  
	@PostMapping(path = "/vaccineremove", consumes = "application/json")
	public @ResponseBody ResponseEntity<String> deleteCovidVaccineApi(@RequestBody CovidVaccine vaccine) {
		vaccineRepository.deleteById(vaccine.getId());
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
