package com.ipn.sigep.preregistro.domain;
// Generated 20/02/2020 12:57:26 AM by Hibernate Tools 5.0.6.Final

import io.swagger.annotations.ApiModel;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;


/**
 * Preregistros generated by hbm2java.
 */

/**
 * Instantiates a new preregistros.
 *
 * @param idPreregistro the id preregistro
 * @param nombre the nombre
 * @param apellidoPaterno the apellido paterno
 * @param apellidoMaterno the apellido materno
 * @param curp the curp
 * @param genero the genero
 * @param estatus the estatus
 * @param fechaCreacion the fecha creacion
 * @param correoElectronico the correo electronico
 * @param folio the folio
 * @param fechaNacimiento the fecha nacimiento
 * @param idProgramaAcademico the id programa academico
 */
@AllArgsConstructor

/**
 * Instantiates a new preregistros.
 */
@NoArgsConstructor
@Entity

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Data
@ApiModel(value = "PreregistroResponse",
    description = "Modelo de respuesta para la consulta de preregistros")
@Table(name = "preregistros", catalog = "sigep_db",
    uniqueConstraints = @UniqueConstraint(columnNames = "curp"))
@DynamicUpdate
public class Preregistros implements java.io.Serializable {


  /**
   * serialVersionUID generado automaticamente.
   */
  private static final long serialVersionUID = 9003110631051163069L;

  /** The id preregistro. */
  @Id
  @Column(name = "idPreregistro", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idPreregistro;
  
  /** The nombre. */
  @Column(name = "nombre", nullable = false, length = 60)
  private String nombre;
  
  /** The apellido paterno. */
  @Column(name = "apellidoPaterno", nullable = false, length = 60)
  private String apellidoPaterno;
  
  /** The apellido materno. */
  @Column(name = "apellidoMaterno", length = 60)
  private String apellidoMaterno;
  
  /** The curp. */
  @Column(name = "curp", unique = true, nullable = false, length = 18)
  private String curp;
  
  /** The genero. */
  @Column(name = "genero", nullable = false, length = 1)
  private String genero;
  
  /** The estatus. */
  @Column(name = "estatus", nullable = false)
  private Integer estatus;
  
  /** The fecha creacion. */
  @Temporal(TemporalType.DATE)
  @Column(name = "fechaCreacion", nullable = false, length = 19, updatable = false)
  private Date fechaCreacion;
  
  /** The correo electronico. */
  @Column(name = "correoElectronico", nullable = false, length = 60)
  private String correoElectronico;
  
  /** The folio. */
  @Column(name = "folio", length = 30)
  private String folio;
  
  /** The fecha nacimiento. */
  @Column(name = "fechaNacimiento", length = 19)
  @Temporal(TemporalType.DATE)
  private Date fechaNacimiento;
  
  /** The id programa academico. */
  @Column(name = "idProgramaAcademico", nullable = false)
  private Integer idProgramaAcademico;
}
