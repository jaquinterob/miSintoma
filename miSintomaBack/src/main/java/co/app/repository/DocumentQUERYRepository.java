package co.app.repository;


import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.app.entity.Document;

@RepositoryRestResource(collectionResourceRel = "documents", path = "documents")
public interface DocumentQUERYRepository extends PagingAndSortingRepository<Document, Long>{
	List<Document> findByNumeroDocumento(@Param("NumeroDocumento")String NumeroDocumento);

}