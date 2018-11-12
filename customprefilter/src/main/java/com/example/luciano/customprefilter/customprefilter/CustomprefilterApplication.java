package com.example.luciano.customprefilter.customprefilter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CustomprefilterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomprefilterApplication.class, args);
	}
}
