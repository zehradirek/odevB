package com.tobeto;

import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TechStockApplication {
	public static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		context =SpringApplication.run(TechStockApplication.class, args);
		String hexValue = "a4a4483d-ddd7-11ee-a249-40c2ba1e7deb";  // HEX formatındaki değeri buraya ekleyin
		UUID uuid = UUID.fromString(hexValue);
		System.out.println("UUID: " + uuid.toString());
	}

}
