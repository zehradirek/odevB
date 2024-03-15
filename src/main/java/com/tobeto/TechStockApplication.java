package com.tobeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class TechStockApplication {
	public static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		context =SpringApplication.run(TechStockApplication.class, args);
	//String hexValue = "A4A4483D-DDD7-11EE-A249-40C2BA1E7DEB";  // HEX formatındaki değeri buraya ekleyin
	//UUID uuid = UUID.fromString(hexValue);
	//System.out.println("UUID: " + uuid.toString());
}

}
