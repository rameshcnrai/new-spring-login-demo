package com.example.logindemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Main entry point for the Spring Boot + JSP login demo.
 *
 * Extends SpringBootServletInitializer so the app can also be packaged
 * as a WAR and deployed to an external servlet container if needed,
 * while still being runnable directly via `mvn spring-boot:run`.
 */
@SpringBootApplication
public class LoginDemoApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(LoginDemoApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(LoginDemoApplication.class);
    }
}
