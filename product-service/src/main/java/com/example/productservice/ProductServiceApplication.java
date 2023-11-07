package com.example.productservice;

import org.example.commons.ServiceNames;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Properties;

@SpringBootApplication
@EnableAspectJAutoProxy
public class ProductServiceApplication {

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("spring.application.name", ServiceNames.productService);
        new SpringApplicationBuilder(ProductServiceApplication.class)
                .properties(properties)
                .run(args);
    }

}
