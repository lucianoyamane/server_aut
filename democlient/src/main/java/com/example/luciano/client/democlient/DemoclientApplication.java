package com.example.luciano.client.democlient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class DemoclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoclientApplication.class, args);
	}
}
