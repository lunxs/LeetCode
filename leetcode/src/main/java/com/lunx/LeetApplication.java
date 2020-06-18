package com.lunx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class LeetApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeetApplication.class, args);
    }
}
