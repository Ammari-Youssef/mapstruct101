package com.moushtario.mapstruct101;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Mapstruct101Application {

	public static void main(String[] args) {
		// Load .env file
		Dotenv dotenv = Dotenv.load();

		// Set system properties
		System.setProperty("DB_USER", dotenv.get("DB_USER"));
		System.setProperty("DB_PASS", dotenv.get("DB_PASS"));
		System.setProperty("DB_URL", dotenv.get("DB_URL"));
		System.setProperty("DB_DRIVER", dotenv.get("DB_DRIVER"));
		System.setProperty("DB_DIALECT", dotenv.get("DB_DIALECT"));
		System.setProperty("SPRING_PROFILES_ACTIVE", dotenv.get("SPRING_PROFILES_ACTIVE"));

		SpringApplication.run(Mapstruct101Application.class, args);
	}

}
