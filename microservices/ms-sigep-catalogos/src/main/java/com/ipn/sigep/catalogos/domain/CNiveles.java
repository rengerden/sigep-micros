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
 * Instantiates a new c niveles.
 *
 * @param idNivel the id nivel
 * @param clave the clave
 * @param nombre the nombre
 * @param abreviatura the abreviatura
 * @param minMaterias the min materias
 * @param maxMaterias the max materias
 * @param minCreditos the min creditos
 * @param maxCreditos the max creditos
 */
@AllArgsConstructor

/**
 * Instantiates a new c niveles.
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
@Table(name = "c_niveles", catalog = "sigep_db")
public class CNiveles extends CamposControl implements java.io.Serializable{

  /** The id nivel. */
  @Id
  @Column(name = "idNivel", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long idNivel;
  
  /** The Constant serialVersionUID. */
  private static final long serialVersionUID = 4661927580673745119L;
  
  /** The clave. */
  @Column(name = "clave", nullable = false, length = 5)
  private String clave;
  
  /** The nombre. */
  @Column(name = "nombre", nullable = false, length = 100)
  private String nombre;
  
  /** The abreviatura. */
  @Column(name = "abreviatura", nullable = false, length = 50)
  private String abreviatura;
  
  /** The min materias. */
  @Column(name = "minMaterias", nullable = false)
  private int minMaterias;
  
  /** The max materias. */
  @Column(name = "maxMaterias", nullable = false)
  private int maxMaterias;
  
  /** The min creditos. */
  @Column(name = "minCreditos", nullable = false)
  private int minCreditos;
  
  /** The max creditos. */
  @Column(name = "maxCreditos", nullable = false)
  private int maxCreditos;
}
