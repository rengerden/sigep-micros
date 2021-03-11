package com.ipn.sigep.preregistro.controller;

import com.ipn.sigep.preregistro.constant.ApiConstants;
import com.ipn.sigep.preregistro.constant.Constants;
import com.ipn.sigep.preregistro.model.ErrorResponse;
import com.ipn.sigep.preregistro.service.ProgramaAcademicoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * The Class ProgramasAcademicos.
 */
@RestController
@RequestMapping(value = "ipn/sgep/api/v1/programaAcademico")
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
public class ProgramasAcademicos {

  /** The programa academico service. */
  @Autowired
  ProgramaAcademicoService programaAcademicoService;

  /**
   * Metodo GET que devuelve un listado de los programas academnicos de la unidad.
   *
   * @param idUnidadAcademica the id unidad academica
   * @return the programas academicos
   */
  @GetMapping(value = "/consulta/{idUnidadAcademica}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ApiOperation(value = "devuelve un listado de todos los programas academicos disponibles")
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "delete success", response = ProgramasAcademicos.class)})
  public ResponseEntity<com.ipn.sigep.preregistro.model.ProgramasAcademicos> getProgramasAcademicos(
      @PathVariable("idUnidadAcademica") Integer idUnidadAcademica) {
    return new ResponseEntity<>(programaAcademicoService.getProgramasAcademicos(idUnidadAcademica),
        HttpStatus.OK);

  }
}


