package com.ipn.sigep.catalogos.domain;

import org.hibernate.annotations.DynamicUpdate;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


/**
 * Instantiates a new c academias.
 *
 * @param idAcademia the id academia
 * @param idUnidadAcademica the id unidad academica
 * @param nombre the nombre
 * @param clave the clave
 */
@AllArgsConstructor

/**
 * Instantiates a new c academias.
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

/**
 * Hash code.
 *
 * @return the int
 */
@EqualsAndHashCode(callSuper = false)
@Table(name = "c_academias", catalog = "sigep_db")
public class CAcademias extends CamposControl implements Serializable {

  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1355953666735525414L;

  /** The id academia. */
  @Id
  @Column(name = "idAcademia", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idAcademia;
  
  /** The id unidad academica. */
  @Column(name = "idUnidadAcademica", nullable = false)
  private Long idUnidadAcademica;
  
  /** The nombre. */
  @Column(name = "nombre", nullable = false, length = 100)
  private String nombre;
  
  /** The clave. */
  @Column(name = "clave", nullable = false)
  private String clave;
}
