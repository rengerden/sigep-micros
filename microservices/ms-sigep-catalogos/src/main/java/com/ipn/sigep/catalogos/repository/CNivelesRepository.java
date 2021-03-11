 package com.ipn.sigep.catalogos.repository;

import com.ipn.sigep.catalogos.domain.CNiveles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * The Interface CNivelesRepository.
 */
@RepositoryRestResource(path = "niveles", collectionResourceRel = "niveles")
public interface CNivelesRepository extends JpaRepository<CNiveles, Long>{

}
