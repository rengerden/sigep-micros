package com.ipn.sigep.preregistro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


/**
 * Clase principal el cual ejecuta springboot.
 * 
 * @author Alfonso Chávez.
 * 
 * @version 1.0.0
 **/
@SpringBootApplication
@EnableEurekaClient
public class MsSgepApplication {

  /**
   * The main method.
   *
   * @param args the arguments
   */
  /*
   * Main method.
   */
  public static void main(String[] args) {
    SpringApplication.run(MsSgepApplication.class, args);
  }

}
