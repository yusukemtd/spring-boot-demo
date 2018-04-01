package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.service.CommandService;

@SpringBootApplication
public class CliAppApplication {

    public static void main(String[] args) {

        try (ConfigurableApplicationContext context = SpringApplication.run(CliAppApplication.class, args)) {
            context.getBean(CommandService.class).execute();

        }
    }
}
