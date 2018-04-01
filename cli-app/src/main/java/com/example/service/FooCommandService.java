package com.example.service;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class FooCommandService extends CommandService {

    @Override
    public void execute() {
        System.out.println("*** call Foo execute. arg=" + argument);
    }

    @Configuration
    public static class FooCommandConfig {
        @Bean
        @ConditionalOnProperty(value = "type", havingValue = "foo")
        public FooCommandService fooCommandService() {
            return new FooCommandService();
        }
    }

}
