package com.taller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class TallerSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TallerSpringApplication.class, args);
	}

}
