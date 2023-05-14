package com.example.handmade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCrypt;

@SpringBootApplication
public class HandmadeApplication {

	public static void main(String[] args) {
		SpringApplication.run(HandmadeApplication.class, args);
		String a = "123123";
		String b= BCrypt.hashpw(a,BCrypt.gensalt(12));
		System.out.println(b);
		boolean c =BCrypt.checkpw(a,b);
		System.out.println(c);
	}

}
