package com.madadipouya.internet.waybackmachine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class InternetWaybackMachine {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(InternetWaybackMachine.class, args);
    }
}
