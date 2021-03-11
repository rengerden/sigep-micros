package com.ipn.sigep.autorizador.domain;


import java.io.Serializable;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Instantiates a new usuarios.
 */

/**
 * Instantiates a new usuarios.
 *
 * @param idUsuario the id usuario
 * @param nombreUsuario the nombre usuario
 * @param correoElectronico the correo electronico
 * @param password the password
 * @param token the token
 * @param estatus the estatus
 * @param fechaCreacion the fecha creacion
 * @param role the role
 * @param fechaUltSesion the fecha ult sesion
 */
@AllArgsConstructor

/**
 * Instantiates a new usuarios.
 */

/**
 * Instantiates a new usuarios.
 */
@NoArgsConstructor

/**
 * To string.
 *
 * @return the java.lang. string
 */

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Data
public class Usuarios implements Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = -4449847352563854707L;

  /** The id usuario. */
  private Long idUsuario;

  /** The nombre usuario. */
  private String nombreUsuario;

  /** The correo electronico. */
  private String correoElectronico;

  /** The password. */
  private String password;

  /** The token. */
  private String token;

  /** The estatus. */
  public int estatus;

  /** The fecha creacion. */
  public Date fechaCreacion;

  /** The role. */
  private String role;

  /** The fecha ult sesion. */
  private Date fechaUltSesion;



}
