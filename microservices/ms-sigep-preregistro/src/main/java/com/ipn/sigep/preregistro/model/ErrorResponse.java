package com.ipn.sigep.preregistro.model;

import com.ipn.sigep.preregistro.constant.Constants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;


/**
 * The Class ErrorResponse.
 */
@ApiModel(reference = "Error Response",
    description = "Respuesta generica con el fin de explicar el error sucedido dentro del API",
    value = "ErrorResponse")

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
public class ErrorResponse {

  /** The type. */
  @ApiModelProperty(required = Constants.VALOR_BOOLEAN_TRUE, example = "FATAL",
      position = Constants.VALOR_INT_1)
  private String type;
  
  /** The details. */
  @ApiModelProperty(required = Constants.VALOR_BOOLEAN_TRUE, example = "El valor no puede ir null",
      position = Constants.VALOR_INT_2)
  private String details;
  
  /** The uuid. */
  @ApiModelProperty(required = Constants.VALOR_BOOLEAN_TRUE, example = "9873429012312",
      position = Constants.VALOR_INT_3)
  private String uuid;
  
  /** The datetime. */
  @ApiModelProperty(required = Constants.VALOR_BOOLEAN_TRUE,
      example = "2020-03-28T19:56:39.165-06:00[America/Mexico_City]",
      position = Constants.VALOR_INT_4)
  private String datetime;

}
