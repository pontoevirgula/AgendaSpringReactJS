package com.chsl.agendaeventos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SpringBootConfiguration
//@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class AgendaeventosApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgendaeventosApplication.class, args);
	}
}
