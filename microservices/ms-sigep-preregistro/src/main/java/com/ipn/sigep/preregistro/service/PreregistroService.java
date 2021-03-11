package com.ipn.sigep.preregistro.service;

import com.ipn.sigep.preregistro.domain.Preregistros;
import com.ipn.sigep.preregistro.model.Preregistro;
import java.text.ParseException;
import java.util.List;
import javax.mail.MessagingException;


/**
 * Interface que contiene las funciones necesarias para el preregistro de alumnos.
 * 
 * @author Alfonso Chávez
 * @version 1.0.0
 *
 */
public interface PreregistroService {


  /**
   * Save preregistro.
   *
   * @param preregistroModel the preregistro model
   * @throws ParseException the parse exception
   * @throws MessagingException the messaging exception
   */
  void savePreregistro(Preregistro preregistroModel) throws ParseException, MessagingException;
  
  /**
   * Gets the lista preregistro.
   *
   * @return the lista preregistro
   */
  List<Preregistros> getListaPreregistro();

  /**
   * Gets the preregistro.
   *
   * @param idPreregistro the id preregistro
   * @return the preregistro
   */
  Preregistros getPreregistro(Integer idPreregistro);

  /**
   * Delete preregistro by id.
   *
   * @param idPreregistro the id preregistro
   */
  void deletePreregistroById(Integer idPreregistro);

  /**
   * Update preregistro.
   *
   * @param preregistroModel the preregistro model
   * @throws ParseException the parse exception
   */
  void updatePreregistro(Preregistro preregistroModel) throws ParseException;

  /**
   * Gets the preregistro by folio.
   *
   * @param folio the folio
   * @return the preregistro by folio
   */
  Preregistros getPreregistroByFolio(String folio);

  /**
   * Gets the preregistro by curp.
   *
   * @param curp the curp
   * @return the preregistro by curp
   */
  Preregistros getPreregistroByCurp(String curp);

  /**
   * Delete preregistro by curp.
   *
   * @param curp the curp
   */
  void deletePreregistroByCurp(String curp);

  /**
   * Delete preregistro by folio.
   *
   * @param folio the folio
   */
  void deletePreregistroByFolio(String folio);

}
