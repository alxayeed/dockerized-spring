package com.alxayeed.dockerized;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DockerizedApplication {

	private static final Logger logger = LoggerFactory.getLogger(DockerizedApplication.class);

	public static void main(String[] args) {
		logger.info("Application started...");
		SpringApplication.run(DockerizedApplication.class, args);
	}

}
