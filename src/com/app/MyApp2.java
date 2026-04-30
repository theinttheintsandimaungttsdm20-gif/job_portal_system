package com.app;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class MyApp2 {

  public static void main(String[] args) {

	  int i = 0;
		while (i < 10) {
			String password = "123456";
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(password);

			System.out.println(hashedPassword);
			i++;
		}

  }
}