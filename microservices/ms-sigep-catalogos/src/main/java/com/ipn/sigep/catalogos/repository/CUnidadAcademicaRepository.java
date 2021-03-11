package com.ipn.sigep.catalogos.repository;


import com.ipn.sigep.catalogos.domain.CUnidadAcademica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * The Interface CUnidadAcademicaRepository.
 */
@RepositoryRestResource(path = "unidades", collectionResourceRel = "unidades")
public interface CUnidadAcademicaRepository extends JpaRepository<CUnidadAcademica, Long>{

}
