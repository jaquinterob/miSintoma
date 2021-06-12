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

import com.app.entity.Sintoma;
import com.app.entity.Sintomas;
import com.app.repository.SintomasCRUDRepository;
import com.app.repository.SintomasQUERYRepository;



@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path="/api/sintomasCustomAPI")
public class SintomasController 
{
	@Autowired
    private SintomasCRUDRepository sintomaRepository;
	@Autowired
	private SintomasQUERYRepository sintomaRepositoryQuery;

    //***Api Final Front
	@CrossOrigin(origins = "*")
    @PostMapping(path= "/addsintoma", consumes = "application/json", produces = "application/json")
	public Sintoma addNewSintomaApi(@RequestBody Sintoma sintoma) {
        //add resource
     	sintoma = sintomaRepository.save(sintoma);
		return sintoma;
	}
    
    //***Api Final Para FRONT
    @GetMapping(path= "/sintomagetall", produces = "application/json")
    public Sintomas getAllSintomasApi() 
    {
		Sintomas response = new Sintomas();
		ArrayList<Sintoma> list = new ArrayList<>();
		sintomaRepository.findAll().forEach(e -> list.add(e));
		response.setSintomasList(list);
        return response;
    }
       
    //***Api Final Front
    @CrossOrigin(origins = "*")
    @PostMapping(path= "/updatesintoma", consumes = "application/json", produces = "application/json")
	public Sintoma saveSintomaApi(@RequestBody Sintoma sintoma) {
        //add resource
     	sintomaRepository.save(sintoma);
		return sintoma;
	}
    //***Api Final Front
    @CrossOrigin(origins = "*")
	@PostMapping(path = "/sintomaremove", consumes = "application/json")
	public @ResponseBody ResponseEntity<String> deleteSintomaApi(@RequestBody Sintoma sintoma) {
		sintomaRepository.deleteById(sintoma.getId());
		return new ResponseEntity<String>(HttpStatus.OK);
	}
 
	/* Otras Formas  pero Bajo jUnit Testing*/
	@GetMapping(path="/sintomas", produces = "application/json")
    public Sintomas getSintomas() 
    {
		Sintomas response = new Sintomas();
		ArrayList<Sintoma> list = new ArrayList<>();
		sintomaRepository.findAll().forEach(e -> list.add(e));
		response.setSintomasList(list);
        return response;
    }
    
    @PostMapping(path= "/sintomas", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addSintoma(@RequestBody Sintoma sintoma) {       
                
        //add resource
    	sintoma = sintomaRepository.save(sintoma);
        
        //Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(sintoma.getId())
                                    .toUri();

        //Send location in response
        return ResponseEntity.created(location).build();
    }
//   
    
    
	/* Otras Formas  pero sin jUnit Testing*/   

	/*@GetMapping(path = "/getallsintoma")
	public @ResponseBody Iterator<Sintoma> getAllSintoma() {
		return sintomaRepository.findAll().iterator();
	}*/

	@GetMapping(path = "/addsintoma")
	public @ResponseBody String addNewSintoma(@RequestParam String ls_namesintoma, @RequestParam String ls_descripcion) {
		Sintoma sintoma = new Sintoma(ls_namesintoma, ls_descripcion);		
		sintomaRepository.save(sintoma);
		return "Saved";
	}

	@PostMapping(path = "/updatesintoma")
	public @ResponseBody ResponseEntity<String> updateNewSintoma(@RequestBody Sintoma sintoma) {
		sintomaRepository.save(sintoma);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	@PostMapping(path = "/removesintoma")
	public @ResponseBody ResponseEntity<String> removeSintoma(@RequestBody Sintoma sintoma) {
		sintomaRepository.delete(sintoma);
		return new ResponseEntity<String>(HttpStatus.OK);
	}

	 @GetMapping(path = "/getsintomabyname")
	public @ResponseBody Iterable<Sintoma> getByName(@RequestParam String namesintoma) {
		return sintomaRepositoryQuery.findByNamesintoma(namesintoma);
	}

	/*@GetMapping(path = "/findBynamesintomacontaining")
	public @ResponseBody Iterable<Sintoma> findByNamesintomaContaining(@RequestParam String namesintoma) {
		return sintomaRepositoryQuery.findByNamesintomaContaining(namesintoma);

	} */
    
}
