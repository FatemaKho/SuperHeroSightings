package com.sg.SuperHero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class SuperHeroApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuperHeroApplication.class, args);
	}

}
