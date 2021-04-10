package com.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.app.entity.Sintomas;

@Repository
@RepositoryRestResource(collectionResourceRel = "Sintomas", path = "Sintomas")
public interface SintomasCRUDRepository extends CrudRepository<Sintomas, Long>{
	

}