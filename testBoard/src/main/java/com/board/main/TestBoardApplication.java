package com.board.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.board.*")
public class TestBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestBoardApplication.class, args);
	}

}
