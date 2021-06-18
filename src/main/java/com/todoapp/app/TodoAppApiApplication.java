package com.todoapp.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class TodoAppApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoAppApiApplication.class, args);

    }
}
