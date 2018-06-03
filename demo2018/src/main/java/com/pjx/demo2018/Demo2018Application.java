package com.pjx.demo2018;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @author juqi
 */
@SpringBootApplication
@EnableCaching
public class Demo2018Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo2018Application.class, args);
    }
}
