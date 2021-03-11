package com.ipn.sigep.preregistro.config;


import com.ipn.sigep.preregistro.constant.ApiConstants;
import com.ipn.sigep.preregistro.constant.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * Clase que configura la documentación del Swagger.
 * 
 * @author Alfonso Chávez.
 * @version 1.0.0
 *
 */
@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {
  
  /** The api constants. */
  @Autowired
  private ApiConstants apiConstants;

  /**
   * Bean que configura la información visible del Swagger.
   * 
   * @return Docket.
   * @see Docket
   */
  @Bean
  public Docket productApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        
        .useDefaultResponseMessages(Constants.VALOR_BOOLEAN_FALSE)
        .select()
        .apis(RequestHandlerSelectors.basePackage(apiConstants.getBasePackage()))
        .paths(PathSelectors.regex(apiConstants.getRegex()))
        .build()
        .apiInfo(apiInfo());
  }

  /**
   * Metodo que configura la informacion general del Swagger.
   * 
   * @return ApiInfo
   */
  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
        .title(apiConstants.getTittle())
        .description(apiConstants.getDescription())
        .version(apiConstants.getVersion())
        .contact(new Contact(apiConstants.getName(), apiConstants.getUrl(),apiConstants.getMail()))
        .build();
  }
}
