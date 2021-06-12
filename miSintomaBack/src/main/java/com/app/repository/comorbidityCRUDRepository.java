package com.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.app.entity.comorbidity;

@Repository
@RepositoryRestResource(collectionResourceRel= "comorbidity", path = "comorbidity")
public interface comorbidityCRUDRepository extends CrudRepository<comorbidity, Long> {

}
