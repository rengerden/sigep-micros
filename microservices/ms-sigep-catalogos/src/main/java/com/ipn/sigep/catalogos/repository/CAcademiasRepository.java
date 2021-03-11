package com.ipn.sigep.catalogos.repository;

import com.ipn.sigep.catalogos.domain.CAcademias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * The Interface CAcademiasRepository.
 */
@RepositoryRestResource(path = "academias", collectionResourceRel = "acedmias")
public interface CAcademiasRepository extends JpaRepository<CAcademias, Long>{

}
