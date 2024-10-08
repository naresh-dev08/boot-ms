package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class BootMsProj12ShoppingServiceMsELKStackApplication {

	public static void main(String[] args) {
		log.info("Start of the application----ShoppingServiceMs");
		SpringApplication.run(BootMsProj12ShoppingServiceMsELKStackApplication.class, args);
		log.info("Application is boot strapped----ShoppingServiceMs");
		log.info("End of the application----ShoppingServiceMs");
	}

}
