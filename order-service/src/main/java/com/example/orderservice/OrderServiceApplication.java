package com.example.orderservice;

import org.example.commons.ServiceNames;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Properties;

@SpringBootApplication
@EnableFeignClients
public class OrderServiceApplication {

	public static void main(String[] args) {
		Properties properties = new Properties();
		properties.put("spring.application.name", ServiceNames.orderService);
		new SpringApplicationBuilder(OrderServiceApplication.class)
				.properties(properties)
						.run(args);

		SpringApplication.run(OrderServiceApplication.class, args);
	}

}
