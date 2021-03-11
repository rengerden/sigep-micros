package com.ipn.sigep.catalogos.repository;

import com.ipn.sigep.catalogos.domain.CPlanes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * The Interface CPlanesRepository.
 */
@RepositoryRestResource(path = "planes",collectionResourceRel = "planes")
public interface CPlanesRepository extends JpaRepository<CPlanes, Long>{

}
