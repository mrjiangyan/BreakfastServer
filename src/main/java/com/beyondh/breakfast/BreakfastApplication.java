package com.beyondh.breakfast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.ipms"})
@ComponentScan(basePackages = {"com.beyondh"})
@SpringBootApplication
public class BreakfastApplication {

	public static void main(String[] args) {
		SpringApplication.run(BreakfastApplication.class, args);
	}
}
