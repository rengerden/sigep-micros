package com.ipn.sigep.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


/**
 * The Class MsSigepDiscoveryApplication.
 */
@SpringBootApplication
@EnableEurekaServer
public class MsSigepDiscoveryApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(MsSigepDiscoveryApplication.class, args);
	}

}
