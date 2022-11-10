package com.project.commerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CommerceApplication {
    @Bean
    public RestTemplate restTemplate(){
        RestTemplate restTemplate = new RestTemplate();
//        restTemplate.setRequestFactory();
        return restTemplate;
    }
    public static void main(String[] args) {
        SpringApplication.run(CommerceApplication.class, args);
    }

}
