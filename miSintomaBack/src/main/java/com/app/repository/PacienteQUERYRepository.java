package com.app.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.app.entity.Paciente;

@RepositoryRestResource(collectionResourceRel = "pacientes", path = "pacientes")
public interface PacienteQUERYRepository extends PagingAndSortingRepository<Paciente, Long>{
	List<Paciente> findByDocumento(@Param("documento") long documento);

}
