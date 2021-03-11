package com.ipn.sigep.preregistro.domain;
// Generated 16/03/2020 10:38:49 PM by Hibernate Tools 5.0.6.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;


/**
 * Usuarios generated by hbm2java.
 */

/**
 * Instantiates a new usuarios.
 *
 * @param idusuario the idusuario
 * @param nombreUsuario the nombre usuario
 * @param correoElectronico the correo electronico
 * @param password the password
 * @param token the token
 * @param fechaCreacion the fecha creacion
 * @param idRol the id rol
 * @param fechaUiltSesion the fecha uilt sesion
 * @param alumnos the alumnos
 */
@AllArgsConstructor

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
@Data
@Table(name = "usuarios", catalog = "sigep_db",
    uniqueConstraints = {@UniqueConstraint(columnNames = "correoElectronico"),
        @UniqueConstraint(columnNames = "nombreUsuario")})
public class Usuarios implements java.io.Serializable {


  /**
   *  serialVersionUID generado automaticamente.
   */
  private static final long serialVersionUID = -2284469676272019289L;
  
  /** The idusuario. */
  @Id
  @Column(name = "idusuario", unique = true, nullable = false)
  private Integer idusuario;
  
  /** The nombre usuario. */
  @Column(name = "nombreUsuario", unique = true, nullable = false, length = 45)
  private String nombreUsuario;
  
  /** The correo electronico. */
  @Column(name = "correoElectronico", unique = true, nullable = false, length = 45)
  private String correoElectronico;
  
  /** The password. */
  @Column(name = "password", nullable = false, length = 45)
  private String password;
  
  /** The token. */
  @Column(name = "token", length = 45)
  private String token;
  
  /** The fecha creacion. */
  @Column(name = "fechaCreacion", nullable = false, length = 45)
  private String fechaCreacion;
  
  /** The id rol. */
  @Column(name = "idRol", nullable = false)
  private Integer idRol;
  
  /** The fecha uilt sesion. */
  @Column(name = "fechaUiltSesion", length = 45)
  private String fechaUiltSesion;
  
  /** The alumnos. */
  @OneToOne(fetch = FetchType.LAZY, mappedBy = "usuarios")
  private Alumnos alumnos;
}