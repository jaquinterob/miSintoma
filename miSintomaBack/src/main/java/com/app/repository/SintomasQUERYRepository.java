package com.app.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.app.entity.Sintomas;

@RepositoryRestResource(collectionResourceRel = "Sintomas", path = "Sintomas")
public interface SintomasQUERYRepository extends PagingAndSortingRepository<Sintomas, Long>{
	List<Sintomas> findByNamesintoma(@Param("name") String name);

}
