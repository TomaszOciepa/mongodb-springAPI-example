package com.tom.SpringBootRestApiMongodb;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.List;

@SpringBootApplication
public class SpringBootRestApiMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestApiMongodbApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(StudentRepository repository){
		return args -> {
			Address address = new Address(
					"Poland",
					"Gdańsk",
					"80-283"
			);

			Student student = new Student(
					"klaudia",
					"quirini",
					"klaudia@gmail.com",
					Gender.MALE,
					address,
					List.of("Computer Science, Books, Musics"),
					BigDecimal.TEN,
					LocalDateTime.now()
			);

			repository.insert(student);
		};
	}


}
