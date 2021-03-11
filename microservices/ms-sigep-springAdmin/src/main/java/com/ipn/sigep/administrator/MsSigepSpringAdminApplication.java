package com.ipn.sigep.administrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class MsSigepSpringAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsSigepSpringAdminApplication.class, args);
	}

}
