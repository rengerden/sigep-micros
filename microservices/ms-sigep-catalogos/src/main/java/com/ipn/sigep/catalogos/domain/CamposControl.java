package com.ipn.sigep.catalogos.domain;

import java.util.Date;
import javax.persistence.Column;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * Instantiates a new campos control.
 */
@Data

/**
 * Hash code.
 *
 * @return the int
 */
@EqualsAndHashCode(callSuper=false)
public class CamposControl {

  /** The estatus. */
  @Column(name = "estatus", nullable = false)
  public  Integer estatus;
  
  /** The fecha creacion. */
  @Column(name = "fechaCreacion", nullable = false, length = 19, updatable = false)
  public Date fechaCreacion;
}
