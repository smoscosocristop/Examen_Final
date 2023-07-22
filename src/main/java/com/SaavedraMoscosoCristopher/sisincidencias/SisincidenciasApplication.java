package com.SaavedraMoscosoCristopher.sisincidencias;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class SisincidenciasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SisincidenciasApplication.class, args);
	}

}
