package com.SanteVista.SanteVista;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SanteVistaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SanteVistaApplication.class, args);
	}

}
