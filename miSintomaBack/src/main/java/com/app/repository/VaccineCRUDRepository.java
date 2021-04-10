package com.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.app.entity.CovidVaccine;

@Repository
@RepositoryRestResource(collectionResourceRel= "vaccine", path = "vaccine")
public interface VaccineCRUDRepository extends CrudRepository<CovidVaccine, Long>{

}
