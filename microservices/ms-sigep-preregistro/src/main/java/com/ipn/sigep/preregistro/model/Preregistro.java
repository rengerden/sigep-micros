package com.ipn.sigep.preregistro.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ipn.sigep.preregistro.constant.Constants;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import lombok.Data;


/**
 * Clase que sirve de modelo para el request del preregistro de alumnos.
 * 
 * @author Alfonso Chávez
 * @version 1.0.0
 * @apiNote
 */

@ApiModel(reference = "PreregistroRequest",
    description = "Modelo del request para el pregistro de los alumnos",
    value = "PreregistroRequest")

/**
 * Instantiates a new preregistro.
 */
@Data
public class Preregistro implements Serializable {

  /**
   * generated.
   */
  private static final long serialVersionUID = 2794687248588078516L;
  
  /** The nombre. */
  @ApiModelProperty(position = Constants.VALOR_INT_1, example = "Alfonso",
      required = Constants.VALOR_BOOLEAN_TRUE)
  @NotNull(message = "nombre no pueder ser nulo")
  @NotBlank(message = "nombre no pueder ser vacio")
  private String nombre;
  
  /** The apellido paterno. */
  @ApiModelProperty(position = Constants.VALOR_INT_2, example = "Chávez",
      required = Constants.VALOR_BOOLEAN_TRUE)
  @NotBlank
  private String apellidoPaterno;
  
  /** The apellido materno. */
  @ApiModelProperty(position = Constants.VALOR_INT_3, example = "Aguilar",
      required = Constants.VALOR_BOOLEAN_TRUE)
  @NotBlank
  private String apellidoMaterno;
  
  /** The curp. */
  @ApiModelProperty(position = Constants.VALOR_INT_4, example = "CAAA911221HDFHGL03",
      required = Constants.VALOR_BOOLEAN_TRUE)
  @NotBlank
  @Pattern(regexp = "^([A-Z][AEIOUX][A-Z]{2}\\d{2}(?:0[1-9]|1[0-2])(?:0[1-9]|[12]\\d|3[01])[HM]"
      + "(?:AS|B[CS]|C[CLMSH]|D[FG]|G[TR]|HG|JC|M[CNS]|N[ETL]|OC|PL|Q[TR]|S[PLR]|T[CSL]|VZ|YN|ZS)"
      + "[B-DF-HJ-NP-TV-Z]{3}[A-Z\\d])(\\d)$")
  private String curp;
  
  /** The correo electronico. */
  @ApiModelProperty(position = Constants.VALOR_INT_5, example = "alfonso.chavez.a@gmail.com",
      required = Constants.VALOR_BOOLEAN_TRUE)
  @NotBlank
  @Email
  private String correoElectronico;
  
  /** The genero. */
  @JsonIgnore
  private String genero;
  
  /** The fecha nacimiento. */
  @JsonIgnore
  private String fechaNacimiento;
  
  /** The id programa academico. */
  @ApiModelProperty(position = Constants.VALOR_INT_6, example = "1",
      required = Constants.VALOR_BOOLEAN_TRUE)
  @Positive
  @NotNull(message = "idProgramaAcademico no pueder ser nulo")
  private Integer idProgramaAcademico;
}
