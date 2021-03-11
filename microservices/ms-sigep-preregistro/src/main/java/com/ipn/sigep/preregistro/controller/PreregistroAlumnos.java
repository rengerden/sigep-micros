package com.ipn.sigep.preregistro.controller;

import com.ipn.sigep.preregistro.business.PreregistroServiceImpl;
import com.ipn.sigep.preregistro.constant.ApiConstants;
import com.ipn.sigep.preregistro.constant.Constants;
import com.ipn.sigep.preregistro.domain.Preregistros;
import com.ipn.sigep.preregistro.model.ErrorResponse;
import com.ipn.sigep.preregistro.model.Preregistro;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import javax.mail.MessagingException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Clase que expone via REST a traves de diferentes metodos las funcionalidades necesarias para el
 * pregistro de alumnos.
 * 
 * @author rengerden
 * @version 1.0.0
 *
 */
@RestController
@RequestMapping(value = "ipn/sgep/api/v1/preregistro")
@Validated
@ApiResponses(value = {
    @ApiResponse(code = Constants.CODE_BAD_REQUEST, message = ApiConstants.BAD_REQUEST,
        response = ErrorResponse.class),
    @ApiResponse(code = Constants.CODE_UNAUTHORIZED, message = ApiConstants.UNAUTHORIZED,
        response = ErrorResponse.class),
    @ApiResponse(code = Constants.CODE_ACCESS_NOT_CONFIGURED,
        message = ApiConstants.ACCESS_NOT_CONFIGURED, response = ErrorResponse.class),
    @ApiResponse(code = Constants.CODE_NOT_FOUND, message = ApiConstants.NOT_FOUND,
        response = ErrorResponse.class),
    @ApiResponse(code = Constants.CODE_BUSINESS_VALIDATION_FAILED,
        message = ApiConstants.BUSINESS_VALIDATION_FAILED, response = ErrorResponse.class),
    @ApiResponse(code = Constants.CODE_INTERNAL_ERROR, message = ApiConstants.INTERNAL_ERROR,
        response = ErrorResponse.class)})
public class PreregistroAlumnos {

  /**
   * Componente que implementa la capa de logica de negocio y llamado a servicios.
   */
  @Autowired
  PreregistroServiceImpl preregistroService;

  /**
   * Metodo que expone via REST a traves del metodo POST la funcionalidad de guardar el preregistro
   * de un alumno.
   *
   * @param uuid identificador unico del request.
   * @param contentType tipo de contenido aceptado por el api.
   * @param preregistroModel modelo que contiene los datos para el preregistro de un alumno.
   * @return the response entity
   * @throws ParseException the parse exception
   * @throws MessagingException the messaging exception
   * @throws IOException Signals that an I/O exception has occurred.
   */
  @PostMapping(value = "alumnos/guarda", consumes = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "funcionalidad para guardar el preregistro de alumnos")
  @ApiResponses(value = {@ApiResponse(code = 200, message = "create success")})
  public ResponseEntity<Void> guardaPreregistro(@RequestHeader(name = "uuid") String uuid,
      @RequestHeader(name = "Content-Type") String contentType,
      @Valid @RequestBody Preregistro preregistroModel)
      throws ParseException, MessagingException, IOException {
    preregistroService.savePreregistro(preregistroModel);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  /**
   * Gets the lista preregistros.
   *
   * @return the lista preregistros
   */
  @GetMapping(value = "alumnos/consulta", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "devuelve un listado de todos los alumnos preregistrados")
  @ApiResponses(
      value = {@ApiResponse(code = 200, message = "delete success", response = List.class)})
  public ResponseEntity<List<Preregistros>> getListaPreregistros() {
    return new ResponseEntity<>(preregistroService.getListaPreregistro(), HttpStatus.OK);
  }

  /**
   * Gets the preregistro.
   *
   * @param idPreregistro the id preregistro
   * @return the preregistro
   */
  @GetMapping(value = "alumnos/consulta/id/{idPreregistro}",
      produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(
      value = "devuelve la informacion de un alumno preregistrado mediante su id_preregistro")
  public ResponseEntity<Preregistros> getPreregistro(
      @PathVariable("idPreregistro") Integer idPreregistro) {
    return new ResponseEntity<>(preregistroService.getPreregistro(idPreregistro), HttpStatus.OK);
  }

  /**
   * Update preregistro.
   *
   * @param preregistroModel the preregistro model
   * @return the response entity
   * @throws ParseException the parse exception
   */
  @PutMapping(value = "alumnos/actualiza", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "actualiza la informacion de un alumno preregistrado")
  public ResponseEntity<Void> updatePreregistro(@RequestBody Preregistro preregistroModel)
      throws ParseException {
    preregistroService.updatePreregistro(preregistroModel);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  /**
   * Delete preregistro by id.
   *
   * @param idPreregistro the id preregistro
   * @return the response entity
   */
  @DeleteMapping(value = "alumnos/elimina/id/{idPreregistro}",
      produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "borra el preregistro de un alumno")
  public ResponseEntity<Void> deletePreregistroById(
      @PathVariable("id_preregistro") Integer idPreregistro) {
    preregistroService.deletePreregistroById(idPreregistro);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  /**
   * Gets the preregistro by folio.
   *
   * @param folio the folio
   * @return the preregistro by folio
   */
  @GetMapping(value = "alumnos/consulta/folio/{folio}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "devuelve la informacion de un alumno preregistrado mediante su folio")
  public ResponseEntity<Preregistros> getPreregistroByFolio(@PathVariable("folio") String folio) {
    return new ResponseEntity<>(preregistroService.getPreregistroByFolio(folio), HttpStatus.OK);
  }

  /**
   * Gets the preregistro by curp.
   *
   * @param curp the curp
   * @return the preregistro by curp
   */
  @GetMapping(value = "alumnos/consulta/curp/{curp}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "devuelve la informacion de un alumno preregistrado mediante su curp")
  public ResponseEntity<Preregistros> getPreregistroByCurp(@PathVariable("curp") String curp) {
    return new ResponseEntity<>(preregistroService.getPreregistroByCurp(curp), HttpStatus.OK);
  }

  /**
   * Delete preregistro by curp.
   *
   * @param curp the curp
   * @return the response entity
   */
  @DeleteMapping(value = "alumnos/elimina/curp/{curp}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "borra el preregistro de un alumno")
  public ResponseEntity<Void> deletePreregistroByCurp(@PathVariable("curp") String curp) {
    preregistroService.deletePreregistroByCurp(curp);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  /**
   * Delete preregistro by folio.
   *
   * @param folio the folio
   * @return the response entity
   */
  @DeleteMapping(value = "alumnos/elimina/folio/{folio}",
      produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "borra el preregistro de un alumno")
  public ResponseEntity<Void> deletePreregistroByFolio(@PathVariable("folio") String folio) {
    preregistroService.deletePreregistroByFolio(folio);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  /**
   * Prueba correo.
   *
   * @return the response entity
   */
  @GetMapping(value = "alumnos/correo", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Void> pruebaCorreo() {
    
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

}
