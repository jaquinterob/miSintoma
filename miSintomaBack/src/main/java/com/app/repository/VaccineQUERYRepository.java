package com.app.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.app.entity.CovidVaccine;

@RepositoryRestResource(collectionResourceRel = "vaccine", path = "vaccine")
public interface VaccineQUERYRepository extends PagingAndSortingRepository<CovidVaccine, Long>{
	List<CovidVaccine> findByNameVaccine(@Param("nameVaccine") String nameVaccine);
}
