package com.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author juqi
 */
@SpringBootApplication
@EnableCaching
public class App {
//localhost:9099/test
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
