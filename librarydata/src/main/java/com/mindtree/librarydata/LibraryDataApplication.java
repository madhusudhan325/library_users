package com.mindtree.librarydata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan("com.mindtree")
@SpringBootApplication
public class LibraryDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryDataApplication.class, args);
	}

}
