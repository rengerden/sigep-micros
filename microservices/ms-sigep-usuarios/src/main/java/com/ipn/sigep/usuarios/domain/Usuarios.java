package com.ipn.sigep.usuarios.domain;

import org.hibernate.annotations.DynamicUpdate;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
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
@DynamicUpdate
@Entity

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
@Table(name = "usuarios", catalog = "sigep_db")
public class Usuarios implements Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = -4449847352563854707L;

  /** The id usuario. */
  @Id
  @Column(name = "idUsuario", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idUsuario;

  /** The nombre usuario. */
  @Column(name = "nombreUsuario", nullable = false, length = 45)
  private String nombreUsuario;

  /** The correo electronico. */
  @Column(name = "correoElectronico", nullable = false, length = 45)
  private String correoElectronico;

  /** The password. */
  @Column(name = "password", nullable = false, length = 45)
  private String password;

  /** The token. */
  @Column(name = "token", nullable = false, length = 100)
  private String token;

  /** The estatus. */
  @Column(name = "estatus", nullable = false)
  public int estatus;

  /** The fecha creacion. */
  @Column(name = "fechaCreacion", nullable = false, length = 19)
  public Date fechaCreacion;

  /** The role. */
  @Column(name = "role", nullable = false, length = 45)
  private String role;

  /** The fecha ult sesion. */
  @Column(name = "fechaUltSesion", length = 19)
  private Date fechaUltSesion;



}
