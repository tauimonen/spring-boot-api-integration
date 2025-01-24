package com.tau.jany;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClient;

@SpringBootApplication
public class JanyApplication {

	public static void main(String[] args) {
		SpringApplication.run(JanyApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(RestClient.Builder builder) {
		return args -> {
			var client = builder
					.baseUrl("http://localhost:8080")
					.defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
					.build();

			ResponseEntity<GroupedDaily> entity = client.get()
					.uri("/api/jany")
					.retrieve()
					.toEntity(GroupedDaily.class);

			System.out.println(entity);
		};
	}

}
