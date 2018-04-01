package com.example.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BarCommandService extends CommandService {

    @Override
    public void execute() {
        System.out.println("*** call Bar execute. arg=" + argument);
    }

    @Configuration
    public static class BarCommandConfig {
        @Bean
        @ConditionalOnProperty(value = "type", havingValue = "bar")
        public BarCommandService barCommandService() {
            return new BarCommandService();
        }
    }
}
