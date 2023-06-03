package com.kesavan.springbatchexp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringbatchexpApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbatchexpApplication.class, args);
	}

}
