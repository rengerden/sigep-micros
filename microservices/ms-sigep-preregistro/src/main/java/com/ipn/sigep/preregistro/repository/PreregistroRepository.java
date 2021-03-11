package com.ipn.sigep.preregistro.repository;

import com.ipn.sigep.preregistro.domain.Preregistros;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Clase repository para el preregistro de alumnos.
 * @author Alfonso Chávez.
 *
 */
public interface PreregistroRepository extends JpaRepository<Preregistros, Integer> {

  /**
   * Find by folio.
   *
   * @param folio the folio
   * @return the preregistros
   */
  Preregistros findByFolio(String folio);
  
  /**
   * Find by curp.
   *
   * @param curp the curp
   * @return the preregistros
   */
  Preregistros findByCurp(String curp);
  
  /**
   * Delete by folio.
   *
   * @param folio the folio
   */
  void deleteByFolio(String folio);
  
  /**
   * Delete by curp.
   *
   * @param curp the curp
   */
  void deleteByCurp(String curp);
}
