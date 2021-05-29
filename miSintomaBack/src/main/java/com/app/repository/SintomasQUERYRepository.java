package com.app.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.app.entity.Sintoma;

@RepositoryRestResource(collectionResourceRel = "Sintomas", path = "Sintomas")
public interface SintomasQUERYRepository extends PagingAndSortingRepository<Sintoma, Long>{
	List<Sintoma> findByNamesintoma(@Param("name") String name);

}
