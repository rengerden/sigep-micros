package com.ipn.sigep.preregistro.repository;

import com.ipn.sigep.preregistro.domain.VProgramasacademicos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * The Interface ProgramasAcademicosRepository.
 */
public interface ProgramasAcademicosRepository
    extends JpaRepository<VProgramasacademicos, Integer> {
  
  /**
   * Find by id unidad academica.
   *
   * @param idUnidadAcademica the id unidad academica
   * @return the list
   */
  List<VProgramasacademicos> findByIdUnidadAcademica(Integer idUnidadAcademica);

}
