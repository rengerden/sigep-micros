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
 * Instantiates a new c carreras.
 *
 * @param idCCarrera the id C carrera
 * @param clave the clave
 * @param nombre the nombre
 * @param abreviatura the abreviatura
 */
@AllArgsConstructor

/**
 * Instantiates a new c carreras.
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
@Table(name = "c_carreras", catalog = "sigep_db")
public class CCarreras extends CamposControl implements java.io.Serializable {
/** The Constant serialVersionUID. */
  private static final long serialVersionUID = 1512161391875766790L;
  
  /** The id C carrera. */
  @Id
  @Column(name = "idCarrera", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idCarrera;
  
  /** The clave. */
  @Column(name = "clave", nullable = false, length = 5)
  private String clave;
  
  /** The nombre. */
  @Column(name = "nombre", nullable = false, length = 100)
  private String nombre;
  
  /** The abreviatura. */
  @Column(name = "abreviatura", nullable = false, length = 50)
  private String abreviatura;
}
