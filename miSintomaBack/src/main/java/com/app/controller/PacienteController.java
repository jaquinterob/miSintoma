package com.app.controller;

import java.net.URI;
import java.util.ArrayList;

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

import com.app.entity.Paciente;
import com.app.repository.PacienteCRUDRepository;
import com.app.repository.PacienteQUERYRepository;




@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path="/api/pacientesCustomAPI")
public class PacienteController 
{
	@Autowired
    private PacienteCRUDRepository pacienteRepository;
	private PacienteQUERYRepository pacienteRepositoryQuery;

	@GetMapping(path = "/getAllPacientes")
	public @ResponseBody Iterable<Paciente> getAllPacientes() {
		return pacienteRepository.findAll();
	}
	
	@PostMapping(path= "/addPaciente", consumes = "application/json", produces = "application/json")
	public Paciente addNewPacienteApi(@RequestBody Paciente paciente) {
        //add resource

     	paciente = pacienteRepository.save(paciente);
     	System.out.println(paciente);
		return paciente;
	}	
	
	@PostMapping(path= "/updatePaciente", consumes = "application/json", produces = "application/json")
	public Paciente savePacienteApi(@RequestBody Paciente paciente) {
        //add resource
     	pacienteRepository.save(paciente);
		return paciente;
	}
	
	@PostMapping(path = "/removePaciente", consumes = "application/json")
	public @ResponseBody ResponseEntity<String> deletePacienteApi(@RequestBody Paciente paciente) {
		pacienteRepository.deleteById(paciente.getId());
		return new ResponseEntity<String>(HttpStatus.OK);
	}
    
}

