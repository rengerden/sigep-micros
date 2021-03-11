package com.ipn.sigep.catalogos.repository;


import com.ipn.sigep.catalogos.domain.CPeriodos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * The Interface CPeriodosRepository.
 */
@RepositoryRestResource(path = "periodos", collectionResourceRel = "periodos")
public interface CPeriodosRepository extends JpaRepository<CPeriodos, Long>{

}
