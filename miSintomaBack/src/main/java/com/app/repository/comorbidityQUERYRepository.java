package com.app.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.app.entity.CovidVaccine;
import com.app.entity.comorbidity;

@RepositoryRestResource(collectionResourceRel = "comorbidity", path = "comorbidity")
public interface comorbidityQUERYRepository extends PagingAndSortingRepository<comorbidity, Long>{
	List<comorbidity> findByName(@Param("name") String name);
}
