package com.ipn.sigep.catalogos.config;


import com.ipn.sigep.catalogos.domain.CAcademias;
import com.ipn.sigep.catalogos.domain.CCarreras;
import com.ipn.sigep.catalogos.domain.CNiveles;
import com.ipn.sigep.catalogos.domain.CPeriodos;
import com.ipn.sigep.catalogos.domain.CPlanes;
import com.ipn.sigep.catalogos.domain.CUnidadAcademica;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;


/**
 * The Class RepositoryConfig.
 */
@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer{

  /**
   * Configure repository rest configuration.
   *
   * @param config the config
   */
  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
  config.exposeIdsFor(CAcademias.class,CCarreras.class,CNiveles.class,CPeriodos.class,CPlanes.class,CUnidadAcademica.class);

  }

}
