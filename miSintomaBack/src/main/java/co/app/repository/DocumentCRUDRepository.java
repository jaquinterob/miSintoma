package co.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.app.entity.Document;

@Repository
@RepositoryRestResource(collectionResourceRel = "documents", path = "documents")
public interface DocumentCRUDRepository extends CrudRepository<Document, Long>{
	

}