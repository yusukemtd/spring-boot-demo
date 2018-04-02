package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.service.CommandService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class CliAppApplication {

    public static void main(String[] args) {

        log.debug("start main.");

        try (ConfigurableApplicationContext context = SpringApplication.run(CliAppApplication.class, args)) {
            context.getBean(CommandService.class).execute();

        }

        log.debug("term main.");
    }
}
