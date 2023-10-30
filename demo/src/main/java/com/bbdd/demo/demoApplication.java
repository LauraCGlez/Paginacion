package com.bbdd.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.bbdd.demo.repository")
public class demoApplication {

    public static void main(String[] args) {
        SpringApplication.run(demoApplication.class, args);
    }

}