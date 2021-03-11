package com.ipn.sigep.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * The Class MsSigepGatewayApplication.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class MsSigepGatewayApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(MsSigepGatewayApplication.class, args);
	}

}
