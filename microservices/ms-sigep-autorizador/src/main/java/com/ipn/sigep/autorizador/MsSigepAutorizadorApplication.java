package com.ipn.sigep.autorizador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * The Class MsSigepAutorizadorApplication.
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class MsSigepAutorizadorApplication implements CommandLineRunner{

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(MsSigepAutorizadorApplication.class, args);
	}

	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder; 
  @Override
  public void run(String... args) throws Exception {
    String pass = "1234567";
    System.out.println(bCryptPasswordEncoder.encode(pass));
    
  }

}
