package com.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.app.entity.Paciente;

@Repository
@RepositoryRestResource(collectionResourceRel = "pacientes", path = "pacientes")
public interface PacienteCRUDRepository extends CrudRepository<Paciente, Long>{
	

}