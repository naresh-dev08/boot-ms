package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class BootMsProj12BillingServiceMsELKStackApplication {

	
	public static void main(String[] args) {
		log.info("start of the main method-----BillingServiceMs");
		SpringApplication.run(BootMsProj12BillingServiceMsELKStackApplication.class, args);
		log.info("Application is boot strapped------BillingServiceMs");
		log.info("End of the application---------BillingServiceMs");
	}

}
