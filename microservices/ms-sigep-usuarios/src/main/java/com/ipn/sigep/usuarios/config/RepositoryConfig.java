package com.ipn.sigep.usuarios.config;



import com.ipn.sigep.usuarios.domain.Usuarios;
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
  config.exposeIdsFor(Usuarios.class);

  }

}
