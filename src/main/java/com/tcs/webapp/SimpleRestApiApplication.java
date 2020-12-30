package com.tcs.webapp;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleRestApiApplication.class, args);
		
		/*Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter your name:");
		String name = scan.next();
		
		System.out.println("Hi"+name);*/
		
	}

}
