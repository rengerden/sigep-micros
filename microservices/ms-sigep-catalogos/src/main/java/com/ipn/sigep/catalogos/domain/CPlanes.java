package com.ipn.sigep.catalogos.domain;

import org.hibernate.annotations.DynamicUpdate;
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
 * Instantiates a new c planes.
 *
 * @param idPlan the id plan
 * @param clave the clave
 * @param nombre the nombre
 * @param abreviatura the abreviatura
 */
@AllArgsConstructor

/**
 * Instantiates a new c planes.
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
@EqualsAndHashCode(callSuper=false)
@Table(name = "c_planes", catalog = "sigep_db")
public class CPlanes extends CamposControl implements java.io.Serializable{
/** The Constant serialVersionUID. */
  private static final long serialVersionUID = 5782346436642729805L;

  /** The id plan. */
  @Id
  @Column(name = "idPlan", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idPlan;
  
  /** The clave. */
  @Column(name = "clave", nullable = false, length = 5)
  private String clave;
  
  /** The nombre. */
  @Column(name = "nombre", nullable = false, length = 100)
  private String nombre;
  
  /** The abreviatura. */
  @Column(name = "abreviatura", nullable = false, length = 10)
  private String abreviatura;
  
}
