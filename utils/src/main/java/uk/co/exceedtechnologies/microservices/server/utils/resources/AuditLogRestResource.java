package uk.co.exceedtechnologies.microservices.server.utils.resources;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import uk.co.exceedtechnologies.microservices.server.utils.model.AuditLog;

@RepositoryRestResource(collectionResourceRel = "auditlogs", path = "auditlog")
public interface AuditLogRestResource extends PagingAndSortingRepository<AuditLog, Long>  {

	List<AuditLog> findBySource(@Param("name") String name);
	
}
