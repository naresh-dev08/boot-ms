package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableEurekaServer
@Slf4j
public class BootMsProj12EurekaServerELKStackApplication {

	public static void main(String[] args) {
		log.info("Start of the application----EurekaServerMS");
		SpringApplication.run(BootMsProj12EurekaServerELKStackApplication.class, args);
		log.info("Application is boot strapped----EurekaServerMS");
		log.info("End of the application----EurekaServerMS");
	}

}
