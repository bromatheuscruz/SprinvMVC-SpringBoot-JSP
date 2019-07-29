package com.iocruz.bookscode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class BookscodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookscodeApplication.class, args);
	}
}
	