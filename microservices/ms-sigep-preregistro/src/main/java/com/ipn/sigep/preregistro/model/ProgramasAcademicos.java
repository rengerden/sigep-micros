package com.ipn.sigep.preregistro.model;

import com.ipn.sigep.preregistro.domain.VProgramasacademicos;
import java.util.List;
import lombok.Builder;
import lombok.Data;


/**
 * To string.
 *
 * @return the java.lang. string
 */
@Data

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder
public class ProgramasAcademicos {
  
  /** The lista programas academicos. */
  List<VProgramasacademicos> listaProgramasAcademicos;

}
