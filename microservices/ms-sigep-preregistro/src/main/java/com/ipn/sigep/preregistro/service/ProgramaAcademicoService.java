package com.ipn.sigep.preregistro.service;

import com.ipn.sigep.preregistro.model.ProgramasAcademicos;


/**
 * The Interface ProgramaAcademicoService.
 */
public interface ProgramaAcademicoService {
  
  /**
   * Gets the programas academicos.
   *
   * @param idUnidadAcademica the id unidad academica
   * @return the programas academicos
   */
  ProgramasAcademicos getProgramasAcademicos(int idUnidadAcademica); 

}
