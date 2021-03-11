package com.ipn.sigep.preregistro.business;

import com.ipn.sigep.preregistro.model.ProgramasAcademicos;
import com.ipn.sigep.preregistro.repository.ProgramasAcademicosRepository;
import com.ipn.sigep.preregistro.service.ProgramaAcademicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * The Class ProgramaAcademicoServiceImpl.
 */
@Service
public class ProgramaAcademicoServiceImpl implements ProgramaAcademicoService {

  /** The programas academicos repository. */
  @Autowired
  private ProgramasAcademicosRepository programasAcademicosRepository;

  /**
   * Gets the programas academicos.
   *
   * @param idUnidadAcademica the id unidad academica
   * @return the programas academicos
   */
  @Override
  public ProgramasAcademicos getProgramasAcademicos(int idUnidadAcademica) {
    return ProgramasAcademicos.builder().listaProgramasAcademicos(
        programasAcademicosRepository.findByIdUnidadAcademica(idUnidadAcademica)).build();
  }


}
