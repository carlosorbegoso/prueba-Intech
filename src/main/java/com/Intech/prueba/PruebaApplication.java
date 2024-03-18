package com.Intech.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * The main entry point for the Spring Boot application.
 * This class contains the main method which uses Spring Boot's SpringApplication.run() method to launch the application.
 *
 * @author Carlos Orbegoso
 */
@SpringBootApplication
public class PruebaApplication {
	/**
	 * The main method which serves as the entry point for the JVM. This method delegates to Spring Boot's SpringApplication
	 * class to bootstrap the application.
	 *
	 * @param args The command line arguments passed to the application. It's used to configure properties of the application.
	 */
	public static void main(String[] args) {
		SpringApplication.run(PruebaApplication.class, args);

	}

}
