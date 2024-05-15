package com.crud_project.elice;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class EliceApplication implements CommandLineRunner {
	@Autowired
	EntityManagerFactory emf;

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(EliceApplication.class);
		app.run(args);
	}

	@Override
	public void run(String... args) throws Exception { }
}