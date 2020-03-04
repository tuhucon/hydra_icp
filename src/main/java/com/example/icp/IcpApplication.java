package com.example.icp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@SpringBootApplication
public class IcpApplication {

    public static void main(String[] args) {
        SpringApplication.run(IcpApplication.class, args);
    }

}
