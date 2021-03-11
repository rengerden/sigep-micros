package com.ipn.sigep.catalogos.domain;

import org.hibernate.annotations.DynamicUpdate;
import java.util.Date;
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
 * Instantiates a new c periodos.
 *
 * @param idPeriodo the id periodo
 * @param descripcion the descripcion
 * @param clave the clave
 * @param fechaInicio the fecha inicio
 * @param fechaFin the fecha fin
 */
@AllArgsConstructor

/**
 * Instantiates a new c periodos.
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
@Table(name = "c_periodos", catalog = "sigep_db")

/**
 * Hash code.
 *
 * @return the int
 */
@EqualsAndHashCode(callSuper = false)
public class CPeriodos extends CamposControl implements java.io.Serializable {
  
  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = -6632919052289905690L;

  /** The id periodo. */
  @Id
  @Column(name = "idPeriodo", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idPeriodo;
  
  /** The descripcion. */
  @Column(name = "descripcion", nullable = false, length = 100)
  private String descripcion;

  /** The clave. */
  @Column(name = "clave", nullable = false, length = 30)
  private String clave;

  /** The fecha inicio. */
  @Column(name = "fechaInicio", nullable = false, length = 19, updatable = false)
  public Date fechaInicio;

  /** The fecha fin. */
  @Column(name = "fechaFin", nullable = false, length = 19, updatable = false)
  public Date fechaFin;
}
