package com.ipn.sigep.catalogos.repository;

import com.ipn.sigep.catalogos.domain.CCarreras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * The Interface CCarrerasRepository.
 */
@RepositoryRestResource(path = "carreras", collectionResourceRel = "carreras")
public interface CCarrerasRepository extends JpaRepository<CCarreras, Long> {

}
